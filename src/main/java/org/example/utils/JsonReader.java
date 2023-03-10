package org.example.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.DataTypes.MusicBand;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {
    public LinkedList<MusicBand> read(File json) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(json));
        /*List<MusicBand> musicBands = (new ObjectMapper()).readValue(inputStream, new TypeReference<List<MusicBand>>(){});
        LinkedList musicBands1 = new LinkedList(musicBands);*/
        TypeReference<LinkedList<MusicBand>> mapType = new TypeReference<LinkedList<MusicBand>>() {};
        LinkedList<MusicBand> musicBands = (new ObjectMapper()).readValue(inputStreamReader, mapType);
        return musicBands;
    }
}
