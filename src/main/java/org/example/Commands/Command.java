package org.example.Commands;

import lombok.Getter;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;

public abstract class Command {
    @Getter
    private String functionality;

    public Command(String function){
        this.functionality = function;
    }

    public abstract OutputCommandData execute(InputCommandData input);

}
