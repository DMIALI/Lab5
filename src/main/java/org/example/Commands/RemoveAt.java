package org.example.Commands;
import org.example.CollectionManager;
import org.example.Commands.CommandData.InputCommandData;
import org.example.Commands.CommandData.OutputCommandData;
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
        if (args.size() == 1){
            try {
                int index = Integer.parseInt(args.get(0));
                collectionManager.getMusicBands().remove(index);
                System.out.println(collectionManager.getMusicBands());

            } catch (NumberFormatException e){
                printer.errPrintln("Введите индекс в числовом формате");
            } catch (IndexOutOfBoundsException e){
                printer.errPrintln("Элементов с таким индексом нет в коллекции\nКоличество эллементов в коллекции = " + collectionManager.getMusicBands().size());
            }
        }else if(args.size() == 0){
            printer.errPrintln("Этой команде необходим аргумент index. Попробуйте еще раз");
        }else{
            printer.errPrintln("Перебор аргументов :(");
        }

    }
}