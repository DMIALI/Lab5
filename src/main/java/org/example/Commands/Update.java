package org.example.Commands;

import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;

public class Update extends Command{
    public Update () {
        super("обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public OutputCommandData execute(InputCommandData input) {
        return null;
    }

    /*@Override
    public String execute(ArrayList<String> args) {
        try{
            Long id = Long.valueOf(args.get(0));
        } catch (IndexOutOfBoundsException e){
            System.out.println("You need enter argument: id, {element} ");
        } catch (NumberFormatException e){
            System.out.println("Please enter the number");
        }
        return null;
    }*/
}
