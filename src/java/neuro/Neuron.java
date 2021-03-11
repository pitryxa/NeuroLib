package neuro;

import neuro.activating.ActivatingFunction;
import vector.MultiplicationVector;
import vector.Vector;

public abstract class Neuron {
    protected int inputsAmount = 0;
    protected Vector weights = null;
    protected Double bias = null;
    protected Double output = null;
    protected ActivatingFunction activatingFunction = null;

    public Neuron() {}

    public Neuron(Vector weights, Double bias, ActivatingFunction activatingFunction) {
        this.inputsAmount = weights.size();
        this.weights = weights;
        this.bias = bias;
        this.activatingFunction = activatingFunction;
    }

    public Neuron setWeights(Vector weights) {
        this.weights = weights;
        this.inputsAmount = weights.size();
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
                inputsAmount == weights.size() &&
                bias != null &&
                activatingFunction != null;
    }
}
