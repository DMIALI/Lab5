package org.example.Commands;

import java.util.ArrayList;

public class Show extends Command{
    public Show () {
        this.functionality = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
    @Override
    public String execute(ArrayList<String> args){

        return"Show...";
    }
}
