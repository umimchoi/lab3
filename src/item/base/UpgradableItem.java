package item.base;

// you CAN modify the first line 
public abstract class UpgradableItem extends Item {
	public UpgradableItem(String name, String description) {
		super(name,description);
		
	}
	public abstract void upgrade();
	public abstract int getUpgradeLevel();
	@Override
	public String getName() {
		// you do NOT have to modify this function
		return super.getName() + " [level " + this.getUpgradeLevel() + "]";
	}
}
