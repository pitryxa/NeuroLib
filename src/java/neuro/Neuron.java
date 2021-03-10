package neuro;

import neuro.activating.ActivatingFunction;
import neuro.activating.Sigmoid;
import vector.Vector;

public class Neuron {
    protected final int inputAmount;
    protected Vector weights;
    protected Vector inputs;
    protected final ActivatingFunction activatingFunction;

    public Neuron(Vector weights, ActivatingFunction activatingFunction) {
        this.inputAmount = weights.size();
        this.weights = weights;
        this.activatingFunction = activatingFunction;
    }

    public Neuron(int inputAmount) {
        this.inputAmount = inputAmount;
        this.weights = new Vector(inputAmount);
        this.activatingFunction = new Sigmoid();
    }
}
