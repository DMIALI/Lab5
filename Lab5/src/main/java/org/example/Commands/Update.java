package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.DataTypes.Coordinates;
import org.example.DataTypes.MusicBand;
import org.example.DataTypes.MusicGenre;
import org.example.DataTypes.Person;
import org.example.utils.IdManager;
import org.example.utils.Printer;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Update extends Add {
    public Update() {
        this.setFunctionality("обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        LinkedList<MusicBand> musicBands = collectionManager.getMusicBands();
        Scanner scanner = input.scanner();
        Printer printer = input.printer();
        ArrayList<String> args = input.args();
        if (args.size() < 1) {
            printer.errPrintln("Отсутствуют необходимые аргументы);
        }
        else{
            printer.outPrintln("Изменение данных музыкальной группы");
            String name = receiveName(scanner, printer);
            Coordinates coordinates = receiveCoordinates(scanner, printer);
            Date date = new Date();
            long numberOfParticipants = receiveNumberOfParticipants(scanner, printer);
            long albumsCount = receiveAlbumsCount(scanner, printer);
            MusicGenre musicGenre = receiveMusicGenre(scanner, printer);
            Person person = receivePerson(scanner, printer);
            musicBands.Find(getMusicBandById(123);
            printer.outPrintln("Элемент успешно обновлен");
        }
    }
}
