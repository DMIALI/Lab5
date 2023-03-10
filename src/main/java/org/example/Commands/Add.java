package org.example.Commands;

import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;

public class Add extends Command{

    public Add () {
        super("добавить новый элемент в коллекцию");
    }

    @Override
    public OutputCommandData execute(InputCommandData input) {
        return null;
    }
}
