package org.example.Commands;

import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;

public class Clear extends Command {

    public Clear() {
        super("очистить коллекцию");
    }

    @Override
    public OutputCommandData execute(InputCommandData input) {
        return null;
    }
}