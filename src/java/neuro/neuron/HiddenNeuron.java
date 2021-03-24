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

    public void train(Vector deltasPrevLayer, Vector weightsPrevLayer, Double learnRate, Double moment) {
        this.delta = activatingFunction.derivative(output) * new MultiplicationVector(weightsPrevLayer, deltasPrevLayer).get();
        this.deltaWeights = calcDeltaWeights(learnRate, moment);
        this.weights = updateWeights();
        this.bias = updateBias(learnRate, moment);
    }
}
