package application.shop.actions.forge;

import java.io.PrintStream;
import java.util.Scanner;

import application.ShopApp;
import item.items.Gem;

public class ForgeGem extends ShopApp {

	public ForgeGem(PrintStream out, Scanner in) {
		super(out, in);
		out.println("Forging a gem");
	}
	
	public Gem runForge() {
		out.print("Input gem name: ");
		String name = in.nextLine();
		
		out.print("Input gem description: ");
		String description = in.nextLine();
		
		out.print("Input gem base HP bonus: ");
		int hpBonus = in.nextInt();
		
		out.print("Input gem base attack bonus: ");
		int attackBonus = in.nextInt();
		
		out.print("Input gem base defense bonus: ");
		int defenseBonus = in.nextInt();
		
		return new Gem(name, description, hpBonus, attackBonus, defenseBonus);
	}
}
