package neuro.neuron;

import neuro.activating.ActivatingFunction;
import vector.AdditionVector;
import vector.ScalarMultiplicationVector;
import vector.Vector;

public class OutputNeuron extends Neuron {

    public OutputNeuron(){}

    public OutputNeuron(Vector weights, Double bias, ActivatingFunction activatingFunction) {
        super(weights, bias, activatingFunction);
    }

    protected void train(Double outputIdeal, Double learnRate) {
        this.delta = activatingFunction.derivative(output) * (outputIdeal - output);

        Vector deltaWeights = new ScalarMultiplicationVector(inputs, delta * learnRate);
        this.weights = new AdditionVector(weights, deltaWeights);
    }


}
