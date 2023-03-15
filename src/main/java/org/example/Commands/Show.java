package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.utils.Printer;

import java.util.ArrayList;

/**
 * @author DMIALI
 * Сlass-command for displaying all the elements of a collection
 */
public class Show extends Command{
    /**
     * Constructor responsible for describing the functionality of the command
     */
    public Show () {
        super("вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    /**
     * @param input -
     * Method that shows all elements in collection
     */
    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        Printer printer = input.printer();
        printer.outPrint(collectionManager.toString());
    }
}
