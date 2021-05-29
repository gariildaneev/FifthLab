package com.company.Commands;

import com.company.Command;
import com.company.Converter;
import com.company.Main;
import com.company.Printer;

public class Save implements Command {
    @Override
    public void Execute(String command) throws Exception {
        if(command.split(",",2).length != 2){
            Printer.getInstance().WriteLine("введите путь");
            Execute(getName() + "," + Printer.getInstance().ReadLine());
        }
        else {
            Converter.getInstance().SetTree(command.split(",", 2)[1].trim());
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
