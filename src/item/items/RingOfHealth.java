package item.items;

import hero.Hero;
import item.base.Item;

// You CAN modify the first line
public class RingOfHealth extends Item {
	protected int hpPercentageBonus,plushp;
	public RingOfHealth(int hpPercentageBonus) {
		super("Orb of Health (+" + hpPercentageBonus + "%)","increase hp by " + hpPercentageBonus + "%");
		// use the given name and description
		//String name = "Orb of Health (+" + hpPercentageBonus + "%)";
		//String description =  "increase hp by " + hpPercentageBonus + "%";
		this.hpPercentageBonus = hpPercentageBonus;
	}
	public void applyBonuses(Hero hero) {
		this.plushp = (hero.getHp()* this.hpPercentageBonus)/ 100;
		hero.setHp(hero.getHp()+this.plushp);
	}
	public void unapplyBonuses(Hero hero) {
		hero.setHp(hero.getHp()-this.plushp);
	}
	
}
