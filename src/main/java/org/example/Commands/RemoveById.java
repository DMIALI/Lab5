package org.example.Commands;
import java.util.ArrayList;

public class RemoveById extends Command{

    public RemoveById () {
        super("удалить элемент из коллекции по его id");
    }

    @Override
    public String execute(ArrayList<String> args){
        return "RemoveById...";
    }
}
