package org.example.Commands;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;

public class RemoveAt extends Command {

    public RemoveAt () {
        super("удалить элемент, находящийся в заданной позиции коллекции (index)");
    }

    @Override
    public OutputCommandData execute(InputCommandData input) {
        return null;
    }
}