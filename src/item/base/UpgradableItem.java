package item.base;

// you CAN modify the first line 
public class UpgradableItem extends Item {
	public UpgradableItem(String name, String description) {
	}
	
	@Override
	public String getName() {
		// you do NOT have to modify this function
		return super.getName() + " [level " + this.getUpgradeLevel() + "]";
	}
}
