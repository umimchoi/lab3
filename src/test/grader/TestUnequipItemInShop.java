package test.grader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import application.shop.actions.UnequipItem;
import hero.EquipItemFailedException;
import hero.Hero;
import item.base.Item;
import item.items.BasicItem;

public class TestUnequipItemInShop {
	UnequipItem unequipItem;
	Hero hero;
	ByteArrayInputStream in;
	ByteArrayOutputStream out;
	
	@Test
	public void testUnequipItem() {
		hero = new Hero("testHero", 100, 0, 0, 1);
		out = new ByteArrayOutputStream();
		in = new ByteArrayInputStream("1\ny\ny".getBytes());
		BasicItem item = new BasicItem("should be equipped", "", 0, 0, 0);
		try {
			hero.equipItem(item);
		} catch (EquipItemFailedException e) {
			fail("equipItem throws error");
		}
		List <Item> items = new ArrayList<Item>();
		unequipItem = new UnequipItem(new PrintStream(out), new Scanner(in), hero, items);
		unequipItem.run();
		assertEquals(null, hero.getInventory()[0]);
		assertEquals(1, items.size());
	}
	
	@Test
	public void testEquipItemFailed() {
		hero = new Hero("testHero", 100, 0, 0, 1);
		out = new ByteArrayOutputStream();
		in = new ByteArrayInputStream("1\ny\ny".getBytes());
		List<Item> items = new ArrayList<Item>();
		unequipItem = new UnequipItem(new PrintStream(out), new Scanner(in), hero, items);
		unequipItem.run();
		
		String printedContent = out.toString();
		assertEquals(0, items.size());
		assertTrue(printedContent.contains("Unequip item failed"));
	}
}
