package org.example;

import org.example.Commands.Command;
import org.example.Commands.Help;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ControlCenter {
    Scanner scanner = new Scanner(System.in);
    private Map<String, Command> commandMap = new HashMap<>();

    public ControlCenter() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        File dir = new File("src\\main\\java\\org\\example\\Commands");
        File[] arrFiles =dir.listFiles();

        for(File file:arrFiles){
            String ch = "\\\\";
            String[] arrCom = file.toString().split(ch);
            String name = arrCom[arrCom.length - 1].split("\\.")[0];
            Class clazz = Class.forName("org.example.Commands." + name);
            commandMap.put(name,(Command) clazz.newInstance());
            System.out.println(commandMap.get(name).execute());

        }
    }
}
