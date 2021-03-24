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

    public Double calcDelta(Double outputIdeal) {
        this.delta = activatingFunction.derivative(output) * (outputIdeal - output);
        return delta;
    }
}
