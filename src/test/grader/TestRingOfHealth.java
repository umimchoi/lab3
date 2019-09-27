package test.grader;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.Test;

import hero.EquipItemFailedException;
import hero.Hero;
import hero.UnequipItemFailedException;
import item.items.RingOfHealth;

public class TestRingOfHealth {
	
	Hero hero;
	
	@Before
	public void setUp() {
		hero = new Hero("testHero", 100, 0, 0, 6);
	}
	
	@Test
	public void testEquip() {
		RingOfHealth ooh = new RingOfHealth(20);
		try {
			hero.equipItem(ooh);
		} catch (EquipItemFailedException e) {
			fail("equipItem throws error");
		}
		assertEquals(120, hero.getHp());
	}
	
	@Test
	public void testUnequip() {
		RingOfHealth ooh = new RingOfHealth(20);
		try {
			hero.equipItem(ooh);
		} catch (EquipItemFailedException e) {
			fail("equipItem throws error");
		}
		try {
			hero.unequipItem(0);
		} catch (UnequipItemFailedException e) {
			fail("unequipItem throws error");
		}
		assertEquals(100, hero.getHp());
	}
}
