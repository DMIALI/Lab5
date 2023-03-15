package org.example.Commands;

import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;

public class RemoveAnyByFrontMan extends Command {

    public RemoveAnyByFrontMan () {
        super("удалить из коллекции один элемент, значение поля frontMan которого эквивалентно заданному");
    }

    @Override
    public void execute(InputCommandData input) {
    }
}
