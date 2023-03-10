package org.example.Commands;

import org.example.Commands.CommandData.InputCommandData;
import org.example.utils.Printer;

import java.util.Scanner;

public class Exit extends Command{
    public Exit() {
        super("завершить программу (без сохранения в файл)");
    }

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
