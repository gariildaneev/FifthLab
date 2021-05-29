package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Tree;
import com.company.Printer;

public class Add implements Command {
    @Override
    public void Execute(String command) {
        try{
            Main.tree.getList().add(Tree.get_Flat());
        }
        catch (Exception e){
            Printer.getInstance().WriteLine("неправильно введена команда: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
