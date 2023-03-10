package org.example.Commands;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;

public class Reorder extends Command {

    public Reorder () {
        super("отсортировать коллекцию в порядке, обратном нынешнему");
    }

    @Override
    public void execute(InputCommandData input) {
    }
}