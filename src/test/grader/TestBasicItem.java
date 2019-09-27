package test.grader;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.Test;

import hero.EquipItemFailedException;
import hero.Hero;
import hero.UnequipItemFailedException;
import item.items.BasicItem;

public class TestBasicItem {
	
	Hero hero;
	
	@Before
	public void setUp() {
		hero = new Hero("testHero", 100, 100, 100, 6);
	}
	
	@Test
	public void testConstructor() {
		BasicItem item = new BasicItem("testItem", "test item 1", 10, 10, 10);
		assertEquals("testItem", item.getName());
		assertEquals("test item 1", item.getDescription());
	}
	
	@Test
	public void testEquip() {
		BasicItem item = new BasicItem("testItem", "", 10, 0, 0);
		try {
			hero.equipItem(item);
		} catch (EquipItemFailedException e) {
			fail("equipItem throws error");
		}
		assertEquals(110, hero.getHp());
	}

	@Test
	public void testUnequip() {
		BasicItem item = new BasicItem("testItem", "", 100, 100, 100);
		try {
			hero.equipItem(item);
		} catch (EquipItemFailedException e) {
			fail("equipItem throws error");
		}
		try {
			hero.unequipItem(0);
		} catch (UnequipItemFailedException e) {
			fail("unequipItem throws error");
		}
		assertEquals(100, hero.getHp());
		assertEquals(100, hero.getAttack());
		assertEquals(100, hero.getDefense());
	}
}
