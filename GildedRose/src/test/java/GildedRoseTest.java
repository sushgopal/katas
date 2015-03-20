import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;


public class GildedRoseTest {

	@Test
	public void qualityDecreases() {
		Item item = new Item(GildedRose.CONJURED_MANA_CAKE, 1, 10);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(9));		
	}
	
	@Test
	public void sellInDecreases() {
		Item item = new Item(GildedRose.CONJURED_MANA_CAKE, 1, 10);
		GildedRose.updateQuality(item);
		assertThat(item.getSellIn(), is(0));
	}
	
	@Test
	public void qualityDecreasesByTwoForPassedSellIn() {
		Item item = new Item(GildedRose.CONJURED_MANA_CAKE, 0, 10);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(8));	
	}
	
	@Test
	public void qualityNotDecreasesByTwoForPassedSellIn() {
		Item item = new Item(GildedRose.CONJURED_MANA_CAKE, 0, 1);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(0));	
	}
	
	@Test
	public void qualityIsNotDecreasedWhenZero() {
		Item item = new Item(GildedRose.CONJURED_MANA_CAKE, 1, 0);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(0));		
	}
	
	@Test
	public void sulfurasQualityDoesNotDecrease() {
		Item item = new Item(GildedRose.SULFURAS, -1, 80);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(80));
	}
	
	@Test
	public void sulfurasSellInDoesNotDecrease() {
		Item item = new Item(GildedRose.SULFURAS, 0, 80);
		GildedRose.updateQuality(item);
		assertThat(item.getSellIn(), is(0));		
	}
	
	@Test
	public void qualityIsNotIncrementedAboveFifty() {
		Item item = new Item(GildedRose.AGED_BRIE, 10, 50);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(50));	
	}
	
}


