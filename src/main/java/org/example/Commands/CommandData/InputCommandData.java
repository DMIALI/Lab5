package org.example.Commands.CommandData;

import org.example.CollectionManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public record InputCommandData(CollectionManager collectionManager, Scanner scanner, ArrayList<String> args) {
}
