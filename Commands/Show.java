package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Flat;
import com.company.Printer;

public class Show implements Command {
    @Override
    public void Execute(String command) {
        if(Main.tree.getList().size() != 0) {
            for (Flat flat : Main.tree.getList()) {
                Printer.getInstance().WriteLine(flat.toString());
            }
        }
        else{
            Printer.getInstance().WriteLine("ни одного элемента нет");
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
