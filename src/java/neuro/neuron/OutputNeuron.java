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

    public void train(Double outputIdeal, Double learnRate, Double moment) {
        this.delta = activatingFunction.derivative(output) * (outputIdeal - output);
        this.deltaWeights = calcDeltaWeights(learnRate, moment);
        this.weights = updateWeights();
        this.bias = updateBias(learnRate, moment);
    }


}
