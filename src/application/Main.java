package application;

import java.util.Scanner;

import application.shop.Shop;
import hero.Hero;
import item.base.Item;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	private static void printLineSeparator() {
		System.out.println("==================================================");
	}
	
	private static void printHeroInventory(Hero hero) {
		int equippedItems = 0;
		for (Item item : hero.getInventory()) {
			if(item != null) {
				equippedItems += 1;
			}
		}
		System.out.println("Equipped Items (" + equippedItems + "/" + hero.getInventorySize() + ")");
		int index = 1;
		for (Item item : hero.getInventory()) {
			if(item != null) {
				System.out.println(index + ": " + item.toString());
				index += 1;
			}
		}
	}
	
	public static void main(String[] args) {
		printLineSeparator();
		System.out.println("============ CP Arena: Blacksmith's Shop =========");
		printLineSeparator();
		
		Hero hero = new HeroSelection(System.out, scanner).runHeroSelection();
		
		System.out.println("Selected " + hero.getName());
		printLineSeparator();
		
		System.out.println("Entering blacksmith's shop");
		new Shop(System.out, scanner, hero).run();
		
		printLineSeparator();
		System.out.println("Final stats: ");
		System.out.println(hero.toString());
		printHeroInventory(hero);
		printLineSeparator();
		
		System.out.println(hero.getName() + " is ready to fight!");
	}
}
