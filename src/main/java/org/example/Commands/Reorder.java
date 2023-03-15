package org.example.Commands;
import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.DataTypes.MusicBand;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Сlass-command for sorting the collection in reverse order
 */
public class Reorder extends Command {

    /**
     * Constructor responsible for describing the functionality of the command
     */
    public Reorder () {
        super("отсортировать коллекцию в порядке, обратном нынешнему");
    }

    /**
     * @param input
     * Method that sorts elements in revers order
     */
    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        LinkedList<MusicBand> musicBandLinkedList = new LinkedList<MusicBand>();
        for(MusicBand musicBand: collectionManager.getMusicBands()){
            musicBandLinkedList.add(0, musicBand);
        }
        collectionManager.setMusicBands(musicBandLinkedList);
        input.printer().outPrintln("Коллекция успешно отсортирована в обратном порядке =)");
    }
}