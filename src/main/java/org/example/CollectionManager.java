package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.DataTypes.MusicBand;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

public class CollectionManager {
    @Getter
    @Setter
    private LinkedList<MusicBand> musicBands;
    private File file;
    private Date creationDate;
    @Getter
    private IdManager idManager;
    private JsonWriter jsonWriter = new JsonWriter();
    private JsonReader jsonReader = new JsonReader();

    public CollectionManager(String path) throws IOException {
        file = new File(path);
        musicBands = jsonReader.read(file);
        creationDate = new Date();
        idManager = new IdManager(musicBands);
    }
    public void save() throws IOException {
        jsonWriter.write(file, musicBands);
    }
}
