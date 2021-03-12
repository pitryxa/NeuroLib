package neuro.layer;

import neuro.activating.ActivatingFunction;
import neuro.neuron.HiddenNeuron;
import neuro.neuron.Neuron;

import java.util.ArrayList;
import java.util.List;

public class HiddenLayer extends Layer{
    public HiddenLayer(List<Neuron> neurons) {
        super(neurons);
    }

    public HiddenLayer() {
    }

    @Override
    protected Neuron createNeuron(int inputsAmount, ActivatingFunction activatingFunction) {
        return new HiddenNeuron().generate(inputsAmount, activatingFunction);
    }
}
