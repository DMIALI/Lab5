package org.example.Commands;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;

public class Save extends Command {

    public Save () {
        super("сохранить коллекцию в файл");
    }
    @Override
    public OutputCommandData execute(InputCommandData input) {
        return null;
    }
}
