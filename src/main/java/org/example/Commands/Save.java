package org.example.Commands;
import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.utils.Printer;

import java.io.IOException;
import java.util.ArrayList;

public class Save extends Command {

    public Save () {
        super("сохранить коллекцию в файл");
    }
    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        Printer printer = input.printer();
        try {
            collectionManager.save();
            printer.outPrintln("Коллекция успешно сохранена!");
        }
        catch (IOException e){
            printer.errPrintln("Не удалось сохранить в файл: " + String.valueOf(e));
        }
    }
}
