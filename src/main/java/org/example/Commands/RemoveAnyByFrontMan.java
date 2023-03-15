package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.DataTypes.MusicBand;
import org.example.utils.PrimitiveTypeAsserter;
import org.example.utils.Printer;

import java.util.ArrayList;

public class RemoveAnyByFrontMan extends Command {

    public RemoveAnyByFrontMan () {
        super("удалить из коллекции один элемент, значение поля frontMan которого эквивалентно заданному");
    }

    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        Printer printer = input.printer();
        ArrayList<String> args = input.args();
        if(args.size() > 0) {
            for(MusicBand musicBand: collectionManager.getMusicBands()){
                if(musicBand.getFrontMan().getName().equals(args.get(0))){
                    collectionManager.getMusicBands().remove(musicBand);
                    return;
                }
            }
            printer.errPrintln("frontMan с таким именем не найден =(");
        }else{
            printer.errPrintln("Введены некоректные данные");
        }
    }
}
