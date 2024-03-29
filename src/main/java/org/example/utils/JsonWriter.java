package org.example.utils;

import org.example.DataTypes.MusicBand;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Write in json file
 */
public class JsonWriter {
    public void write(File json, LinkedList<MusicBand> musicBands) throws IOException {
        FileWriter fileWriter = new FileWriter(json);
        String newjson = (new ObjectMapper()).writeValueAsString(musicBands);
        System.out.println(newjson);
        fileWriter.write(newjson);
        fileWriter.flush();
        fileWriter.close();
    }
}

