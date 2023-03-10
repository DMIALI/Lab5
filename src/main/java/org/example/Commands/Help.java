package org.example.Commands;

import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.*;

public class Help extends Command {
    private HashMap<String, Command> commandMap;
    public Help () {
        super("вывести справку по доступным командам");
    }

    public void addCommandMap(HashMap<String, Command> CommandMap){
        this.commandMap = CommandMap;
    }

    @Override
    public OutputCommandData execute(InputCommandData input){
        StringBuilder out = new StringBuilder();
        Set <String> keys = commandMap.keySet();
        for (String key:keys){
            out.append(key).append(" - ").append(commandMap.get(key).getFunctionality()).append("\n");
        }
        return new OutputCommandData(out.toString());
    }
}