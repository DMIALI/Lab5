package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.DataTypes.MusicBand;
import org.example.utils.PrimitiveTypeAsserter;
import org.example.utils.Printer;

import java.util.ArrayList;

/**
 *  Class-command to find Music Bands with a given count of albums
 */
public class FilterByAlbumsCount extends Command {

    /**
     * Constructor responsible for describing the functionality of the command
     */
    public FilterByAlbumsCount () {
        super("вывести элементы, значение поля albumsCount которых равно заданном");
    }

    /**
     * Method that find Music Bands with a given count of albums
     * @param input {@link InputCommandData}
     */
    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        Printer printer = input.printer();
        ArrayList<String> args = input.args();
        if(args.size() == 1 && PrimitiveTypeAsserter.checkInteger(args.get(0))) {
            int albumsCount = Integer.parseInt(args.get(0));
            for(MusicBand musicBand : collectionManager.getMusicBands()){
                if (musicBand.getAlbumsCount() == albumsCount){
                    printer.outPrintln(musicBand.toString());
                }
            }
        } else{
            printer.errPrintln("Введены некоректные данные");
        }
    }
}