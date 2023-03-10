package org.example.Commands;

import org.example.Commands.CommandData.InputCommandData;
import org.example.utils.Printer;

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
    public void execute(InputCommandData input){
        Printer printer = input.printer();
        StringBuilder out = new StringBuilder();
        Set <String> keys = commandMap.keySet();
        for (String key:keys){
            out.append(key).append(" - ").append(commandMap.get(key).getFunctionality()).append("\n");
        }
        printer.outPrintln(out.toString());
    }
}