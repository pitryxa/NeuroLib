package neuro;

import neuro.activating.SimpleLinear;
import vector.Vector;

public class InputNeuron extends Neuron{

    public InputNeuron(Double input) {
        super(
                new Vector(new Double[]{1.}),
                0.,
                new SimpleLinear()
        );
        activate(new Vector(new Double[]{input}));
    }
}
