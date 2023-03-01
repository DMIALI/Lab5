package org.example.Commands;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Help extends Command {
    public Help () {
        this.functionality = "вывести справку по доступным командам";
    }
    @Override
    public String execute(ArrayList<String> args)  {
        File dir = new File("src\\main\\java\\org\\example\\Commands");
        File[] arrFiles = dir.listFiles();
        for (File file : arrFiles) {
            String ch = "\\\\";
            String[] arrCom = file.toString().split(ch);
            String name = arrCom[arrCom.length - 1].split("\\.")[0];
            if (! name.equalsIgnoreCase("Command")) {
                try {
                    Command clazz = (Command) Class.forName("org.example.Commands." + name).newInstance();
                    System.out.println(name+ " - " + clazz.getFunctionality());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
                    System.out.println("No such command :(");
                }
            }
        }
        return "";
    }


}