package org.example.Commands;
import java.util.ArrayList;

public class Reorder extends Command {

    public Reorder () {
        this.functionality = "отсортировать коллекцию в порядке, обратном нынешнему";
    }

    @Override
    public String execute(ArrayList<String> args){
        return "Reorder...";
    }
}