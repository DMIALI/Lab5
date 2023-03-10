package org.example.Commands;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;

public class Shuffle extends Command {

    public Shuffle () {
        super("перемешать элементы коллекции в случайном порядке");
    }

    @Override
    public void execute(InputCommandData input) {
    }
}
