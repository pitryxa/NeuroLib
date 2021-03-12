package neuro.layer;

import neuro.activating.ActivatingFunction;
import neuro.neuron.InputNeuron;
import neuro.neuron.Neuron;
import vector.Vector;

import java.util.ArrayList;
import java.util.List;

public class InputLayer extends Layer{

    public InputLayer(Vector inputs) {
        int inputsAmount = inputs.size();
        List<Neuron> neurons = new ArrayList<>(inputsAmount);
        for (Double input : inputs.toArray()) {
            neurons.add(new InputNeuron(input));
        }
        this.neurons = neurons;
        this.inputsAmount = inputsAmount;
        this.outputsAmount = inputsAmount;
        this.outputs = inputs;
    }

    @Override
    protected Neuron createNeuron(int inputsAmount, ActivatingFunction activatingFunction) {
        return null;
    }

    public Vector activate() {
        return outputs;
    }
}
