package neuro.neuron;

import neuro.activating.ActivatingFunction;
import vector.AdditionVector;
import vector.MultiplicationVector;
import vector.ScalarMultiplicationVector;
import vector.Vector;

public class HiddenNeuron extends Neuron{

    public HiddenNeuron(Vector weights, Double bias, ActivatingFunction activatingFunction) {
        super(weights, bias, activatingFunction);
    }

    public HiddenNeuron() {
    }

    protected void train(Vector deltasPrevLayer, Double outputIdeal, Double learnRate) {
        this.delta = activatingFunction.derivative(output) * new MultiplicationVector(weights, deltasPrevLayer).get();

        Vector deltaWeights = new ScalarMultiplicationVector(inputs, delta * learnRate);
        this.weights = new AdditionVector(weights, deltaWeights);
    }
}
