package org.example.Commands.CommandData;

import org.example.CollectionManager;
import org.example.Commands.Command;
import org.example.utils.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public record InputCommandData(CollectionManager collectionManager, Scanner scanner, Printer printer, ArrayList<String> args, HashMap<String, Command> commandMap) {
}
