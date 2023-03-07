package org.example.Commands;

import java.util.ArrayList;

public class Info extends Command{
    public Info () {
        super("вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }
    @Override
    public String execute(ArrayList<String> args){
        return "Info...";
    }
}
