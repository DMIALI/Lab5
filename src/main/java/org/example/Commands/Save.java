package org.example.Commands;
import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.utils.Printer;

import java.io.IOException;

/**
 * Class-command to save collection into the file
 */
public class Save extends Command {

    /**
     * Constructor responsible for describing the functionality of the command
     */
    public Save () {
        super("сохранить коллекцию в файл");
    }

    /**
     * @param input
     * Method that saves collection to a file
     */
    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        Printer printer = input.printer();
        try {
            collectionManager.save();
            printer.outPrintln("Коллекция успешно сохранена!");
        }
        catch (IOException e){
            printer.errPrintln("Не удалось сохранить в файл: " + String.valueOf(e));
        }
    }
}
