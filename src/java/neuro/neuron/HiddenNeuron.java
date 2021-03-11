package neuro.neuron;

import neuro.activating.ActivatingFunction;
import vector.Vector;

public class HiddenNeuron extends Neuron{

    public HiddenNeuron(Vector weights, Double bias, ActivatingFunction activatingFunction) {
        super(weights, bias, activatingFunction);
    }

    public HiddenNeuron() {
    }
}
