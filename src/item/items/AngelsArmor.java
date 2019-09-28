package item.items;

import hero.Hero;
import item.base.UpgradableItem;

// You CAN modify the first line
public class AngelsArmor extends UpgradableItem {
	private int UpgradeLevel =1,plushp=0,plusattack=0,plusdefense=0;
	public AngelsArmor() {
		// use the given name and description
		super("Angel's Armor","Armor wielded by Heaven's people");
	//	String name = "Angel's Armor";
	//	String description = "Armor wielded by Heaven's people";
	//	super(name,description);
	}

	@Override
	public void upgrade() {
		this.UpgradeLevel++;
		if(this.UpgradeLevel>3)
		{
			this.UpgradeLevel = 3;
		}
	}

	@Override
	public int getUpgradeLevel() {
		return this.UpgradeLevel;
	}

	@Override
	public void applyBonuses(Hero hero) {
		if(this.UpgradeLevel == 1) {
			this.plusdefense = 10;
			hero.setDefense(hero.getDefense()+this.plusdefense);
		}
		else if (this.UpgradeLevel == 2) {
			this.plusdefense = 27;
			this.plushp = 233;
			hero.setDefense(hero.getDefense()+this.plusdefense);
			hero.setHp(hero.getHp()+this.plushp);
		}
		else if (this.UpgradeLevel == 3) {
			this.plusdefense = 46;
			this.plushp = 326;
			this.plusattack = 23;
			hero.setDefense(hero.getDefense()+this.plusdefense);
			hero.setHp(hero.getHp()+this.plushp);
			hero.setAttack(hero.getAttack()+this.plusattack);
		}
	}

	@Override
	public void unapplyBonuses(Hero hero) {
		hero.setDefense(hero.getDefense()-this.plusdefense);
		hero.setHp(hero.getHp()-this.plushp);
		hero.setAttack(hero.getAttack()-this.plusattack);
		
	}
}
