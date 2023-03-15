package org.example.Commands;
import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.DataTypes.MusicBand;

import java.util.*;

public class Shuffle extends Command {

    public Shuffle () {
        super("перемешать элементы коллекции в случайном порядке");
    }

    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        ArrayList<MusicBand> musicBandLinkedList = new ArrayList<>();
        Collections.shuffle(collectionManager.getMusicBands());
    }
}
