package neuro.layer;

import neuro.activating.ActivatingFunction;
import neuro.neuron.InputNeuron;
import neuro.neuron.Neuron;
import vector.Vector;

import java.util.ArrayList;
import java.util.List;

public class InputLayer extends Layer{

    public InputLayer(int neuronsAmount) {
        List<Neuron> neurons = new ArrayList<>(neuronsAmount);
        for (int i = 0; i < neuronsAmount; i++) {
            neurons.add(new InputNeuron());
        }
        this.neurons = neurons;
        this.outputsAmount = neuronsAmount;
        this.inputsAmount = neuronsAmount;
    }

    @Override
    protected Neuron createNeuron(int inputsAmount, ActivatingFunction activatingFunction) {
        return new InputNeuron();
    }

    @Override
    public Vector activate(Vector inputs) {
        int inputsSize = inputs.size();
        if (inputsSize != inputsAmount) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < inputsSize; i++) {
            ((InputNeuron) neurons.get(i)).activate(inputs.get(i));
        }
        outputs = inputs;
        return outputs;
    }
}
