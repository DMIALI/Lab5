package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;
import java.util.Collections;

public class Clear extends Command {

    public Clear() {
        super("очистить коллекцию");
    }

    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        collectionManager.getMusicBands().clear();
        collectionManager.getIdManager().resetToZero();
    }
}