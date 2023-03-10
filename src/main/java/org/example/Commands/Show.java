package org.example.Commands;

import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;

public class Show extends Command{
    public Show () {
        super("вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    @Override
    public OutputCommandData execute(InputCommandData input) {
        return null;
    }
}
