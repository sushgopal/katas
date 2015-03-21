import java.util.ArrayList;
import java.util.List;

import factory.ItemWrapperFactory;
import model.Item;

public class GildedRose {

	private static List<Item> items = null;

	ItemWrapperFactory itemWrapperFactory = new ItemWrapperFactory();
	
	public static void main(String[] args) {
		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));
		
		GildedRose gildedRose = new GildedRose();
		for(Item item:items) {
			gildedRose.updateQuality(item);
		}
	}
	
	void updateQuality(Item item) {
		itemWrapperFactory.getWrappedItem(item).update();
	}
}