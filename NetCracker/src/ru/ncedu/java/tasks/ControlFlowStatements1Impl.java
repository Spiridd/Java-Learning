package ru.ncedu.java.tasks;

/**
 * Created by dimon on 03.08.17.
 */
public class ControlFlowStatements1Impl implements ControlFlowStatements1 {
    @Override
    public float getFunctionValue(float x) {
        return (float)(x > 0 ? 2*Math.sin(x) : 6-x);
    }

    @Override
    public String decodeWeekday(int weekday) {
        switch (weekday) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "Error";
        }
    }

    @Override
    public int[][] initArray() {
        int[][] array = new int[8][5];
        for(int i=0; i<array.length; ++i)
            for(int j=0; j<array[i].length; ++j)
                array[i][j] = i*j;
        return array;
    }

    @Override
    public int getMinValue(int[][] array) {
        int minValue = array[0][0];
        for(int i=0; i<array.length; ++i)
            for(int j=0; j<array[i].length; ++j)
                if (array[i][j] < minValue) minValue = array[i][j];
        return minValue;
    }

    @Override
    public BankDeposit calculateBankDeposit(double P) {
        BankDeposit bankDeposit = new BankDeposit();
        final double minAmount = 5000;
        double currentAmount = 1000;
        int i = 1;
        for( ; (currentAmount *= (1+P/100)) < minAmount; ++i)
            ;
        bankDeposit.amount = currentAmount;
        bankDeposit.years = i;
        return bankDeposit;
    }
}
