package org.example.Commands;

import lombok.Getter;
import lombok.Setter;
import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.DataTypes.MusicBand;
import org.example.utils.Printer;

import java.util.ArrayList;

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
     * @param function
     * Constructor for adding a description of functionality to each command
     */
    public Command(String function){
        this.functionality = function;
    }

    /**
     * @param input
     * Abstract method for implementing program functionality
     */
    public abstract void execute(InputCommandData input);

}
