package com.company;

import com.company.Commands.*;
import java.util.ArrayList;

public class CommandsManager {

    private final ArrayList<Command> commands = new ArrayList<>();
    private static CommandsManager instance;
    private static ArrayList<String> lasts = new ArrayList<>();

    private CommandsManager() {
        commands.add(new Help());
        commands.add(new Remove_by_id());
        commands.add(new Info());
        commands.add(new Show());
        commands.add(new Clear());
        commands.add(new Exit());
        commands.add(new History());
        commands.add(new Save());
        commands.add(new Execute_script());
        commands.add(new Add());
        commands.add(new Update_by_id());
        commands.add(new Add_if_min());
        commands.add(new Remove_less_then_view());
        commands.add(new Print_field_descending_number_of_rooms());
        commands.add(new Remove_lower());
    }

    public static CommandsManager getInstance() {
        if(instance == null){
            instance = new CommandsManager();
        }
        return instance;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public ArrayList<String> getLasts() {
        return lasts;
    }

    public void setLasts(ArrayList<String> lasts) {
        CommandsManager.lasts = lasts;
    }
}
