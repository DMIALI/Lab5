package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.DataTypes.MusicBand;
import org.example.utils.PrimitiveTypeAsserter;
import org.example.utils.Printer;

import java.util.ArrayList;

/**
 * Class-command to find count of Music Bands with a given number of participants
 */
public class CountByNumberOfParticipants extends Command {

    /**
     * Constructor responsible for describing the functionality of the command
     */
    public CountByNumberOfParticipants() {
        super("вывести количество элементов, значение поля numberOfParticipants которых равно заданному");
    }

    /**
     * Method that find cont of Music Bands with a given number of participants
     * @param input {@link InputCommandData}
     */
    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        Printer printer = input.printer();
        ArrayList<String> args = input.args();
        if(args.size() == 1 && PrimitiveTypeAsserter.checkInteger(args.get(0))){
            int numberOfParticipants = Integer.parseInt(args.get(0));
            int countByNumberOfParticipants = 0;
            for (MusicBand musicBand : collectionManager.getMusicBands()) {
                if (musicBand.getNumberOfParticipants() == numberOfParticipants) {
                    countByNumberOfParticipants++;
                }
            }
            printer.outPrintln("Количество элементов = " + countByNumberOfParticipants);
        } else {
            printer.errPrintln("Введены некоректные данные");
        }
    }
}
