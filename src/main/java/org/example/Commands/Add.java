package org.example.Commands;

import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.DataTypes.*;
import org.example.utils.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * Class-command to add new element to a collection
 */
public class Add extends Command {
    /**
     * Constructor responsible for describing the functionality of the command
     */
    public Add() {
        super("добавить новый элемент в коллекцию");
    }

    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        LinkedList<MusicBand> musicBands = collectionManager.getMusicBands();
        IdManager idManager = collectionManager.getIdManager();
        Long id = idManager.add();
        Scanner scanner = input.scanner();
        Printer printer = input.printer();
        printer.outPrintln("Создание новой музыкальной группы");
        String name = receiveName(scanner, printer);
        Coordinates coordinates = receiveCoordinates(scanner, printer);
        Date date = new Date();
        long numberOfParticipants = receiveNumberOfParticipants(scanner, printer);
        long albumsCount = receiveAlbumsCount(scanner, printer);
        MusicGenre musicGenre = receiveMusicGenre(scanner, printer);
        Person person = receivePerson(scanner, printer);
        musicBands.add(new MusicBand(id, name, coordinates, date, numberOfParticipants, albumsCount, musicGenre, person));
        printer.outPrintln("Элемент успешно добавлен");
    }

    protected String receiveLocationName(Scanner scanner, Printer printer) {
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

    protected long receiveLocationZ(Scanner scanner, Printer printer) {
        printer.outPrint("Координата Z: ");
        String z = scanner.nextLine();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                return PrimitiveTypeAsserter.checkLong(input);
            }
        };
        if (!func.execute(z)) {
            z = RepeatInput.go(z,"Координата Z: ", "Введенное значение не является числом типа long", func, scanner, printer);
        }
        return Long.parseLong(z);
    }

    protected Float receiveLocationY(Scanner scanner, Printer printer) {
        printer.outPrint("Координата Y: ");
        String y = scanner.nextLine();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                return PrimitiveTypeAsserter.checkFloat(input);
            }
        };
        if (!func.execute(y)) {
            y = RepeatInput.go(y,"Координата Y: ", "Введенное значение не является числом типа float", func, scanner, printer);
        }
        return Float.valueOf(y);
    }
    protected int receiveLocationX(Scanner scanner, Printer printer) {
        printer.outPrint("Координата X: ");
        String x = scanner.nextLine();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                return PrimitiveTypeAsserter.checkInteger(input);
            }
        };
        if (!func.execute(x)) {
            x = RepeatInput.go(x,"Координата X: ", "Введенное значение не является числом типа integer", func, scanner, printer);
        }
        return Integer.parseInt(x);
    }

    protected Location receiveLocation(Scanner scanner, Printer printer) {
        printer.outPrintln("Местоположение");
        int x = receiveLocationX(scanner, printer);
        Float y = receiveLocationY(scanner, printer);
        long z = receiveLocationZ(scanner, printer);
        String name = receiveLocationName(scanner, printer);
        return new Location(x, y, z, name);
    }


    protected Country receiveCountry(Scanner scanner, Printer printer) {
        printer.outPrint("Страна проживания (Russia, United_Kingdom, Germany, Vatican): ");
        String country = scanner.nextLine();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                input = input.toUpperCase();
                return input.equals("RUSSIA")||input.equals("UNITED_KINGDOM")||input.equals("GERMANY")||input.equals("VATICAN");
            }
        };
        if (!func.execute(country)) {
            country = RepeatInput.go(country,"Страна проживания (Russia, United_Kingdom, Germany, Vatican): ", "Введенное значение не соответствует одному из допустимых (Russia, United_Kingdom, Germany, Vatican)", func, scanner, printer);
        }
        return Country.valueOf(country.toUpperCase());
    }
    protected Color receiveColor(Scanner scanner, Printer printer) {
        printer.outPrint("Цвет волос (green, yellow, orange, brown): ");
        String color = scanner.nextLine();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                input = input.toUpperCase();
                return input.equals("GREEN")||input.equals("YELLOW")||input.equals("ORANGE")||input.equals("BROWN");
            }
        };
        if (!func.execute(color)) {
            color = RepeatInput.go(color,"Цвет волос (green, yellow, orange, brown): ", "Введенное значение не соответствует одному из допустимых (green, yellow, orange, brown)", func, scanner, printer);
        }
        return Color.valueOf(color.toUpperCase());
    }
    protected String receivePassportID(Scanner scanner, Printer printer) {
        printer.outPrint("ID паспорта: ");
        String passportID = scanner.nextLine();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                return (input.length() > 6);
            }
        };
        if (!func.execute(passportID)) {
            RepeatInput.go(passportID,"ID паспорта: ", "ID паспорта не может быть короче 6 символов ", func, scanner, printer);
        }
        return passportID;
    }

    protected String receivePersonName(Scanner scanner, Printer printer) {
        printer.outPrint("Имя: ");
        String name = scanner.nextLine();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                return !input.equals("");
            }
        };
        if (!func.execute(name)) {
            RepeatInput.go(name,"Имя: ", "Имя не может быть пустым", func, scanner, printer);
        }
        return name;
    }
    protected Person receivePerson(Scanner scanner, Printer printer) {
        printer.outPrintln("Ведущий вокалист");
        String name = receivePersonName(scanner, printer);
        String passportID = receivePassportID(scanner, printer);
        Color color = receiveColor(scanner, printer);
        Country country = receiveCountry(scanner, printer);
        Location location = receiveLocation(scanner, printer);
        return new Person(name, passportID, color, country, location);
    }
    protected MusicGenre receiveMusicGenre(Scanner scanner, Printer printer) {
        printer.outPrint("Музыкальный жанр (jazz, soul, pop): ");
        String musicGenre = scanner.nextLine();
        Operation func = new Operation() {
            @Override
            public boolean execute(String input) {
                input = input.toUpperCase();
                return input.equals("JAZZ")||input.equals("SOUL")||input.equals("POP");
            }
        };
        if (!func.execute(musicGenre)) {
            musicGenre = RepeatInput.go(musicGenre,"Музыкальный жанр (jazz, soul, pop): ", "Введенное значение не соответствует одному из допустимых (jazz, soul, pop)", func, scanner, printer);
        }
        return MusicGenre.valueOf(musicGenre.toUpperCase());
    }
    protected long receiveAlbumsCount(Scanner scanner, Printer printer) {
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
    protected long receiveNumberOfParticipants(Scanner scanner, Printer printer) {
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

    protected Coordinates receiveCoordinates(Scanner scanner, Printer printer) {
        printer.outPrintln("Местоположение ");
        Long x = receiveX(scanner, printer);
        double y = receiveY(scanner, printer);
        return new Coordinates(x, y);
    }

    protected Long receiveX(Scanner scanner, Printer printer) {
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

    protected double receiveY(Scanner scanner, Printer printer) {
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

    protected String receiveName(Scanner scanner, Printer printer) {
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
