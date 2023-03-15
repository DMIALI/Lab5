package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.DataTypes.MusicBand;
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
        if (args.size() == 1){
            try {
                int albumsCount = Integer.parseInt(args.get(0));
                for(MusicBand musicBand : collectionManager.getMusicBands()){
                    if (musicBand.getAlbumsCount() == albumsCount){
                        printer.outPrintln(musicBand.toString());
                    }
                }
            } catch (NumberFormatException e){
                printer.errPrintln("Введите индекс в числовом формате");
            }
        }else if(args.size() == 0){
            printer.errPrintln("Этой команде необходим аргумент albumsCount. Попробуйте еще раз");
        }else{
            printer.errPrintln("Перебор аргументов :(");
        }
    }
}