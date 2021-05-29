package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Printer;

public class Remove_by_id implements Command {
    @Override
    public void Execute(String command) throws Exception {
        if(command.split(",",2).length == 2) {
            try {
                int id = Integer.parseInt(command.split(",", 2)[1].trim());
                if (Main.tree.getList().removeIf(flat -> id == flat.getId())) {
                    Printer.getInstance().WriteLine("элемент удален");
                } else {
                    Printer.getInstance().WriteLine("элемент не удален");
                }
            }
            catch (NumberFormatException e){
                Printer.getInstance().WriteLine("неправильно введено число, повторите");
                Execute(getName() + "," + Printer.getInstance().ReadLine());
            }
        }
        else{
            Printer.getInstance().WriteLine("число не введено. Введите его");
            Execute(getName() + "," + Printer.getInstance().ReadLine());
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
