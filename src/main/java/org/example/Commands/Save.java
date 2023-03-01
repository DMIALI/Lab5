package org.example.Commands;
import java.util.ArrayList;

public class Save extends Command {

    public Save () {
        this.functionality = "сохранить коллекцию в файл";
    }

    @Override
    public String execute(ArrayList<String> args){
        return "Save...";
    }
}
