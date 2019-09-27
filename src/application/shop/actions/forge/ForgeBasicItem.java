package application.shop.actions.forge;

import java.io.PrintStream;
import java.util.Scanner;

import application.ShopApp;
import item.items.BasicItem;

public class ForgeBasicItem extends ShopApp {

	public ForgeBasicItem(PrintStream out, Scanner in) {
		super(out, in);
		out.println("Forging Basic Item");
	}
	
	public BasicItem runForge() {
		in.nextLine();
		out.print("Input item name: ");
		String name = in.nextLine();
		
		out.print("Input item description: ");
		String description = in.nextLine();
		
		out.print("Input HP bonus: ");
		int hpBonus = in.nextInt();
		
		out.print("Input attack bonus: ");
		int attackBonus = in.nextInt();
		
		out.print("Input defense bonus: ");
		int defenseBonus = in.nextInt();
		
		return new BasicItem(name, description, hpBonus, attackBonus, defenseBonus);
	}
	

}
