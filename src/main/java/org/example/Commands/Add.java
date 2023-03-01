package org.example.Commands;

import java.util.ArrayList;

public class Add extends Command{


    public Add () {
        this.functionality = "добавить новый элемент в коллекцию";
    }
    @Override
    public String execute(ArrayList<String> args){
        return"Add...";
    }
}
