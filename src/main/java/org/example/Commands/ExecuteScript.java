package org.example.Commands;
import java.util.ArrayList;

public class ExecuteScript extends Command {

    public ExecuteScript () {
        this.functionality = "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }

    @Override
    public String execute(ArrayList<String> args){
        return "ExecuteScript...";
    }
}