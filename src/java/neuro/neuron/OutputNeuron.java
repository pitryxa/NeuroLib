package neuro.neuron;

import neuro.activating.ActivatingFunction;
import vector.Vector;

public class OutputNeuron extends Neuron {

    public OutputNeuron(Vector weights, Double bias, ActivatingFunction activatingFunction) {
        super(weights, bias, activatingFunction);
    }

    public OutputNeuron(){}
}
