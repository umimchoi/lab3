package hero;

import item.base.Item;

public class Hero {
	public Item[] inventory;
	public int inventorySize;
	public String name;
	public int hp;
	public int attack;
	public int defense;
	public Hero(String name, int hp, int attack, int defense, int inventorySize) {
		setHp(hp);
		this.name = name;
		if(inventorySize < 1 )
		{
			this.inventorySize = 1;
		}
		else if (inventorySize > 6)
		{
			this.inventorySize = 6;
		}
		else 
		{
			this.inventorySize = inventorySize;
		}
		setAttack(attack);
		setDefense(defense);
		this.inventory = new Item[inventorySize];
	}

	public Item[] getInventory() {
		return this.inventory.clone();
	}
	public int getDefense() {
		return this.defense;
	}
	public int getAttack() {
		return this.attack;
	}
	public int getInventorySize()
	{
		return this.inventorySize;
	}

	public int equipItem(Item item) throws EquipItemFailedException  /* you might want to add something here */ {
		int i;
		boolean check = false;
		for(i=0;i<this.inventorySize;i++)
		{
			if(this.inventory[i]==null)
			{
				this.inventory[i] = item;
				check = true;
				this.inventorySize --;
				item.applyBonuses(this);
				break;
			}
		}
		if (!check){
		throw new EquipItemFailedException("Hero inventory is full");
		}
		return i;
	}

	public Item unequipItem(int slotNumber) throws UnequipItemFailedException/* you might want to add something here */ {
	if(slotNumber >= this.inventorySize)
	{
		throw new UnequipItemFailedException("Hero does not have that many slots");
	}
	else if (this.inventory[slotNumber]==null)
	{
		throw new UnequipItemFailedException("No item in that slot");
	}
	this.inventory[slotNumber].unapplyBonuses(this);
	Item unequip = this.inventory[slotNumber];
	this.inventory[slotNumber] = null;
	this.inventorySize++;
		return unequip;
	
	}
	public void setHp(int hp)
	{
		if(hp<1)
		{
			this.hp=1;
		}
		else {
			this.hp = hp;
		}
	}
	public int getHp() {
		return this.hp;
	}
	public String getName() {
		return this.name;
	}
	public void setAttack(int attack)
	{
			this.attack = attack;
	}
	public void setDefense(int defense){
			this.defense = defense;
		
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
