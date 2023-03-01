package org.example.Commands;

import java.util.ArrayList;

public abstract class Command {
    protected String functionality;
    public String execute(){
        return "null";
    }

    public abstract String execute(ArrayList<String> args) throws ClassNotFoundException, InstantiationException, IllegalAccessException;

}
