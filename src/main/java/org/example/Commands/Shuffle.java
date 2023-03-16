package org.example.Commands;
import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;

import java.util.*;

/**
 * Class-command for shuffling collection elements
 */
public class Shuffle extends Command {

    /**
     * Constructor responsible for describing the functionality of the command
     */
    public Shuffle () {
        super("перемешать элементы коллекции в случайном порядке");
    }

    /**
     * @param input
     * Method that shuffle elements
     */
    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        Collections.shuffle(collectionManager.getMusicBands());
        input.printer().outPrintln("Элементы успешно перемешались =)");
    }
}
