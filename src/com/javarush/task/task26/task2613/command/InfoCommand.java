package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

class InfoCommand implements Command{
     private ResourceBundle res = PropertyResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");
    @Override
    public void execute() {
        Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        boolean hasMoney = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        for(CurrencyManipulator manipulator: manipulators){
            if (manipulator.hasMoney()) {
                hasMoney = true;
                String res = String.format("%s - %d", manipulator.getCurrencyCode(), manipulator.getTotalAmount());
                System.out.println(res);
            }
        }
        if(!hasMoney) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
