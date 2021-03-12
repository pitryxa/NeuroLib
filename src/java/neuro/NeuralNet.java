package neuro;

import neuro.activating.ActivatingFunction;
import neuro.layer.HiddenLayer;
import neuro.layer.InputLayer;
import neuro.layer.Layer;
import neuro.layer.OutputLayer;

import java.util.ArrayList;
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

    public Layer inputLayer() {
        return inputLayer;
    }

    public List<Layer> hiddenLayers() {
        return hiddenLayers;
    }

    public Layer outputLayer() {
        return outputLayer;
    }

    public NeuralNet inputLayer(Layer inputLayer) {
        this.inputLayer = inputLayer;
        return this;
    }

    public NeuralNet hiddenLayers(List<Layer> hiddenLayers) {
        this.hiddenLayers = hiddenLayers;
        return this;
    }

    public NeuralNet outputLayer(Layer outputLayer) {
        this.outputLayer = outputLayer;
        return this;
    }

    public NeuralNet generate(int inputsAmount, int hiddenLayersAmount, int neuronsAmountInHiddenLayer, int outputsAmount, ActivatingFunction activatingFunction) {
        if (inputsAmount < 1 || hiddenLayersAmount < 0 || neuronsAmountInHiddenLayer < 1 || outputsAmount < 1) {
            throw new IllegalArgumentException();
        }
        this.inputLayer = new InputLayer(inputsAmount);
        int inputsAmountForOutputLayer = inputsAmount;
        if (hiddenLayersAmount > 0) {
            List<Layer> layers = new ArrayList<>(hiddenLayersAmount);
            for (int i = 0; i < hiddenLayersAmount; i++) {
                if (i == 0) {
                    layers.add(new HiddenLayer().generate(inputsAmount, neuronsAmountInHiddenLayer, activatingFunction));
                } else {
                    layers.add(new HiddenLayer().generate(neuronsAmountInHiddenLayer, neuronsAmountInHiddenLayer, activatingFunction));
                }
            }
            inputsAmountForOutputLayer = neuronsAmountInHiddenLayer;
            this.hiddenLayers = layers;
        }
        this.outputLayer = new OutputLayer().generate(outputsAmount, inputsAmountForOutputLayer, activatingFunction);
        return this;
    }
}
