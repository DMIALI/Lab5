package org.example.Commands;
import java.util.ArrayList;

public class RemoveAt extends Command {

    public RemoveAt () {
        this.functionality = "удалить элемент, находящийся в заданной позиции коллекции (index)";
    }

    @Override
    public String execute(ArrayList<String> args){
        return "RemoveAt...";
    }
}