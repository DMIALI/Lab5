package org.example.Commands;
import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.utils.PrimitiveTypeAsserter;
import org.example.utils.Printer;

import java.util.ArrayList;
import java.util.Collections;

public class RemoveAt extends Command {

    public RemoveAt () {
        super("удалить элемент, находящийся в заданной позиции коллекции (index)");
    }

    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        Printer printer = input.printer();
        ArrayList<String> args = input.args();
        if(args.size() > 0 && PrimitiveTypeAsserter.checkInteger(args.get(0))) {
            int index = Integer.parseInt(args.get(0));
            collectionManager.getMusicBands().remove(index);
            collectionManager.getIdManager().remove((long) index);
        } else{
            printer.errPrintln("Введены некоректные данные");
        }
    }
}