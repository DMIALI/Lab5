package org.example.Commands;

import lombok.Getter;
import lombok.Setter;
import org.example.Commands.CommandData.InputCommandData;

/**
 * Parent class for all commands
 */
public abstract class Command {
    /**
     * Information about the command
     */
    @Getter
    @Setter
    private String functionality;

    /**
     * Constructor for adding a description of functionality to each command
     * @param function
     */
    public Command(String function){
        this.functionality = function;
    }

    /**
     * Abstract method for implementing program functionality
     * @param input {@link InputCommandData}
     */
    public abstract void execute(InputCommandData input);

}
