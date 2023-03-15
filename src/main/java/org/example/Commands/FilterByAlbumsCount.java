package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.DataTypes.MusicBand;
import org.example.utils.PrimitiveTypeAsserter;
import org.example.utils.Printer;

import java.util.ArrayList;

public class FilterByAlbumsCount extends Command {

    public FilterByAlbumsCount () {
        super("вывести элементы, значение поля albumsCount которых равно заданном");
    }

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