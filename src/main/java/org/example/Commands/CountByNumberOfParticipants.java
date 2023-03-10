package org.example.Commands;

import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;

public class CountByNumberOfParticipants extends Command {

    public CountByNumberOfParticipants() {
        super("вывести количество элементов, значение поля numberOfParticipants которых равно заданному");
    }

    @Override
    public void execute(InputCommandData input) {
    }
}
