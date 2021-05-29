package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Printer;

public class Info implements Command {
    @Override
    public void Execute(String command)  {
        Printer.getInstance().WriteLine("начало старта: " + Main.start.toString() + "\r\nкол-во элементов: " + Main.tree.getList().size());
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
