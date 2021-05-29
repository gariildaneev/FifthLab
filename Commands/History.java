package com.company.Commands;

import com.company.Command;
import com.company.CommandsManager;
import com.company.Main;
import com.company.Printer;

public class History implements Command {
    @Override
    public void Execute(String command) {
        for (String a: CommandsManager.getInstance().getLasts()) {
            Printer.getInstance().WriteLine("команда: " + a);
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
