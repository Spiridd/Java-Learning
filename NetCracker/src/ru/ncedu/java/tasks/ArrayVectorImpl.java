package ru.ncedu.java.tasks;

/**
 * Created by dimon on 18.08.17.
 */
public class ArrayVectorImpl implements ArrayVector {
    private double[] vector;

    public ArrayVectorImpl() {
        this.vector = null;
    }

    @Override
    public void set(double... elements) {
        this.vector = elements;
    }

    @Override
    public double[] get() {
        return this.vector;
    }

    @Override
    public ArrayVector clone() {
        ArrayVector arrayVector = new ArrayVectorImpl();
        arrayVector.set(this.vector.clone());
        return arrayVector;
    }

    @Override
    public int getSize() {
        return this.vector.length;
    }

    @Override
    public void set(int index, double value) {
        if (index < 0)  return;
        if (index < this.getSize()) this.vector[index] = value;
        else {
            double[] array = new double[index+1];
            for(int i=0; i<this.getSize(); ++i) {
                array[i] = this.get()[i];
            }
            array[index] = value;
            this.set(array);
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        // исключение, наверно, само создастся?
        return this.get()[index];
    }

    @Override
    public double getMax() {
        // что делать, если пустой?
        double maxValue = this.get(0);
        for(int i=1; i<this.getSize(); ++i) {
            if (this.get(i) > maxValue) maxValue = this.get(i);
        }
        return maxValue;
    }

    @Override
    public double getMin() {
        // что делать, если пустой?
        double minValue = this.get(0);
        for(int i=1; i<this.getSize(); ++i) {
            if (this.get(i) < minValue) minValue = this.get(i);
        }
        return minValue;
    }

    @Override
    public void sortAscending() {
        // not stable
        for(int i=1; i<this.getSize(); ++i) {
            double elementToPut = this.get(i);
            int placeToPut = 0;
            while (elementToPut > this.get(placeToPut)) ++placeToPut;
            for(int k=i; k>placeToPut; --k) {
                this.set(k, this.get(k-1));
            }
            this.set(placeToPut, elementToPut);
        }
    }

    @Override
    public void mult(double factor) {
        for(int i=0; i<this.getSize(); ++i) {
            this.vector[i] *= factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        for(int i=0; i < (this.getSize() < anotherVector.getSize()
                ? this.getSize() : anotherVector.getSize()); ++i) {
            this.vector[i] += anotherVector.get(i);
        }
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double result = 0.0;
        for(int i=0; i < (this.getSize() < anotherVector.getSize()
                ? this.getSize() : anotherVector.getSize()); ++i) {
            result += this.get(i) * anotherVector.get(i);
        }
        return result;
    }

    @Override
    public double getNorm() {
        return Math.sqrt(this.scalarMult(this));
    }
}
