package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Flat;
import com.company.Models.Tree;
import com.company.Printer;

public class Update_by_id implements Command {
    @Override
    public void Execute(String command) {
            String[] sp = command.split(",",2);
            if(sp.length == 2) {
                Flat flat = Tree.get_Flat();
                if(Main.tree.getList().removeIf(i -> i.getId() == Integer.parseInt(sp[1]))){
                    flat.setId(Integer.parseInt(sp[1]));
                    Main.tree.getList().add(flat);
                }
                else{
                    Printer.getInstance().WriteLine("нет такого id");
                }
            }
            else{
                Printer.getInstance().WriteLine("введите квартиру");
                Execute(getName() + "," + Printer.getInstance().ReadLine());
            }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
