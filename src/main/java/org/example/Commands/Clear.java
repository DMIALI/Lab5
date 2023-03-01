package org.example.Commands;

import java.util.ArrayList;

public class Clear extends Command {

    public Clear() {
        this.functionality = "очистить коллекцию";
    }

    @Override
    public String execute(ArrayList<String> args) {
        return "Clear...";
    }
}