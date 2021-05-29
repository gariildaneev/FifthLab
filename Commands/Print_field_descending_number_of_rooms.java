package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Flat;
import com.company.Printer;


public class Print_field_descending_number_of_rooms  implements Command {
    @Override
    public void Execute(String command) {
        try{
            for (Flat fl:Main.tree.getList().descendingSet()) {
                Printer.getInstance().WriteLine(fl.getNumberOfRooms());
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
