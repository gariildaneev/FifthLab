package com.company.Commands;

import com.company.Command;
import com.company.CommandsManager;
import com.company.Main;
import com.company.Printer;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class Execute_script implements Command {
    @Override
    public void Execute(String command)  {
        if(command.split(",",2).length != 2){
            Printer.getInstance().WriteLine("введите путь");
            Execute(getName() + "," + Printer.getInstance().ReadLine());
        }
        else {
            try {
                Scanner scanner = new Scanner(new File(command.split(",", 2)[1].trim()));
                while (true) {
                    Printer.getInstance().WriteLine("введите команду");
                    String next = scanner.nextLine();
                    boolean isCommand = false;
                    for (Command commands : CommandsManager.getInstance().getCommands()) {
                        if (next.startsWith(commands.getName()) || next.startsWith(commands.getName().toLowerCase(Locale.ROOT))) {
                            commands.Execute(next);
                            isCommand = true;
                            if (CommandsManager.getInstance().getLasts().size() == 9) {
                                CommandsManager.getInstance().getLasts().remove(0);
                            }
                            CommandsManager.getInstance().getLasts().add(commands.getName());
                        }
                    }
                    if (!isCommand) {
                        Printer.getInstance().WriteLine("нет такой команды");
                    }
                }
            }
            catch (Exception w){
                Printer.getInstance().WriteLine(w.getMessage());
            }
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
