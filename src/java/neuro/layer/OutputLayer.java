package neuro.layer;

import neuro.activating.ActivatingFunction;
import neuro.neuron.Neuron;
import neuro.neuron.OutputNeuron;

import java.util.List;

public class OutputLayer extends Layer{

    public OutputLayer(List<Neuron> neurons) {
        super(neurons);
    }

    public OutputLayer() {

    }

    @Override
    protected Neuron createNeuron(int inputsAmount, ActivatingFunction activatingFunction) {
        return new OutputNeuron().generate(inputsAmount, activatingFunction);
    }
}
