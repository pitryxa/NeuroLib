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

    public Double calcDelta(Vector deltasPrevLayer, Vector weightsPrevLayer) {
        this.delta = activatingFunction.derivative(output) * new MultiplicationVector(weightsPrevLayer, deltasPrevLayer).get();
        return delta;
    }
}
