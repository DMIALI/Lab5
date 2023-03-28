package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.utils.Printer;

import java.io.*;
import java.util.*;

/**
 * Class-command for executing a commands from a file
 */
public class ExecuteScript extends Command {
    ArrayList<String> scripts = new ArrayList<>();

    /**
     * Constructor responsible for describing the functionality of the command
     */
    public ExecuteScript() {
        super("считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    /**
     * Method that executes commands from a file
     * @param input {@link InputCommandData}
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
            printer.outPrintln(args.get(0));
            File file = new File(args.get(0));

            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String command;
                int lineCounter = 1;
                ArrayList<ArrayList<String>> commands = new ArrayList<ArrayList<String>>();
                while ((command = bufferedReader.readLine()) != null) {
                    ArrayList<String> listOfCommand = new ArrayList<String>();
                    Collections.addAll(listOfCommand, command.split(" "));
                    String name = listOfCommand.get(0);
                    try {
                        if (command.equals("execute_script")) {
                            if (scripts.contains(listOfCommand.get(1))) {
                                printer.errPrintln("Обнаружены рекурсивные скрипты");
                                return;
                            } else {
                                scripts.add(listOfCommand.get(1));
                            }
                        }
                        commandMap.get(name);
                        commands.add(listOfCommand);
                    } catch (NullPointerException e) {
                        printer.errPrintln("Команда не найдена: Строка " + Integer.toString(lineCounter) + ' ' + name);
                    } finally {
                        lineCounter++;
                    }
                }
                for (ArrayList<String> i : commands){
                    String name = i.remove(0);
                    commandMap.get(name).execute(new InputCommandData(collectionManager, scanner, printer, i, commandMap));
                }

            } catch (IOException e) {
                printer.errPrintln("Ошибка чтения файла: " + String.valueOf(e));
            }

        }
    }
}
