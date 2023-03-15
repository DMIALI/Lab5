package org.example.Commands;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

import java.util.ArrayList;

public class ExecuteScript extends Command {

    public ExecuteScript () {
        super("считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    @Override
    public void execute(InputCommandData input) {
    }
}