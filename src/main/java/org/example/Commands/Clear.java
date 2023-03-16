package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;

/**
 * Class-command to clear the collection
 */
public class Clear extends Command {

    /**
     * Constructor responsible for describing the functionality of the command
     */
    public Clear() {
        super("очистить коллекцию");
    }

    /**
     * @param input
     * Method that clear the collection
     */
    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        collectionManager.getMusicBands().clear();
        collectionManager.getIdManager().resetToZero();
        input.printer().outPrintln("Коллекция успешно очищена =)");
    }
}