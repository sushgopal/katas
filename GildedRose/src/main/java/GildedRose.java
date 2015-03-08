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
		incrementQualityByOne(item);
		decrementSellIn(item);
		if (item.getSellIn() < 0) {
			incrementQualityByOne(item);
		}
	}

	public static void updateBackstagePassQuality(Item item) {
		incrementQualityByOne(item);
		if (ifSellInLesserThanEleven(item)) {
			incrementQualityByOne(item);
		}
		if (ifSellInLesserThanSix(item)) {
			incrementQualityByOne(item);
		}
		decrementSellIn(item);
		if (item.getSellIn() < 0) {
			item.setQuality(0);
		}
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
		decrementQualityByOne(item);
		decrementSellIn(item);
		if (item.getSellIn() < 0) {
			decrementQualityByOne(item);
		}
	}

	private static void decrementSellIn(Item item) {
		item.setSellIn(item.getSellIn() - 1);
	}

	private static boolean ifQualityIsGreaterThanZero(Item item) {
		return item.getQuality() > 0;
	}

	private static boolean ifSellInLesserThanSix(Item item) {
		return item.getSellIn() < 6;
	}

	private static boolean ifSellInLesserThanEleven(Item item) {
		return item.getSellIn() < 11;
	}

	private static boolean ifQualityLesserThanFifty(Item item) {
		return item.getQuality() < 50;
	}

	private static void incrementQualityByOne(Item item) {
		if (ifQualityLesserThanFifty(item)) {
			item.setQuality(item.getQuality() + 1);
		}
	}

	private static void decrementQualityByOne(Item item) {
		if (ifQualityIsGreaterThanZero(item)) {
			item.setQuality(item.getQuality() - 1);
		}
	}

}