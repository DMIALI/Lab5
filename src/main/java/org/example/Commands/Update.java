package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.DataTypes.Coordinates;
import org.example.DataTypes.MusicBand;
import org.example.DataTypes.MusicGenre;
import org.example.DataTypes.Person;
import org.example.utils.IdManager;
import org.example.utils.PrimitiveTypeAsserter;
import org.example.utils.Printer;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class-command to update the elements by their ID
 */
public class Update extends Add {
    /**
     * Constructor responsible for describing the functionality of the command
     */
    public Update() {
        this.setFunctionality("обновить значение элемента коллекции, id которого равен заданному");
    }

    /**
     * Method that updates the elements by their ID
     * @param input {@link InputCommandData}
     */
    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        IdManager idManager = collectionManager.getIdManager();
        LinkedList<MusicBand> musicBands = collectionManager.getMusicBands();
        Scanner scanner = input.scanner();
        Printer printer = input.printer();
        ArrayList<String> args = input.args();
        if (args.size() < 1) {
            printer.errPrintln("Отсутствуют необходимые аргументы");
        }
        else{
            String arg = args.get(0);
            if (PrimitiveTypeAsserter.checkLong(arg)&&(idManager.getIds().contains(Integer.valueOf(arg)))){
                printer.outPrintln("Изменение данных музыкальной группы");
                Long id = (Long.valueOf(arg));
                String name = receiveName(scanner, printer);
                Coordinates coordinates = receiveCoordinates(scanner, printer);
                Date date = new Date();
                long numberOfParticipants = receiveNumberOfParticipants(scanner, printer);
                long albumsCount = receiveAlbumsCount(scanner, printer);
                MusicGenre musicGenre = receiveMusicGenre(scanner, printer);
                Person person = receivePerson(scanner, printer);
                int oldMusicBandIndex = collectionManager.getMusicBands().indexOf(collectionManager.getMusicBandById(id));
                musicBands.set(oldMusicBandIndex, new MusicBand(id, name, coordinates, date, numberOfParticipants, albumsCount, musicGenre, person));
                printer.outPrintln("Элемент успешно обновлен");
            }
            else{
                printer.errPrintln("Элемент с таким id отсутствует в коллекции");
            }
        }
    }
}
