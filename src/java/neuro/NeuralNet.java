package neuro;

import neuro.activating.ActivatingFunction;
import neuro.layer.HiddenLayer;
import neuro.layer.InputLayer;
import neuro.layer.Layer;
import neuro.layer.OutputLayer;
import vector.Vector;

import java.util.ArrayList;
import java.util.List;

public class NeuralNet {
    protected Layer inputLayer;
    protected List<Layer> hiddenLayers;
    protected Layer outputLayer;

    protected Vector inputs;
    protected Vector outputs;

    public NeuralNet(Layer inputLayer, List<Layer> hiddenLayers, Layer outputLayer) {
        //TODO: need to add validate layers
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
                    layers.add(new HiddenLayer().generate(neuronsAmountInHiddenLayer, inputsAmount, activatingFunction));
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

    public Vector activate(Vector inputs) {
        if (!isNetInitialized()) {
            throw new RuntimeException("The neural network is not initialized.");
        }
        if (inputs.size() != inputLayer.getInputsAmount()) {
            throw new IllegalArgumentException();
        }
        this.inputs = inputs;
        Vector dataBetweenLayers = inputLayer.activate(inputs);
        for (Layer hidden : hiddenLayers) {
            dataBetweenLayers = hidden.activate(dataBetweenLayers);
        }
        this.outputs = outputLayer.activate(dataBetweenLayers);
        return outputs;
    }

    protected void calcDelta(Vector outputIdeal) {
        Vector delta = ((OutputLayer) outputLayer).calcDeltas(outputIdeal);
        List<Vector> weights = outputLayer.getWeightsByInputs();
        for (int i = hiddenLayers.size() - 1; i >= 0; i--) {
            HiddenLayer hiddenLayer = (HiddenLayer) hiddenLayers.get(i);
            delta = hiddenLayer.calcDeltas(delta, weights);
            weights = hiddenLayer.getWeightsByInputs();
        }
    }

    public void train(Double learnRate, Double moment, Vector trainInput, Vector outputIdeal) {
        activate(trainInput);
        calcDelta(outputIdeal);
        outputLayer.update(learnRate, moment);
        hiddenLayers.forEach(h -> h.update(learnRate, moment));
    }

    protected boolean isNetInitialized() {
        return inputLayer != null && hiddenLayers != null && outputLayer != null;
    }
}
