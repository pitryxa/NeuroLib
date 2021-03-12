package neuro.neuron;

import neuro.activating.ActivatingFunction;
import neuro.activating.SimpleLinear;
import vector.Vector;

public class InputNeuron extends Neuron{

    public InputNeuron() {
        super(
                new Vector(new Double[]{1.}),
                0.,
                new SimpleLinear()
        );
    }

    public Double activate(Double input) {
        this.output = input;
        return output;
    }

    @Override
    public Neuron generate(int inputsAmount, ActivatingFunction activatingFunction) {
        return this;
    }

    @Override
    public Neuron setWeights(Vector weights) {
        return this;
    }

    @Override
    public Neuron setBias(Double bias) {
        return this;
    }

    @Override
    public Neuron setActivatingFunction(ActivatingFunction activatingFunction) {
        return this;
    }
}
