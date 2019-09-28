package application.shop.actions;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import application.ShopApp;
import hero.EquipItemFailedException;
import hero.Hero;
import item.base.Item;

// You HAVE to modify things in this file to complete the assignment
public class EquipItem extends ShopApp {
	private Hero hero;
	private List<Item> items;
	
	public EquipItem(PrintStream out, Scanner in, Hero hero, List<Item> items) {
		super(out, in);
		this.hero = hero;
		this.items = items;
	}
	
	public void run() {
		Item item = getItemChoice(this.items, () -> this.prompt());
		// TODO: handle the EquipItemFailedException
		try {
			int slot = hero.equipItem(item);
			out.println("Equipped " + item.getName() + " to slot " + slot);
			items.remove(item);}
		// If the equip fails
		catch (hero.EquipItemFailedException e){
			out.println("Equip item failed, " + e.message/* reason the equip failed */);}
		}
	
	
	public void prompt() {
		out.println("Select item");
		int index = 1;
		for (Item item : items) {
			out.println(index + ": " + item.toString());
			index += 1;
		}
	}
}
