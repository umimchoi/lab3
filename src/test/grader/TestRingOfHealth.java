package test.grader;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.Test;

import hero.EquipItemFailedException;
import hero.Hero;
import hero.UnequipItemFailedException;
import item.items.BasicItem;
import item.items.RingOfHealth;

public class TestRingOfHealth {
	
	Hero hero,hero3,hero2;
	
	@Before
	public void setUp() {
		hero = new Hero("testHero", 100, 0, 0, 6);
		hero2 = new Hero("testHero2", 100, 0, 0, 6);
		hero3 = new Hero("testHero2", 100, 0, 0, 6);
	}
	
	@Test
	public void testEquip() {
		RingOfHealth ooh = new RingOfHealth(20);
		RingOfHealth wow = new RingOfHealth(15);
		BasicItem basic = new BasicItem("basic", "", 100, 100, 100);
		try {
			hero.equipItem(ooh);
			hero2.equipItem(basic);
			hero2.equipItem(wow);
			hero3.equipItem(wow);
			hero3.equipItem(basic);
		} catch (EquipItemFailedException e) {
			fail("equipItem throws error");
		}
		assertEquals(120, hero.getHp());
		assertEquals(215, hero3.getHp());
		assertEquals(230, hero2.getHp());
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
