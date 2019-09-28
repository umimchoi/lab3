package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import hero.EquipItemFailedException;
import hero.Hero;
import item.items.AngelsArmor;

public class TestAngelsArmor {
	
	Hero hero,hero2;
	AngelsArmor armor,armor2;
	
	@Before
	public void setUp() {
		hero = new Hero("testHero", 1, 0, 0, 6);
		hero2 = new Hero("testHero2", 1, 0, 0, 6);
		armor = new AngelsArmor();
		armor2 = new AngelsArmor();
	}
	
	@Test
	public void testConstructor() {
		assertEquals("Angel's Armor [level 1]", armor.getName());
		assertEquals("Armor wielded by Heaven's people", armor.getDescription());
		assertEquals(1, armor.getUpgradeLevel());
	}
	
	@Test
	public void testUpgrade() {
		armor.upgrade();
		assertEquals("Angel's Armor [level 2]", armor.getName());
		assertEquals(2, armor.getUpgradeLevel());
	}
	
	@Test
	public void testEquip() {
		try {
			hero.equipItem(armor);
			hero2.equipItem(armor2);
			armor2.upgrade();
		} catch (EquipItemFailedException e) {
			fail("equipItem throws error");
		}
		assertEquals(0, hero.getAttack());
		assertEquals(10, hero.getDefense());
		assertEquals(1, hero.getHp());
		assertEquals(2, armor2.getUpgradeLevel());
	}
}
