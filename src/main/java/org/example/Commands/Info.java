package org.example.Commands;

import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;

public class Info extends Command{
    public Info () {
        super("вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }
    @Override
    public OutputCommandData execute(InputCommandData input) {
        return null;
    }
}
