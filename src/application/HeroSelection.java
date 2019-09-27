package application;

import java.io.PrintStream;
import java.util.Scanner;

import hero.Hero;

public class HeroSelection extends ShopApp {
	public HeroSelection(PrintStream out, Scanner in) {
		super(out, in);
	}

	Hero[] heroes = {
			new Hero("Captain", 300, 23, 10, 6),
			new Hero("Mistress", 120, 77, 2, 4),
			new Hero("Assassin", 170, 66, 4, 2),
	};
	
	public Hero runHeroSelection() {
		int choice;
		out.println("Select hero: ");
		choice = this.getChoice(1, this.heroes.length, () -> this.printHeroes(), index -> this.heroes[index-1].getName());

		return heroes[choice - 1];
	}
	
	private void printHeroes() {
		int index = 1;
		for (Hero hero : heroes) {
			out.println(index + ": " + hero.toString());
			index += 1;
		}
	}	
}
