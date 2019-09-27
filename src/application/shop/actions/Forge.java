package application.shop.actions;

import java.io.PrintStream;
import java.util.Scanner;

import application.ShopApp;
import application.shop.actions.forge.ForgeBasicItem;
import application.shop.actions.forge.ForgeGem;
import application.shop.actions.forge.ForgeRingOfHealth;
import item.base.Item;
import item.items.AngelsArmor;
import item.items.BookOfEvil;
import item.items.GemGauntlet;

public class Forge extends ShopApp {

	public Forge(PrintStream out, Scanner in) {
		super(out, in);
		out.println("Forging new item");
	}

	public Item runForge() {
		int choice = this.getChoice(1, 7, false, () -> this.promptItemType());
		switch (choice) {
		case 1:
			return new ForgeBasicItem(this.out, this.in).runForge();
		case 2:
			return new ForgeRingOfHealth(this.out, this.in).runForge();
		case 3:
			return new BookOfEvil();
		case 4:
			return new AngelsArmor();
		case 5:
			// remove this line if you do the optional challenge
			System.out.println("gem guantlet not implemented yet!");
			// uncomment if you do the optional challenge
			// return new GemGauntlet();
			break;
		case 6:
			// remove this line if you do the optional challenge
			System.out.println("gem not implemented yet!");
			// uncomment if you do the optional challenge
			// return new ForgeGem(this.out, this.in).runForge();
			break;
		case 7:
			return null;
		}
		return null;
	}

	public void promptItemType() {
		out.println("Select action :");
		out.println("1: Basic Item");
		out.println("2: Ring of Health");
		out.println("3: Book of Evil");
		out.println("4: Angels Armor");
		out.println("5: Gem Gauntlet");
		out.println("6: Gem");
		out.println("7: Cancel");
	}
}
