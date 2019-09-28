package application.shop.actions;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import application.ShopApp;
import hero.Hero;
import hero.UnequipItemFailedException;
import item.base.Item;

// You HAVE to modify things in this file to complete the assignment
public class UnequipItem extends ShopApp {
	
	private Hero hero;
	private List<Item> items;
	
	public UnequipItem(PrintStream out, Scanner in, Hero hero, List<Item> items) {
		super(out, in);
		this.hero = hero;
		this.items = items;
	}
	
	public void run() {
		int choice = this.getChoice(1, hero.getInventorySize(), () -> this.prompt());
		
		// TODO: handle the UnequipError!
		try {
			items.add(hero.unequipItem(choice - 1));}
		// If fail to unequip
		catch (hero.UnequipItemFailedException e) {
			out.println("Unequip item failed, " + e.message /* reason the unequip failed */);}
	}
	
	public void prompt() {
		out.println("Select item slot to unequip");
		
		int index = 1;
		for (Item item : hero.getInventory()) {
			if (item != null) {
				out.println(index + ": " + item.toString());
			}
			index += 1;
		}
	}
}
