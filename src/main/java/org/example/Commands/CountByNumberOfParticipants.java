package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.DataTypes.MusicBand;
import org.example.utils.Printer;

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
        if (args.size() == 1){
            try {
                int numberOfParticipants = Integer.parseInt(args.get(0));
                int countByNumberOfParticipants = 0;
                for(MusicBand musicBand : collectionManager.getMusicBands()){
                    if (musicBand.getNumberOfParticipants() == numberOfParticipants){
                        countByNumberOfParticipants++;
                    }
                }
                printer.outPrintln("Количество элементов: " + String.valueOf(countByNumberOfParticipants));
            } catch (NumberFormatException e){
                printer.errPrintln("Введите индекс в числовом формате");
            }
        }else if(args.size() == 0){
            printer.errPrintln("Этой команде необходим аргумент numberOfParticipants. Попробуйте еще раз");
        }else{
            printer.errPrintln("Перебор аргументов :(");
        }
    }
}
