package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Flat;
import com.company.Models.Tree;
import com.company.Printer;

public class Remove_lower  implements Command {
    @Override
    public void Execute(String command) {
        try{
            Flat flat = Tree.get_Flat();
            Main.tree.getList().removeIf(u -> u.compareTo(flat) < 0);
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
