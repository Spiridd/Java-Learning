package ru.ncedu.java.tasks;

/**
 * Created by dimon on 03.08.17.
 */
public class ControlFlowStatements3Impl implements ControlFlowStatements3 {
    @Override
    public double getFunctionValue(double x) {
        if (x < 0)      return -x;
        else if (x > 2) return 4.0;
        else            return x*x;
    }

    @Override
    public String decodeSeason(int monthNumber) {
        switch (monthNumber) {
            case 1:
            case 2:
            case 12:
                return "Winter";
            case 3:
            case 4:
            case 5:
                return "Spring";
            case 6:
            case 7:
            case 8:
                return "Summer";
            case 9:
            case 10:
            case 11:
                return "Autumn";
            default:
                return "Error";
        }
    }

    @Override
    public long[][] initArray() {
        long[][] array = new long[8][5];
        for(int i=0; i<array.length; ++i)
            for(int j=0; j<array[i].length; ++j)
                array[i][j] = (long)Math.pow(Math.abs(i-j), 5);
        return array;
    }

    @Override
    public int getMaxProductIndex(long[][] array) {
        int rowIndex = 0;
        long[] row = array[rowIndex];
        long maxProduct = 1;
        for (long elem : row) maxProduct *= elem;
        maxProduct = Math.abs(maxProduct);

        for(int i=1; i<array.length; ++i) {
            row = array[i];
            long product = 1;
            for (long elem : row) product *= elem;
            product = Math.abs(product);
            if (product > maxProduct) {
                maxProduct = product;
                rowIndex = i;
            }
        }
        return rowIndex;
    }

    @Override
    public float calculateLineSegment(float A, float B) {
        while ((A -= B) >= 0.0f)
            ;
        return A+B;
    }
}
