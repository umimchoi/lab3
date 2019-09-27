package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import hero.Hero;
import hero.EquipItemFailedException;
import hero.UnequipItemFailedException;
import item.items.BasicItem;

public class TestHero {
	
	private Hero hero;
	
	@Before
	public void setUp() {
		hero = new Hero("testHero", 120, 13, 3, 6);
	}
	
	@Test
	public void testConstructor() {
		assertEquals("testHero", hero.getName());
		for(int i=0; i<hero.getInventorySize(); i++) {
			assertNull(hero.getInventory()[i]);			
		}
	}
	
	@Test
	public void testSetters() {
		hero.setAttack(300);
		assertEquals(300, hero.getAttack());
		hero.setDefense(300);
		assertEquals(300, hero.getDefense());
		hero.setHp(300);
		assertEquals(300, hero.getDefense());
	}
	
	@Test
	public void testEquipItem() {
		BasicItem item = new BasicItem("testItem", "", 0, 0, 0);
		try {
			hero.equipItem(item);
		} catch (EquipItemFailedException e) {
			fail("equipItem throws error");
		}
		assertEquals(item, hero.getInventory()[0]);
	}
	
	@Test
	public void testUnequipItem() {
		BasicItem item = new BasicItem("testItem", "", 0, 0, 0);
		try {
			hero.equipItem(item);
		} catch (EquipItemFailedException e) {
			fail("equipItem throws error");
		}
		try {
		assertEquals(item, hero.unequipItem(0));
		} catch (UnequipItemFailedException e) {
			fail("unequipItem throw error");
		}
		assertNull(hero.getInventory()[0]);
	}
}
