package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.utils.Printer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class-command for executing a commands from a file
 */
public class ExecuteScript extends Command {

    /**
     * Constructor responsible for describing the functionality of the command
     */
    public ExecuteScript() {
        super("считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    /**
     * @param input
     * Method that executes commands from a file
     */
    @Override
    public void execute(InputCommandData input) {
        ArrayList<String> args = input.args();
        Printer printer = input.printer();
        Scanner scanner = input.scanner();
        HashMap<String, Command> commandMap = input.commandMap();
        CollectionManager collectionManager = input.collectionManager();
        if (args.size() < 1) {
            printer.errPrintln("Отсутствуют необходимые аргументы (путь к файлу)");
        } else {
            File file = new File(args.get(0));
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String command;
                int lineCounter = 1;
                while ((command = bufferedReader.readLine()) != null) {
                    ArrayList<String> listOfCommand = new ArrayList<String>();
                    Collections.addAll(listOfCommand, command.split(" "));
                    String name = listOfCommand.remove(0);
                    try {
                        commandMap.get(name).execute(new InputCommandData(collectionManager, scanner, printer, listOfCommand, commandMap));
                    }
                    catch (NullPointerException e) {
                        printer.errPrintln("Команда не найдена: Строка "+ Integer.toString(lineCounter) + ' ' + name);
                    }
                    finally {
                        lineCounter ++;
                    }
                }
            } catch (IOException e) {
                printer.errPrintln("Ошибка чтения файла: " + String.valueOf(e));
            }

        }
    }
}
