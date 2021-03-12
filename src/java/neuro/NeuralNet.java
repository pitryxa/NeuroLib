package neuro;

import neuro.layer.InputLayer;
import neuro.layer.Layer;

import java.util.List;

public class NeuralNet {
    protected Layer inputLayer;
    protected List<Layer> hiddenLayers;
    protected Layer outputLayer;

    public NeuralNet(Layer inputLayer, List<Layer> hiddenLayers, Layer outputLayer) {
        this.inputLayer = inputLayer;
        this.hiddenLayers = hiddenLayers;
        this.outputLayer = outputLayer;
    }

    public NeuralNet() {
    }

    public NeuralNet generate(int inputsAmount, int hiddenLayersAmount, int neuronsAmountInHiddenLayer, int outputsAmount) {
        if (inputsAmount < 1 || hiddenLayersAmount < 0 || neuronsAmountInHiddenLayer < 1 || outputsAmount < 1) {
            throw new IllegalArgumentException();
        }
        inputLayer = new InputLayer(inputsAmount);


        return this;
    }
}
