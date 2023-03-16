package org.example.Commands;
import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.utils.PrimitiveTypeAsserter;
import org.example.utils.Printer;

import java.util.ArrayList;

/**
 * Class-command to delete element by its index
 */
public class RemoveAt extends Command {

    /**
     * Constructor responsible for describing the functionality of the command
     */
    public RemoveAt () {
        super("удалить элемент, находящийся в заданной позиции коллекции (index)");
    }

    /**
     * @param input
     * Method that deletes element by index
     */
    @Override
    public void execute(InputCommandData input) {
        CollectionManager collectionManager = input.collectionManager();
        Printer printer = input.printer();
        ArrayList<String> args = input.args();
        if(args.size() == 1 && PrimitiveTypeAsserter.checkInteger(args.get(0))) {
            int index = Integer.parseInt(args.get(0));
            collectionManager.getMusicBands().remove(index);
            collectionManager.getIdManager().remove((long) index);
            printer.outPrintln("Элемент успешно удален =)");
        } else{
            printer.errPrintln("Введены некоректные данные");
        }
    }
}