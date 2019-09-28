package item.items;

import hero.Hero;
import item.base.Item;

// You CAN modify the first line
public class BasicItem extends Item {
	protected int hpBonus,attackBonus,defenseBonus;
	public BasicItem(String name, String description, int hpBonus, int attackBonus, int defenseBonus) {
		super(name,description);
		this.hpBonus = hpBonus;
		this.attackBonus = attackBonus;
		this.defenseBonus = defenseBonus;
	}
	public void applyBonuses(Hero hero) {
		hero.setHp( hero.getHp() + this.hpBonus);
		hero.setAttack(hero.getAttack() + this.attackBonus);
		hero.setDefense(hero.getDefense() + this.defenseBonus);
	}
	public void unapplyBonuses(Hero hero) {
		hero.setHp( hero.getHp() - this.hpBonus);
		hero.setAttack(hero.getAttack() - this.attackBonus);
		hero.setDefense(hero.getDefense() - this.defenseBonus);
	}
}
