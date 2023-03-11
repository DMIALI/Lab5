package org.example.Commands;
import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.DataTypes.MusicBand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Shuffle extends Command {

    public Shuffle () {
        super("перемешать элементы коллекции в случайном порядке");
    }

    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        HashSet<MusicBand> musicBandHashSet = new HashSet<MusicBand>(collectionManager.getMusicBands());
        for(MusicBand musicBand:musicBandHashSet) {
            collectionManager.getMusicBands().pop();
            collectionManager.getMusicBands().add(musicBand);
        }
        System.out.println(collectionManager.getMusicBands());
    }
}
