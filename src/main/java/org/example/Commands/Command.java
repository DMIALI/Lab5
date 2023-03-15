package org.example.Commands;

import lombok.Getter;
import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.DataTypes.MusicBand;
import org.example.utils.Printer;

import java.util.ArrayList;

public abstract class Command {
    @Getter
    private String functionality;

    public Command(String function){
        this.functionality = function;
    }

    public abstract void execute(InputCommandData input);

}
