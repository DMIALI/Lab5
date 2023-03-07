package org.example.Commands;

import java.util.ArrayList;

public abstract class Command {
    private String functionality;

    public Command(String function){
        this.functionality = function;
    }

    public String getFunctionality() {
        return functionality;
    }


    public abstract String execute(ArrayList<String> args);

}
