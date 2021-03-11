package neuro.layer;

import neuro.activating.ActivatingFunction;
import neuro.neuron.HiddenNeuron;
import neuro.neuron.Neuron;

import java.util.ArrayList;
import java.util.List;

public abstract class Layer {
    protected List<Neuron> neurons;

    public Layer(List<Neuron> neurons) {
        this.neurons = neurons;
    }

    public Layer(){}

    public Layer generate(int neuronsAmount, int inputsAmount, ActivatingFunction activatingFunction){
        List<Neuron> neurons = new ArrayList<>(neuronsAmount);
        for (int i = 0; i < neuronsAmount; i++) {
            neurons.add(createNeuron(inputsAmount, activatingFunction));
        }
        this.neurons = neurons;
        return this;
    }

    protected abstract Neuron createNeuron(int inputsAmount, ActivatingFunction activatingFunction);
}
