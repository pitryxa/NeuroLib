package neuro.layer;

import neuro.activating.ActivatingFunction;
import neuro.neuron.Neuron;
import neuro.neuron.OutputNeuron;
import vector.Vector;

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

    public Vector calcDeltas(Vector outputIdeal) {
        if (outputIdeal.size() != outputsAmount) {
            throw new IllegalArgumentException("Wrong size of the input vector.");
        }
        Vector deltas = new Vector(outputsAmount);
        for (int i = 0; i < outputsAmount; i++) {
            deltas.put(i, ((OutputNeuron) neurons.get(i)).calcDelta(outputIdeal.get(i)));
        }
        this.deltas = deltas;
        return deltas;
    }
}
