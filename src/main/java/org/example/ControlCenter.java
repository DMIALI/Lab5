package org.example;

import org.example.Commands.Command;

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
            commandMap.put(name,(Command) Class.forName("org.example.Commands." + name).newInstance());


        }
    }
    public void Start (){
        String command = scanner.nextLine();
        while(!command.equalsIgnoreCase("Exit")){
            
            System.out.println(commandMap.get(firstUpperCase(command)).execute());
            command = scanner.nextLine();
        }
    }
    private String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.toLowerCase().substring(1);
    }
}
