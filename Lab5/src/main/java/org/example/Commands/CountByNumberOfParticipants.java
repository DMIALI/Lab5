package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.DataTypes.MusicBand;
import org.example.utils.PrimitiveTypeAsserter;
import org.example.utils.Printer;

import javax.lang.model.type.PrimitiveType;
import java.util.ArrayList;

public class CountByNumberOfParticipants extends Command {

    public CountByNumberOfParticipants() {
        super("вывести количество элементов, значение поля numberOfParticipants которых равно заданному");
    }

    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        Printer printer = input.printer();
        ArrayList<String> args = input.args();
        if(args.size() > 0 && PrimitiveTypeAsserter.checkInteger(args.get(0))){
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
