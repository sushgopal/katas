import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
	static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
	static final String VEST = "+5 Dexterity Vest";
	static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	static final String AGED_BRIE = "Aged Brie";

	private static List<Item> items = null;

	public static void main(String[] args) {

		items = new ArrayList<Item>();
		items.add(new Item(VEST, 10, 20));
		items.add(new Item(AGED_BRIE, 2, 0));
		items.add(new Item(ELIXIR_OF_THE_MONGOOSE, 5, 7));
		items.add(new Item(SULFURAS, 0, 80));
		items.add(new Item(BACKSTAGE_PASSES, 15, 20));
		items.add(new Item(CONJURED_MANA_CAKE, 3, 6));
		for (int i = 0; i < items.size(); i++) {
			updateQuality(items.get(i));
		}
	}

	public static void updateAgedBrieQuality(Item item) {
		AgedBrieItem agedBrieItem = new AgedBrieItem(item);
		agedBrieItem.update();
	}

	public static void updateBackstagePassQuality(Item item) {
		BackstagePassItem bpItem = new BackstagePassItem(item);
		bpItem.update();
	}

	public static void updateQuality(Item item) {
		if (AGED_BRIE.equals(item.getName())) {
			updateAgedBrieQuality(item);
			return;
		}
		if (BACKSTAGE_PASSES.equals(item.getName())) {
			updateBackstagePassQuality(item);
			return;
		}
		if (SULFURAS.equals(item.getName())) {
			return;
		}
		ItemWrapper wrappedItem = new ItemWrapper(item);
		wrappedItem.update();
	}
}