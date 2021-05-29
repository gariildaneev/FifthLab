package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Printer;

public class Clear implements Command {
    @Override
    public void Execute(String command) throws Exception {
        Main.tree.getList().clear();
        Printer.getInstance().WriteLine("список очищен");
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
