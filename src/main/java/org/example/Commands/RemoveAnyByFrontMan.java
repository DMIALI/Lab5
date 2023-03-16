package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.DataTypes.MusicBand;
import org.example.utils.Printer;

import java.util.ArrayList;

/**
 * Class-command to delete element by its front man
 */
public class RemoveAnyByFrontMan extends Command {

    /**
     * Constructor responsible for describing the functionality of the command
     */
    public RemoveAnyByFrontMan () {
        super("удалить из коллекции один элемент, значение поля frontMan которого эквивалентно заданному");
    }

    /**
     * @param input
     *  Method that deletes element by front man
     */
    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        Printer printer = input.printer();
        ArrayList<String> args = input.args();
        if(args.size() == 1) {
            for(MusicBand musicBand: collectionManager.getMusicBands()){
                if(musicBand.getFrontMan().getName().equals(args.get(0))){
                    collectionManager.getMusicBands().remove(musicBand);
                    printer.outPrintln("Элемент успешно удален =)");
                    return;
                }
            }
            printer.errPrintln("frontMan с таким именем не найден =(");
        }else{
            printer.errPrintln("Введены некоректные данные");
        }
    }
}

