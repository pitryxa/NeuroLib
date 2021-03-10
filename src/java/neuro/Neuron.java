package neuro;

import neuro.activating.ActivatingFunction;
import neuro.activating.Sigmoid;
import vector.MultiplicationVector;
import vector.RandomVector;
import vector.Vector;

import java.util.Random;

public class Neuron {
    protected final int inputsAmount;
    protected Vector weights;
    protected Double bias;
    protected Double output;
    protected final ActivatingFunction activatingFunction;

    public Neuron(int inputsAmount) {
        this(inputsAmount, new Sigmoid());
    }

    public Neuron(int inputsAmount, ActivatingFunction activatingFunction) {
        this.inputsAmount = inputsAmount;
        this.weights = new RandomVector(inputsAmount);
        this.bias = new Random().nextDouble();
        this.activatingFunction = activatingFunction;
    }

    public void setWeights(Vector weights) {
        this.weights = weights;
    }

    public void setBias(Double bias) {
        this.bias = bias;
    }

    public Double getOutput() {
        return output;
    }

    public Double activate(Vector input) {
        this.output = activatingFunction.run(new MultiplicationVector(input, weights).get() + bias);
        return output;
    }
}
