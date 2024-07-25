package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

class WithdrawCommand implements Command{
    /**..before=Withdrawing...
     ..success.format=%d %s was withdrawn successfully
     ..specify.amount=Please specify integer amount for withdrawing.
     ..specify.not.empty.amount=Please specify valid positive integer amount for withdrawing.
     ..not.enough.money=Not enough money on your account, please try again
     ..exact.amount.not.available=Exact amount is not available**/
    private ResourceBundle res = PropertyResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException {
        System.out.println(res.getString("before"));
        String codeNominal = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(codeNominal);
        ConsoleHelper.writeMessage(res.getString("specify.amount"));
        String result = getValidTwoDigits(ConsoleHelper.readString());
        int sum = Integer.parseInt(result);
        if(manipulator.isAmountAvailable(sum)) {
            try {
                System.out.println(manipulator.withdrawAmount(sum));
                ConsoleHelper.writeMessage(String.format(res.getString("format"), sum, codeNominal));
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
        }
    }
    private String getValidTwoDigits(String res) throws InterruptOperationException {
        try{
            int parTemp = Integer.parseInt(res);
            if (parTemp < 0) {
                System.out.println(this.res.getString("specify.not.empty.amount"));
                res = getValidTwoDigits(ConsoleHelper.readString());
            }
            System.out.println("Successful");
        }catch (NumberFormatException e){
            ConsoleHelper.writeMessage(this.res.getString("exact.amount.not.available"));
            res = getValidTwoDigits(ConsoleHelper.readString());
        }
        return res;
    }
}
