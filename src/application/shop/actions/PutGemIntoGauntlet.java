package application.shop.actions;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import application.ShopApp;
import item.base.Item;
import item.items.Gem;
import item.items.GemGauntlet;

public class PutGemIntoGauntlet extends ShopApp {
	
	private List<Item> gauntlets;
	private List<Item> gems;
	private List<Item> items;

	public PutGemIntoGauntlet(PrintStream out, Scanner in, List<Item> items) {
		super(out, in);
		this.gauntlets = items.stream()
				.filter(item -> item instanceof GemGauntlet)
				.collect(Collectors.toList());
		
		this.gems = items.stream()
				.filter(item -> item instanceof Gem)
				.collect(Collectors.toList());
		this.items = items;
	}
	
	public void run() {
		GemGauntlet gauntlet = (GemGauntlet) this.getItemChoice(this.gauntlets, () -> this.promptGauntlets());
		Gem gem = (Gem) this.getItemChoice(this.gems, () -> this.promptGems());
		gauntlet.addGemToSocket(gem);
		this.items.remove(gem);
	}
	
	public void promptGauntlets() {
		out.println("Select gauntlet");
		int index = 1;
		for (Item item : gauntlets) {
			out.println(index + ": " + item.toString());
		}
	}
	
	public void promptGems() {
		out.println("Select gem");
		int index = 1;
		for (Item item : gems) {
			out.println(index + ": " + item.toString());
		}
	}
}
