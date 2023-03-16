package org.example.Commands;

import org.example.Commands.CommandData.InputCommandData;
import org.example.utils.Printer;

import java.util.*;

/**
 * Class-command for displaying information about commands
 */
public class Help extends Command {
    /**
     * Constructor responsible for describing the functionality of the command
     */
    public Help () {
        super("вывести справку по доступным командам");
    }

    /**
     * Method that print information about commands
     * @param input {@link InputCommandData}
     */
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
