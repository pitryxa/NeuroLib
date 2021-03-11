package neuro.neuron;

import neuro.activating.ActivatingFunction;
import vector.MultiplicationVector;
import vector.RandomVector;
import vector.Vector;

import java.util.Random;

public abstract class Neuron {
    protected Vector weights = null;
    protected Double bias = null;
    protected Double output = null;
    protected ActivatingFunction activatingFunction = null;

    protected Neuron() {}

    protected Neuron(Vector weights, Double bias, ActivatingFunction activatingFunction) {
        this.weights = weights;
        this.bias = bias;
        this.activatingFunction = activatingFunction;
    }

    public Neuron setWeights(Vector weights) {
        this.weights = weights;
        return this;
    }

    public Neuron setBias(Double bias) {
        this.bias = bias;
        return this;
    }

    public Neuron setActivatingFunction(ActivatingFunction activatingFunction) {
        this.activatingFunction = activatingFunction;
        return this;
    }

    public Double out() {
        return output;
    }

    public void activate(Vector input) {
        if (!isValidNeuronState()) {
            throw new RuntimeException("Invalid state of the neuron.");
        }
        Vector dot = new MultiplicationVector(input, weights);
        this.output = activatingFunction.run(dot.get() + bias);
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
}
