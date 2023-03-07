package org.example.Commands;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Help extends Command {
    public Help () {
        super("вывести справку по доступным командам");
    }
    @Override
    public String execute(ArrayList<String> args)  {
        File dir = new File("src\\main\\java\\org\\example\\Commands");
        StringBuilder out = new StringBuilder();
        File[] arrFiles = dir.listFiles();
        assert arrFiles != null;
        for (File file : arrFiles) {
            String ch = "\\\\";
            String[] arrCom = file.toString().split(ch);
            String name = arrCom[arrCom.length - 1].split("\\.")[0];
            if (! name.equalsIgnoreCase("Command")) {
                try {
                    Command clazz = (Command) Class.forName("org.example.Commands." + name).newInstance();
                    out.append(name).append(" - ").append(clazz.getFunctionality()).append("\n");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
                    return "No such command :(";
                }
            }
        }
        return out.toString();
    }


}