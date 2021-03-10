package neuro.activating;

import vector.Vector;

public abstract class ActivatingFunction {
    public abstract Double run(Double x);

    public Vector run(Vector x){
        int size = x.size();
        Vector output = new Vector(size);
        for (int i = 0; i < size; i++) {
            output.put(i, run(x.get(i)));
        }
        return output;
    }
}
