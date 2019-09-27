package application.shop;

import java.util.ArrayList;
import java.util.List;
import java.io.PrintStream;
import java.util.Scanner;

import application.ShopApp;
import application.shop.actions.EquipItem;
import application.shop.actions.PutGemIntoGauntlet;
import application.shop.actions.UnequipItem;
import application.shop.actions.UpgradeItem;
import application.shop.actions.Forge;
import hero.Hero;
import item.base.Item;

public class Shop extends ShopApp {
	Hero hero;
	List<Item> items;
	
	public Shop(PrintStream out, Scanner in, Hero hero) {
		super(out, in);
		this.hero = hero;
		this.items = new ArrayList<Item>();
	}

	public void run() {
		while(true) {
			int choice = this.getChoice(1, 6, false, () -> this.prompt());
			switch(choice) {
			case 1:
				Item toAdd = new Forge(this.out, this.in).runForge();
				if(toAdd != null) {
					items.add(toAdd);
				}
				break;
			case 2:
				new EquipItem(this.out, this.in, this.hero, this.items).run();
				out.println("Equip Item Done");
				break;
			case 3:
				new UnequipItem(this.out, this.in, this.hero, this.items).run();
				out.println("Unequip Item Done");
				break;
			case 4:
				new UpgradeItem(this.out, this.in, this.items).run();
				out.println("Upgrade Item Done");
				break;
			case 5:
				new PutGemIntoGauntlet(this.out, this.in, this.items).run();
				out.println("Put gem into gauntlet done");
				break;
			case 6:
				return;
			}
		}
	}
	
	public void prompt() {
		out.println("Select action :");
		out.println("1: Forge new Item");
		out.println("2: Equip item to " + hero.getName());
		out.println("3: Unequip item from " + hero.getName());
		out.println("4: Upgrade an Item");
		out.println("5: Put a gem into gauntlet");
		out.println("6: Exit Shop");
	}
}
