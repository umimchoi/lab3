package application;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import application.base.CLIApp;
import item.base.Item;

public class ShopApp extends CLIApp {
	public ShopApp(PrintStream out, Scanner in) {
		super(out, in);
	}
	
	public Item getItemChoice(List<Item> items, Runnable prompt) {
		int choice = getChoice(1, items.size(), prompt);
		return items.get(choice - 1);
	}
}
