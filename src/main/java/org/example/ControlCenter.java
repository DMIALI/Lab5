package org.example;

import org.example.Commands.Command;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ControlCenter {
    Scanner scanner = new Scanner(System.in);
    private final Map<String, Command> commandMap = new HashMap<>();

    public ControlCenter() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        File dir = new File("src\\main\\java\\org\\example\\Commands");
        File[] arrFiles =dir.listFiles();
        assert arrFiles != null;
        for(File file:arrFiles){
            String ch = "\\\\";
            String[] arrCom = file.toString().split(ch);
            String name = arrCom[arrCom.length - 1].split("\\.")[0];
            if (! name.equalsIgnoreCase("Command")) {
                commandMap.put(name, (Command) Class.forName("org.example.Commands." + name).newInstance());
            }
        }
    }
    public void Start (){
        System.out.println("If you want to call a command consisting of several words, you must use '_' between the words :)");
        String command = scanner.nextLine();
        while(!command.equalsIgnoreCase("Exit")){
            try {
                ArrayList<String> listOfCommand = new ArrayList<String>();
                Collections.addAll(listOfCommand, command.split(" "));
                String name = listOfCommand.get(0);
                listOfCommand.remove(0);
                System.out.println(commandMap.get(inputHandler(name)).execute(listOfCommand));
            } catch (NullPointerException e){
                System.out.println("No such command");
            }
            command = scanner.nextLine();
        }
    }
    private String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.toLowerCase().substring(1);
    }
    private String inputHandler(String input){
        StringBuilder name = new StringBuilder();
        for(String word: input.split("_")){
            name.append(firstUpperCase(word));
        }
        return name.toString();
    }
}
