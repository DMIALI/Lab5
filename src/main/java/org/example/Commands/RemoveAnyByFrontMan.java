package org.example.Commands;

import java.util.ArrayList;

public class RemoveAnyByFrontMan extends Command {

    public RemoveAnyByFrontMan () {
        this.functionality = "удалить из коллекции один элемент, значение поля frontMan которого эквивалентно заданному";
    }

    @Override
    public String execute(ArrayList<String> args){
        return "RemoveAnyByFrontMan...";
    }
}
