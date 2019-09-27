package hero;

import item.base.Item;

public class Hero {
	public Hero(String name, int hp, int attack, int defense, int inventorySize) {
	}

	public Item[] getInventory() {
	}

	public int equipItem(Item item) /* you might want to add something here */ {
	}

	public Item unequipItem(int slotNumber) /* you might want to add something here */ {
	}

	@Override
	public String toString() {
		// you do NOT need to modify this method
		return new StringBuilder()
				.append("{").append(this.getName()).append("}")
				.append(":[")
				.append("hp:").append(this.getHp())
				.append(" atk:").append(this.getAttack())
				.append(" def:").append(this.getDefense())
				.append("] ")
				.append("(").append(this.getInventorySize()).append(" item slots)")
				.toString();
	}
}
