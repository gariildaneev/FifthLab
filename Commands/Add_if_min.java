package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Flat;
import com.company.Models.Tree;
import com.company.Printer;

public class Add_if_min implements Command {
    @Override
    public void Execute(String command) {
        try{
            Flat flat = Tree.get_Flat();
            if(flat.compareTo(Main.tree.getList().first()) > 0){
                Main.tree.getList().add(flat);
                Printer.getInstance().WriteLine("успех");
            }
            else{
                Printer.getInstance().WriteLine("неудача");
            }
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
