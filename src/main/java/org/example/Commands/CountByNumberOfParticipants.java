package org.example.Commands;

import java.util.ArrayList;

public class CountByNumberOfParticipants extends Command {

    public CountByNumberOfParticipants () {
        this.functionality = "вывести количество элементов, значение поля numberOfParticipants которых равно заданному";
    }

    @Override
    public String execute(ArrayList<String> args){
        return "CountByNumberOfParticipants...";
    }
}
