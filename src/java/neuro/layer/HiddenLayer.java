package neuro.layer;

import neuro.activating.ActivatingFunction;
import neuro.neuron.HiddenNeuron;
import neuro.neuron.Neuron;
import neuro.neuron.OutputNeuron;
import vector.Vector;

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

    public Vector calcDeltas(Vector deltasPrevLayer, List<Vector> weightsPrevLayer) {
        if (deltasPrevLayer == null || weightsPrevLayer == null || weightsPrevLayer.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (weightsPrevLayer.size() != outputsAmount || deltasPrevLayer.size() != weightsPrevLayer.get(0).size()) {
            throw new IllegalArgumentException("Wrong size of the input data.");
        }
        Vector deltas = new Vector(outputsAmount);
        for (int i = 0; i < outputsAmount; i++) {
            deltas.put(i, ((HiddenNeuron) neurons.get(i)).calcDelta(deltasPrevLayer, weightsPrevLayer.get(i)));
        }
        this.deltas = deltas;
        return deltas;
    }
}
