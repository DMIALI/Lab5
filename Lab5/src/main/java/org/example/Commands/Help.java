package org.example.Commands;

import org.example.Commands.CommandData.InputCommandData;
import org.example.utils.Printer;

import java.util.*;

public class Help extends Command {
    public Help () {
        super("вывести справку по доступным командам");
    }

    @Override
    public void execute(InputCommandData input){
        Printer printer = input.printer();
        HashMap<String, Command> commandMap = input.commandMap();
        StringBuilder out = new StringBuilder();
        Set <String> keys = commandMap.keySet();
        for (String key:keys){
            out.append(key).append(" - ").append(commandMap.get(key).getFunctionality()).append("\n");
        }
        printer.outPrint(out.toString());
    }
}
