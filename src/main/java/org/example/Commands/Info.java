package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.utils.Printer;

import java.util.ArrayList;

/**
 * Class-command for displaying information about the collection
 */
public class Info extends Command{
    /**
     * Constructor responsible for describing the functionality of the command
     */
    public Info () {
        super("вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }

    /**
     * @param input
     * Method that print information about the collection
     */
    @Override
    public void execute(InputCommandData input) {
        Printer printer = input.printer();
        CollectionManager collectionManager = input.collectionManager();
        printer.outPrintln("Информация о коллекции: ");
        printer.outPrintln("Тип: LinkedList");
        printer.outPrint("Дата инициализации: ");
        printer.outPrintln(String.valueOf(collectionManager.getCreationDate()));
        printer.outPrint("Количество элементов: ");
        printer.outPrintln(String.valueOf(collectionManager.getMusicBands().size()));
    }
}

