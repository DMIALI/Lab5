package org.example.Commands;
import java.util.ArrayList;

public class Shuffle extends Command {

    public Shuffle () {
        super("перемешать элементы коллекции в случайном порядке");
    }

    @Override
    public String execute(ArrayList<String> args){
        return "Shuffle...";
    }
}
