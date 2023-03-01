package org.example.Commands;

import java.util.ArrayList;

public class Update extends Command{
    private Long id;
    public Update () {
        this.functionality = "обновить значение элемента коллекции, id которого равен заданному";
    }
    @Override
    public String execute(ArrayList<String> args) {
        try{
            this.id = Long.valueOf(args.get(0));
        } catch (IndexOutOfBoundsException e){
            System.out.println("You need enter argument: id, {element} ");
        } catch (NumberFormatException e){
            System.out.println("Please enter number");
        }
        return null;
    }
}
