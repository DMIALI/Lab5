package org.example;

import org.example.Commands.*;
import org.example.Commands.CommandData.InputCommandData;
import org.example.utils.Printer;

import java.io.IOException;
import java.util.*;

public class ControlCenter {

    private final HashMap<String, Command> commandMap = new HashMap<>();

    public ControlCenter() {
        commandMap.put("add", new Add());
        commandMap.put("clear", new Clear());
        commandMap.put("count_by_number_of_participants", new CountByNumberOfParticipants());
        commandMap.put("execute_script", new ExecuteScript());
        commandMap.put("exit", new Exit());
        commandMap.put("filter_by_albums_count", new FilterByAlbumsCount());
        commandMap.put("help", new Help());
        commandMap.put("remove_any_by_front_man", new RemoveAnyByFrontMan());
        commandMap.put("remove_at", new RemoveAt());
        commandMap.put("remove_by_id", new RemoveById());
        commandMap.put("reorder", new Reorder());
        commandMap.put("save", new Save());
        commandMap.put("show", new Show());
        commandMap.put("shuffle", new Shuffle());
        commandMap.put("update", new Update());
        ((Help) (commandMap.get("help"))).addCommandMap(commandMap);
        /*File dir = new File("src\\main\\java\\org\\example\\Commands");
        File[] arrFiles =dir.listFiles();
        assert arrFiles != null;
        for(File file:arrFiles){
            String ch = "\\\\";
            String[] arrCom = file.toString().split(ch);
            String name = arrCom[arrCom.length - 1].split("\\.")[0];
            if (! name.equalsIgnoreCase("Command")) {
                commandMap.put(name, (Command) Class.forName("org.example.Commands." + name).newInstance());
            }
        }*/
    }

    public void Start(String path) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        System.out.println("If you want to call a command consisting of several words, you must use '_' between the words :)");
        CollectionManager collectionManager = new CollectionManager(path, scanner,printer);
        String command = scanner.nextLine();
        while (true) {
            try {
                ArrayList<String> listOfCommand = new ArrayList<String>();
                Collections.addAll(listOfCommand, command.split(" "));
                String name = listOfCommand.remove(0);
                commandMap.get(inputHandler(name)).execute(new InputCommandData(collectionManager,scanner, printer, listOfCommand));
            } catch (NullPointerException e) {
                System.out.println("No such command");
            }
            command = scanner.nextLine();
        }
    }



    private String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.toLowerCase().substring(1);
    }

    private String inputHandler(String input) {
        StringBuilder name = new StringBuilder();
        for (String word : input.split("_")) {
            name.append(word.toLowerCase());
            name.append('_');
        }
        name.deleteCharAt(name.lastIndexOf("_"));
        System.out.println(name.toString());
        return name.toString();
    }
}
