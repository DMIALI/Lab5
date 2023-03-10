package org.example.Commands;

import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;

public class FilterByAlbumsCount extends Command {

    public FilterByAlbumsCount () {
        super("вывести элементы, значение поля albumsCount которых равно заданном");
    }

    @Override
    public void execute(InputCommandData input) {
    }
}