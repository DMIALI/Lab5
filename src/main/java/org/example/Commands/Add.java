package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.DataTypes.*;
import org.example.utils.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Add extends Command {

    public Add() {
        super("добавить новый элемент в коллекцию");
    }

    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        LinkedList<MusicBand> musicBands = collectionManager.getMusicBands();
        IdManager idManager = collectionManager.getIdManager();
        Scanner scanner = input.scanner();
        Printer printer = input.printer();
        Long id = idManager.add();
        printer.outPrintln("Создание новой музыкальной группы");
        String name = receiveName(scanner, printer);
        Coordinates coordinates = receiveCoordinates(scanner, printer);
        Date date = new Date();
        long numberOfParticipants = receiveNumberOfParticipants(scanner, printer);
        long albumsCount = receiveAlbumsCount(scanner, printer);
        musicBands.add(new MusicBand(id, name, coordinates, date, numberOfParticipants, albumsCount, MusicGenre.POP, new Person("abc", "abc", Color.GREEN, Country.RUSSIA, new Location(1, 2F, 3, "abc"))));
        printer.outPrintln("Элемент успешно добавлен");
    }

    public long receiveAlbumsCount(Scanner scanner, Printer printer) {
        printer.outPrint("Количество альбомов: ");
        String albumsCount = scanner.nextLine();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                return (PrimitiveTypeAsserter.checkLong(input))&&((Long.parseLong(input)) > 0);
            }
        };
        if (!func.execute(albumsCount)) {
            albumsCount = RepeatInput.go(albumsCount,"Количество альбомов: ", "Введенное значение не является числом типа long или указано количество меньше 0", func, scanner, printer);
        }
        return Long.parseLong(albumsCount);
    }
    public long receiveNumberOfParticipants(Scanner scanner, Printer printer) {
        printer.outPrint("Количество участников: ");
        String numberOfParticipants = scanner.nextLine();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                return (PrimitiveTypeAsserter.checkLong(input))&&((Long.parseLong(input)) > 0);
            }
        };
        if (!func.execute(numberOfParticipants)) {
            numberOfParticipants = RepeatInput.go(numberOfParticipants,"Количество участников: ", "Введенное значение не является числом типа long или указано количество меньше 0", func, scanner, printer);
        }
        return Long.parseLong(numberOfParticipants);
    }

    public Coordinates receiveCoordinates(Scanner scanner, Printer printer) {
        printer.outPrint("Местоположение: ");
        Long x = receiveX(scanner, printer);
        double y = receiveY(scanner, printer);
        return new Coordinates(x, y);
    }

    public Long receiveX(Scanner scanner, Printer printer) {
        printer.outPrint("Координата X: ");
        String x = scanner.nextLine();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                return (PrimitiveTypeAsserter.checkLong(input))&&((Long.parseLong(input)) > -645);
            }
        };
        if (!func.execute(x)) {
            x = RepeatInput.go(x,"Координата X: ", "Введенное значение не является числом типа long или указана координата меньше -645", func, scanner, printer);
        }
        return Long.valueOf(x);
    }

    public double receiveY(Scanner scanner, Printer printer) {
        printer.outPrint("Координата Y: ");
        String y = scanner.nextLine();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                return (PrimitiveTypeAsserter.checkDouble(input));
            }
        };
        if (!func.execute(y)) {
            y = RepeatInput.go(y,"Координата Y: ", "Введенное значение не является числом типа double", func, scanner, printer);
        }
        return Double.parseDouble(y);
    }

    public String receiveName(Scanner scanner, Printer printer) {
        printer.outPrint("Название: ");
        String name = scanner.nextLine();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                return !input.equals("");
            }
        };
        if (!func.execute(name)) {
            RepeatInput.go(name,"Название: ", "Название не может быть пустым", func, scanner, printer);
        }
        return name;
    }
}
