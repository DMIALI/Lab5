package org.example.Commands;

import org.example.Commands.CommandData.InputCommandData;
import org.example.utils.Printer;

import java.util.Scanner;

/**
 * Class-command to complete the work
 */
public class Exit extends Command{
    /**
     * Constructor responsible for describing the functionality of the command
     */
    public Exit() {
        super("завершить программу (без сохранения в файл)");
    }

    /**
     * @param input
     * Method that stopped program
     */
    @Override
    public void execute(InputCommandData input) {
        Printer printer = input.printer();
        Scanner scanner = input.scanner();
        printer.outPrintln("Все несохраненные изменения будут удалены, вы уверены?");
        printer.outPrint("[y/n] ");
        String ans = scanner.nextLine();
        if (ans.equalsIgnoreCase("y")||ans.equalsIgnoreCase("yes")){
            printer.outPrintln("Приложение сейчас закроется....");
            printer.exit(0);
        }
    }
}
