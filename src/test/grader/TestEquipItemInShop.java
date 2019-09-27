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

import application.shop.actions.EquipItem;
import hero.EquipItemFailedException;
import hero.Hero;
import item.base.Item;
import item.items.BasicItem;

public class TestEquipItemInShop {
	EquipItem equipItem;
	Hero hero;
	ByteArrayInputStream in;
	ByteArrayOutputStream out;
	
	@Test
	public void testEquipItem() {
		hero = new Hero("testHero", 100, 0, 0, 1);
		out = new ByteArrayOutputStream();
		in = new ByteArrayInputStream("1\ny\ny".getBytes());
		List<Item> items = new ArrayList<Item>();
		BasicItem item = new BasicItem("should be equipped", "", 0, 0, 0);
		items.add(item);
		equipItem = new EquipItem(new PrintStream(out), new Scanner(in), hero, items);
		equipItem.run();
		assertEquals(item, hero.getInventory()[0]);
	}
	
	@Test
	public void testEquipItemFailed() {
		hero = new Hero("testHero", 100, 0, 0, 0);
		out = new ByteArrayOutputStream();
		in = new ByteArrayInputStream("1\ny\ny".getBytes());
		BasicItem item1 = new BasicItem("should be equipped", "", 0, 0, 0);
		try {
			hero.equipItem(item1);
		} catch (EquipItemFailedException e) {
			fail("equipItem throws error");
		}
		List<Item> items = new ArrayList<Item>();
		BasicItem item2 = new BasicItem("should not be equipped", "", 0, 0, 0);
		items.add(item2);
		equipItem = new EquipItem(new PrintStream(out), new Scanner(in), hero, items);
		equipItem.run();
		
		String printedContent = out.toString();
		assertEquals(1, items.size());
		assertTrue(printedContent.contains("Equip item failed"));
	}
}
