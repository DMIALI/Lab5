package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.utils.IdManager;
import org.example.utils.Operation;
import org.example.utils.Printer;
import org.example.utils.RepeatInput;

import java.util.Scanner;

public class Add extends Command{

    public Add () {
        super("добавить новый элемент в коллекцию");
    }

    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        IdManager idManager = collectionManager.getIdManager();
        Scanner scanner = input.scanner();
        Printer printer = input.printer();
        Long id = idManager.add();
        String name = receiveName(scanner, printer);

    }

    public String receiveName(Scanner scanner, Printer printer){
        printer.outPrintln("Введите координаты:");
        String x = scanner.nextLine();
        x.StringUtils.isNumeric();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                return !input.equals("");
            }
        };
        if (!func.execute(name)) {
            RepeatInput.go(name, "Название не может быть пустым", func, scanner, printer);
        }
        return name;
    }

    public String receiveCoordinates(Scanner scanner, Printer printer){
        printer.outPrintln("Введите название:");
        String name = scanner.nextLine();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                return !input.equals("");
            }
        };
        if (!func.execute(name)) {
            RepeatInput.go(name, "Название не может быть пустым", func, scanner, printer);
        }
        return name;
    }
}
