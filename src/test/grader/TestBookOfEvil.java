package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import hero.EquipItemFailedException;
import hero.Hero;
import item.items.BookOfEvil;

public class TestBookOfEvil {
	
	private Hero hero;
	private BookOfEvil book;
	@Before
	public void setUp() {
		hero = new Hero("testHero", 100, 100, 100, 100);
		book = new BookOfEvil();
	}
	
	@Test
	public void testConstructor() {
		assertEquals("Book of Evil [level 0]", book.getName());
		assertEquals("A book containing evil knowledges, can store infinitely many pages", book.getDescription());
		assertEquals(0, book.getUpgradeLevel());
	}
	
	@Test
	public void testEquip() {
		try {
			hero.equipItem(book);
		} catch (EquipItemFailedException e) {
			fail("equipItem throws error");
		}
		assertEquals(110, hero.getAttack());
	}
	
	@Test
	public void testUpgrade() {
		book.upgrade();
		assertEquals(1, book.getUpgradeLevel());
	}
}
