package com.company;

import com.company.Models.*;
import java.time.LocalDateTime;
import java.util.Locale;

public class Main {

    public static Tree tree = new Tree();
    public static LocalDateTime start;

    public static void main(String[] args) throws Exception {

        start = LocalDateTime.now();
        if(args.length != 0) {
            if (!args[0].equals("")) {
                Converter.getInstance().GetTree(args[0]);
            }
        }

        while (true){
            Printer.getInstance().WriteLine("введите команду");
            String next = Printer.getInstance().ReadLine();
            boolean isCommand = false;
            for (Command command : CommandsManager.getInstance().getCommands()) {
                if (next.startsWith(command.getName()) || next.startsWith(command.getName().toLowerCase(Locale.ROOT))) {
                    command.Execute(next);
                    isCommand = true;
                    if(CommandsManager.getInstance().getLasts().size() == 9){
                        CommandsManager.getInstance().getLasts().remove(0);
                    }
                    CommandsManager.getInstance().getLasts().add(command.getName());
                }
            }
            if(!isCommand){
                Printer.getInstance().WriteLine("нет такой команды");
            }
        }
    }
}
