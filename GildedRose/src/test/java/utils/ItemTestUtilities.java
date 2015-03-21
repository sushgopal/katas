package utils;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import model.AgedBrieItem;
import model.BackstagePassItem;
import model.Item;
import model.ItemWrapper;
import model.SulfurasItem;


public class ItemTestUtilities {

	public static <T extends ItemWrapper> void assertQualityOfItemIs(T item, int quality) {
		item.update();
		assertThat(item.getQuality(), is(quality));
	}
	
	public static <T extends ItemWrapper> void assertSellInOfItemIs(T item, int sellIn) {
		item.update();
		assertThat(item.getSellIn(), is(sellIn));
	}
	
	public static AgedBrieItem createAgedBrieItemWith(int sellIn,int quality) {
		return new AgedBrieItem(createItemWith(sellIn, quality));
	}

	public static BackstagePassItem createBackstagePassItemWith(int sellIn,int quality) {
		return new BackstagePassItem(createItemWith(sellIn, quality));
	}
	
	public static SulfurasItem createSulfurasItemWith(int sellIn,int quality) {
		return new SulfurasItem(createItemWith(sellIn, quality));
	}
	
	public static ItemWrapper createWrappedItemWith(int sellIn,int quality) {
		return new ItemWrapper(createItemWith(sellIn, quality));
	}	
	
	private static Item createItemWith(int sellIn, int quality) {
		return new Item(null, sellIn, quality);
	}
}
