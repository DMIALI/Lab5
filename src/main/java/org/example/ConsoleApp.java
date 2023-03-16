package org.example;

import java.io.IOException;

/**
 * Class for starting program
 */
public class ConsoleApp {
    public static void main(String[] args) throws IOException {
        ControlCenter controlCenter = new ControlCenter();
        if (args.length!=0){
            controlCenter.Start(args[0]);
        }
        else {
            System.err.println("Аргумент с путём к файлу не был передан");
            System.exit(-1);
        }
    }
}
