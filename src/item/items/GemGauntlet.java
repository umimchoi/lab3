package item.items;

import java.util.ArrayList;
import java.util.List;

import hero.Hero;
import item.base.Item;

// Optional Challenge!
// You CAN modify the first line
public class GemGauntlet {
	public GemGauntlet() {
		String name = "Gem Gauntlet";
		String description = "Powerful gauntlet with gem sockets, gets stronger with more gems";
	}
	
	public void addGemToSocket(Gem gem) {}
	
	public Gem removeGemFromSocket(int index) {}
	
	private void applyBaseBonuses(Hero hero) {}
	
	private void unapplyBaseBonuses(Hero hero) {}
	
	public void applyBonuses(Hero hero) {
		this.applyBaseBonuses(hero);
		// apply bonuses of gems in sockets
	}
	
	public void unapplyBonuses(Hero hero) {
		this.unapplyBaseBonuses(hero);
		// unapply bonuses of gems in sockets
	}
	
	public List<Gem> getSockets() {}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString())
				.append("\n")
				.append(/* number of gems inserted */)
				.append(" gems: ");
		for (Gem gem : /* list of inserted gems */) {
			sb.append(gem.toString());
			sb.append(", ");
		}
		return sb.toString();
	}
}
