package ru.ncedu.java.tasks;

/**
 * Created by dimon on 03.08.17.
 */
public class Play {
    public static void main(String[] args) {
        ControlFlowStatements1Impl c = new ControlFlowStatements1Impl();
        ControlFlowStatements1.BankDeposit bankDeposit = c.calculateBankDeposit(50);
        System.out.println(bankDeposit);
    }
}
