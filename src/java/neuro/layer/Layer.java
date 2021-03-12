package neuro.layer;

import neuro.activating.ActivatingFunction;
import neuro.neuron.Neuron;
import vector.Vector;

import java.util.ArrayList;
import java.util.List;

public abstract class Layer {
    protected List<Neuron> neurons = null;
    protected Vector outputs = null;
    protected int outputsAmount = 0;
    protected int inputsAmount = 0;

    protected ValidateLayer validate = new ValidateLayer();

    public Layer(List<Neuron> neurons) {
        validate(neurons);
        this.neurons = neurons;
        this.outputsAmount = neurons.size();
        this.inputsAmount = neurons.get(0).getInputsAmount();
    }

    public Layer(){}

    public int getOutputsAmount() {
        return outputsAmount;
    }

    public int getInputsAmount() {
        return inputsAmount;
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    public Vector getOutputs() {
        return outputs;
    }

    public Layer generate(int neuronsAmount, int inputsAmount, ActivatingFunction activatingFunction){
        if (neuronsAmount < 1 || inputsAmount < 1) {
            throw new IllegalArgumentException();
        }
        List<Neuron> neurons = new ArrayList<>(neuronsAmount);
        for (int i = 0; i < neuronsAmount; i++) {
            neurons.add(createNeuron(inputsAmount, activatingFunction));
        }
        this.neurons = neurons;
        this.outputsAmount = neuronsAmount;
        this.inputsAmount = inputsAmount;
        return this;
    }

    public Vector activate(Vector inputs) {
        if (!validate.isValidLayerState(this)) {
            throw new RuntimeException("Invalid state of the layer.");
        }
        if (inputs.size() != inputsAmount) {
            throw new IllegalArgumentException("The number of inputs must be equal the number of inputs of the layer.");
        }
        Vector outputs = new Vector(outputsAmount);
        for (int i = 0; i < outputsAmount; i++) {
            outputs.put(i, neurons.get(i).activate(inputs));
        }
        this.outputs = outputs;
        return outputs;
    }

    protected abstract Neuron createNeuron(int inputsAmount, ActivatingFunction activatingFunction);

    protected void validate(List<Neuron> neurons){
        if (!validate.isListNeuronsValid(neurons)) {
            throw new IllegalArgumentException("List of neurons must not be null or empty.");
        }
        if (!validate.isSameNeuronsDimensions(neurons)) {
            throw new IllegalArgumentException("Neurons must have the same amount of inputs.");
        }
    }

}
