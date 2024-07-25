package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

class DepositCommand implements Command{
    private ResourceBundle res = PropertyResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");
    @Override
    public void execute() throws InterruptOperationException {
        /**success.format=%d %s was deposited successfully
         invalid.data=Please specify valid data.**/
        ConsoleHelper.writeMessage(res.getString("before"));
        String nominal = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(nominal);
        String par = ConsoleHelper.readString();
        while (true) {
            String[] array = par.split(" ");
            try {
                if (array.length == 2) {
                    int parTemp = Integer.parseInt(array[0]);
                    int countTemp = Integer.parseInt(array[1]);
                    if (parTemp < 0 || countTemp < 0) {
                        ConsoleHelper.writeMessage(res.getString("invalid.data"));
                        par = ConsoleHelper.readString();
                    }else {
                        System.out.println(String.format(res.getString("success.format"), parTemp * countTemp, nominal));
                        manipulator.addAmount(parTemp, countTemp);
                        break;
                    }
                } else {
                    ConsoleHelper.writeMessage(res.getString("invalid.data"));
                    par = ConsoleHelper.readString();
                }
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
                par = ConsoleHelper.readString();
            }
        }
    }
}
