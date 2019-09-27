package application.shop.actions;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import application.ShopApp;
import item.base.Item;
import item.base.UpgradableItem;

public class UpgradeItem extends ShopApp {
	
	private List<Item> items;

	public UpgradeItem(PrintStream out, Scanner in, List<Item> items) {
		super(out, in);
		this.items = items.stream()
					.filter(item -> item instanceof UpgradableItem)
					.collect(Collectors.toList());
	}
	
	public void run() {
		UpgradableItem item =(UpgradableItem) getItemChoice(this.items, () -> this.prompt());
		item.upgrade();
	}
	
	public void prompt() {
		out.println("Select item to upgrade");
		int index = 1;
		for (Item item : items) {
			out.println(index + ": " + item.getName());
		}
	}

}
