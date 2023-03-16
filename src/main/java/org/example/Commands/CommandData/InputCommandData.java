package org.example.Commands.CommandData;

import org.example.CollectionManager;
import org.example.Commands.Command;
import org.example.utils.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/**
 * record that contains Scanner, Printer, Collection Manager, HashMap of Commands and String args for command
 * @param collectionManager
 * @param scanner
 * @param printer
 * @param args
 * @param commandMap
 */
public record InputCommandData(CollectionManager collectionManager, Scanner scanner, Printer printer, ArrayList<String> args, HashMap<String, Command> commandMap) {
}
