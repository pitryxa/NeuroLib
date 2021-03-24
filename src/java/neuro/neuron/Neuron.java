package neuro.neuron;

import neuro.activating.ActivatingFunction;
import vector.*;

import java.util.Random;

public abstract class Neuron {
    protected Vector inputs = null;
    protected Vector weights = null;
    protected Double bias = null;
    protected Double output = null;
    protected ActivatingFunction activatingFunction = null;
    protected Double delta;
    protected Vector deltaWeights = null;
    protected Double deltaBias = 0.0;

    protected Neuron() {}

    protected Neuron(Vector weights, Double bias, ActivatingFunction activatingFunction) {
        this.weights = weights;
        this.bias = bias;
        this.activatingFunction = activatingFunction;
        this.deltaWeights = new ZeroVector(weights.size());
    }

    public Neuron setWeights(Vector weights) {
        if (weights.size() != this.weights.size()) {
            throw new IllegalArgumentException("The size of the input weights must be equal count of the inputs of the neuron.");
        }
        this.weights = weights;
        this.deltaWeights = new ZeroVector(weights.size());
        return this;
    }

    public Vector getWeights() {
        return weights;
    }

    public Neuron setBias(Double bias) {
        this.bias = bias;
        return this;
    }

    public Double getBias() {
        return bias;
    }

    public Neuron setActivatingFunction(ActivatingFunction activatingFunction) {
        this.activatingFunction = activatingFunction;
        return this;
    }

    public ActivatingFunction getActivatingFunction() {
        return activatingFunction;
    }

    public Double getOutput() {
        return output;
    }

    public Double activate(Vector input) {
        if (!isValidNeuronState()) {
            throw new RuntimeException("Invalid state of the neuron.");
        }
        if (input.size() != weights.size()) {
            throw new IllegalArgumentException("The number of inputs must be equal the number of weights.");
        }
        this.inputs = input;
        Vector dot = new MultiplicationVector(input, weights);
        this.output = activatingFunction.run(dot.get() + bias);
        return output;
    }

    protected boolean isValidNeuronState() {
        return
                weights != null &&
                bias != null &&
                activatingFunction != null;
    }

    public Neuron generate(int inputsAmount, ActivatingFunction activatingFunction) {
        this.weights = new RandomVector(inputsAmount);
        this.bias = new Random().nextDouble();
        this.activatingFunction = activatingFunction;
        return this;
    }

    public int getInputsAmount() {
        return weights.size();
    }

    public Double getDelta() {
        return delta;
    }

    protected Vector calcDeltaWeights(Double learnRate, Double moment) {
        return new AdditionVector(
                new ScalarMultiplicationVector(inputs, delta * learnRate),
                new ScalarMultiplicationVector(deltaWeights, moment)
        );
    }

    protected Vector updateWeights() {
        return new AdditionVector(weights, deltaWeights);
    }

    protected Double updateBias(Double learnRate, Double moment) {
        this.deltaBias = delta * learnRate + deltaBias * moment;
        return bias + deltaBias;
    }
}
