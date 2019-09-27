package application.shop.actions.forge;

import java.io.PrintStream;
import java.util.Scanner;

import application.ShopApp;
import item.items.RingOfHealth;

public class ForgeRingOfHealth extends ShopApp {

	public ForgeRingOfHealth(PrintStream out, Scanner in) {
		super(out, in);
		out.println("Forging Ring of Health");
	}
	
	public RingOfHealth runForge() {
		out.println("Input HP percentage bonus");
		int hpPercentageBonus = in.nextInt();
		
		return new RingOfHealth(hpPercentageBonus);
	}
}
