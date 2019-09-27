package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import hero.EquipItemFailedException;
import hero.Hero;
import hero.UnequipItemFailedException;
import item.items.Gem;
import item.items.GemGauntlet;

public class TestGemGauntlet {

	Hero hero;
	GemGauntlet gauntlet;

	@Before
	public void setUp() {
		hero = new Hero("Thanos?", 1, 0, 0, 6);
		gauntlet = new GemGauntlet();
	}

	@Test
	public void testConstructor() {
		assertEquals("Gem Gauntlet", gauntlet.getName());
		assertEquals("Powerful gauntlet with gem sockets, gets stronger with more gems", gauntlet.getDescription());
	}

	@Test
	public void testAddGemToSocket() {
		Gem gem1 = new Gem("gem1", "", 19, 10, 3);
		gauntlet.addGemToSocket(gem1);
		assertEquals(1, gauntlet.getSockets().size());
		assertEquals(gem1, gauntlet.getSockets().get(0));
	}

	@Test
	public void testEquip() {
		try {
			hero.equipItem(gauntlet);
		} catch (EquipItemFailedException e) {
			fail("equipItem throws error");
		}

		assertEquals(5, hero.getAttack());
	}

	@Test
	public void testUnequip() {
		int originalHp = hero.getHp();
		int originalAttack = hero.getAttack();
		int originalDefense = hero.getDefense();
		
		try {
			hero.equipItem(gauntlet);
		} catch (EquipItemFailedException e) {
			fail("equipItem throws error");
		}
		try {
			hero.unequipItem(0);
		} catch (UnequipItemFailedException e) {
			fail("unequipItem throws error");
		}

		assertEquals(originalHp, hero.getHp());
		assertEquals(originalAttack, hero.getAttack());
		assertEquals(originalDefense, hero.getDefense());
	}
}
