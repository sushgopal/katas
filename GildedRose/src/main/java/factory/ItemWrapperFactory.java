package factory;

import model.AgedBrieItem;
import model.BackstagePassItem;
import model.Item;
import model.ItemWrapper;
import model.SulfurasItem;


public class ItemWrapperFactory {

	static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
	static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
	static final String VEST = "+5 Dexterity Vest";
	static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	static final String AGED_BRIE = "Aged Brie";

	public ItemWrapper getWrappedItem(Item item) {
		if(item.getName().equals(AGED_BRIE)) {
			return new AgedBrieItem(item);
		}
		else if(item.getName().equals(BACKSTAGE_PASSES)) {
			return new BackstagePassItem(item);
		}
		else if(item.getName().equals(SULFURAS)) {
			return new SulfurasItem(item);
		}
		return new ItemWrapper(item);
	}

}
