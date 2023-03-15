package org.example;

import java.io.IOException;

public class ConsoleApp {
    public static void main(String[] args) throws IOException {
        ControlCenter controlCenter = new ControlCenter();
        if (args.length!=0){
            controlCenter.Start(args[0]);
        }
        else {
            System.err.println("Аргумент с путём к файлу не был передан");
            System.exit(-1);
        }
        /*System.out.println("hello");
        MusicBand musicBand1 = new MusicBand(123L, "abc", new Coordinates(1L,2), new Date(), 123, 123, MusicGenre.POP, new Person("abc", "abc", Color.GREEN, Country.RUSSIA, new Location(1, 2F, 3, "abc")));
        MusicBand musicBand2 = new MusicBand(123L, "abc", new Coordinates(1L,2), new Date(), 123, 123, MusicGenre.POP, new Person("abc", "abc", Color.ORANGE, Country.RUSSIA, new Location(1, 2F, 3, "abc")));
        LinkedList <MusicBand> musicBands = new LinkedList<>();
        musicBands.add(musicBand1);
        musicBands.add(musicBand2);
        JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.write(new File("C:\\Users\\фвьшт\\IdeaProjects\\Lab5\\src\\main\\java\\org\\example\\data.json"), musicBands);
        JsonReader jsonReader = new JsonReader();
        System.out.println(jsonReader.read(new File("C:\\Users\\фвьшт\\IdeaProjects\\Lab5\\src\\main\\java\\org\\example\\data.json")));
        LinkedList <MusicBand> musicBands2 = new LinkedList<>();
        musicBands2.add(musicBands.get(0));
        musicBands.set(0, null);
        System.out.println(musicBands2);
        System.out.println(musicBands);*/
    }
}