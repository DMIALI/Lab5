package org.example.Commands;

import java.io.File;
import java.util.ArrayList;

public class Help extends Command {
    @Override
    public String execute(ArrayList<String> args) {
        File dir = new File("src\\main\\java\\org\\example\\Commands");
        File[] arrFiles = dir.listFiles();
        for (File file : arrFiles) {
            String ch = "\\\\";
            String[] arrCom = file.toString().split(ch);
            String name = arrCom[arrCom.length - 1].split("\\.")[0];
            if (! name.equalsIgnoreCase("Command")) {
                System.out.println(name);
            }
        }
        return "";
    }
}