package org.example;
import lombok.Getter;
import lombok.Setter;
import org.example.DataTypes.MusicBand;
import org.example.utils.IdManager;
import org.example.utils.JsonReader;
import org.example.utils.JsonWriter;
import org.example.utils.Printer;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class for manage of collection
 */
public class CollectionManager {
    @Getter
    @Setter
    private LinkedList<MusicBand> musicBands;
    private File file;
    @Getter
    private Date creationDate;
    @Getter
    private IdManager idManager;
    private JsonWriter jsonWriter = new JsonWriter();

    public CollectionManager(String path, Scanner scanner, Printer printer) throws IOException {
        this.file = receiveFile(path, scanner, printer);
        printer.outPrintln("Файл считан успешно");
        JsonReader jsonReader = new JsonReader();
        this.musicBands = jsonReader.read(file);
        this.creationDate = new Date();
        this.idManager = new IdManager(musicBands);
    }
    public void save() throws IOException {
        jsonWriter.write(file, musicBands);
    }

    public File receiveFile(String path, Scanner scanner, Printer printer){
        File file;
        while (true) {
            if (path.equals("exit")){
                printer.outPrintln("Приложение сейчас закроется....");
                System.exit(0);
            }
            file = new File(path);
            if (file.isFile()&&file.canRead()&&file.canWrite()){
                break;
            }
            if (!file.isFile()) {
                printer.errPrintln("Файл не существует, введите другой путь к файлу:");
            } else if (!file.canRead()) {
                printer.errPrintln("Отсутствуют права на чтение, измените права или введите путь к другому файлу:");
            } else if (!file.canWrite()) {
                printer.errPrintln("Отсутствуют права на запись, измените права или введите путь к другому файлу:");
            }
            path = scanner.nextLine();
        }
        return file;
    }
    public MusicBand getMusicBandById (long id) throws NullPointerException {
        for(MusicBand musicBand: getMusicBands()){
            if (musicBand.getId() == id){
                return musicBand;
            }
        }
        throw new NullPointerException();
    }
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for(MusicBand musicBand: musicBands){
            out.append(musicBand.toString()).append("\n");
        }
        return out.toString();
    }
}
