package item.items;

import hero.Hero;
import item.base.UpgradableItem;

public class BookOfEvil extends UpgradableItem {
	private int UpgradeLevel =0,plusattack;
	public BookOfEvil() {
		// use the given name and description
		super("Book of Evil","A book containing evil knowledges, can store infinitely many pages");
		/*String name = "Book of Evil";
		String description = "A book containing evil knowledges, can store infinitely many pages";
	*/}

	@Override
	public void upgrade() {
		this.UpgradeLevel ++;
	}

	@Override
	public int getUpgradeLevel() {
		return this.UpgradeLevel;
	}

	@Override
	public void applyBonuses(Hero hero) {
		this.plusattack = 10+(3*this.getUpgradeLevel());
		hero.setAttack(hero.getAttack()+this.plusattack);
	}

	@Override
	public void unapplyBonuses(Hero hero) {
		hero.setAttack(hero.getAttack()-this.plusattack);
	}
}
