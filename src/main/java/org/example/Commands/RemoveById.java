package org.example.Commands;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;

public class RemoveById extends Command{

    public RemoveById () {
        super("удалить элемент из коллекции по его id");
    }

    @Override
    public OutputCommandData execute(InputCommandData input) {
        return null;
    }
}
