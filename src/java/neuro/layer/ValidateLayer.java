package neuro.layer;

import neuro.neuron.Neuron;

import java.util.List;

public class ValidateLayer {

    public ValidateLayer() {
    }

    public boolean isListNeuronsValid(List<Neuron> neurons) {
        return neurons != null && !neurons.isEmpty();
    }

    public boolean isSameNeuronsDimensions(List<Neuron> neurons) {
        int inputsAmount = neurons.get(0).getInputsAmount();
        for (Neuron n : neurons) {
            if (n.getInputsAmount() != inputsAmount) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidLayerState(Layer layer) {
        return
                isListNeuronsValid(layer.neurons) &&
                layer.outputsAmount > 0 &&
                layer.inputsAmount > 0;
    }
}
