package org.example.Commands;
import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
import org.example.utils.PrimitiveTypeAsserter;
import org.example.utils.Printer;

import java.util.ArrayList;

public class RemoveById extends Command{

    public RemoveById () {
        super("удалить элемент из коллекции по его id");
    }

    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        Printer printer = input.printer();
        ArrayList<String> args = input.args();
        if(args.size() > 0 && PrimitiveTypeAsserter.checkLong(args.get(0))) {
            try {
                long id = Integer.parseInt(args.get(0));
                collectionManager.getMusicBands().remove(collectionManager.getMusicBandById(id));
                collectionManager.getIdManager().remove(id);
            } catch(NullPointerException e ) {
                printer.errPrintln("Элемента с таким id нет");
            }
        }else{
            printer.errPrintln("Введены некоректные данные");
        }
    }
}
