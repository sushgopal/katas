import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
	private static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
	private static final String VEST = "+5 Dexterity Vest";
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";

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

	public static void updateQuality(Item item) {
		if ((!AGED_BRIE.equals(item.getName()))
				&& !BACKSTAGE_PASSES.equals(item.getName())) {
			if (ifQualityIsGreaterThanZero(item)) {
				if (!SULFURAS.equals(item.getName())) {
					decrementQualityByOne(item);
				}
			}
		} else {
			if (ifQualityLesserThanFifty(item)) {
				incrementQualityByOne(item);
				if (BACKSTAGE_PASSES.equals(item.getName())) {
					if (ifSellInLesserThanEleven(item)) {
						if (ifQualityLesserThanFifty(item)) {
							incrementQualityByOne(item);
						}
					}
					if (ifSellInLesserThanSix(item)) {
						if (ifQualityLesserThanFifty(item)) {
							incrementQualityByOne(item);
						}
					}
				}
			}
		}
		if (!SULFURAS.equals(item.getName())) {
			decrementSellIn(item);
		}
		if (item.getSellIn() < 0) {
			if (!AGED_BRIE.equals(item.getName())) {
				if (!BACKSTAGE_PASSES.equals(item.getName())) {
					if (ifQualityIsGreaterThanZero(item)) {
						if (!SULFURAS.equals(item.getName())) {
							decrementQualityByOne(item);
						}
					}
				} else {
					item.setQuality(0);
				}
			} else {
				if (ifQualityLesserThanFifty(item)) {
					incrementQualityByOne(item);
				}
			}
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
		item.setQuality(item.getQuality() + 1);
	}

	private static void decrementQualityByOne(Item item) {
		item.setQuality(item.getQuality() - 1);
	}

}