package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class LoginCommand implements Command{
    /**..before=Logging in...
     ..specify.data=Please specify your credit card number and pin code or type 'EXIT' for exiting.
     ..success.format=Credit card [%s] is verified successfully!
     ..not.verified.format=Credit card [%s] is not verified.
     ..try.again.or.exit=Please try again or type 'EXIT' for urgent exiting
     ..try.again.with.details=Please specify valid credit card number - 12 digits, pin code - 4 digits.**/
    private ResourceBundle validCreditCards = PropertyResourceBundle.getBundle(CashMachine.class.getPackage().getName() + "verifiedCards");
    private ResourceBundle res = PropertyResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".resources.login_en");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage(res.getString("specify.data"));
        String forNum = ConsoleHelper.readString();
        String forPin = ConsoleHelper.readString();
        while (true){
            if(forNum.length() != 12 || forPin.length() != 4){
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
            if(validCreditCards.containsKey(forNum) && validCreditCards.getString(forNum).equals(forPin)){
                ConsoleHelper.writeMessage(res.getString(String.format(res.getString("success.format"), forNum)));
                break;
            }
            ConsoleHelper.writeMessage(res.getString(String.format(res.getString("not.verified"), forNum)));
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            forNum = ConsoleHelper.readString();
            forPin = ConsoleHelper.readString();
        }
    }
}