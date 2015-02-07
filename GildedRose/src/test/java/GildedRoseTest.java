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
	public void agedBrieQualityIncreases() {
		Item item = new Item(GildedRose.AGED_BRIE, -1, 48);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(50));
	}
	
	@Test
	public void agedBrieQualityDoesNotIncrease() {
		Item item = new Item(GildedRose.AGED_BRIE, 0, 50);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(50));
	}
	
	@Test
	public void qualityIsNotIncrementedAboveFifty() {
		Item item = new Item(GildedRose.AGED_BRIE, 10, 50);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(50));	
	}
	
	@Test
	public void backStagePassQualityIsZeroPassedSellIn() {
		Item item = new Item(GildedRose.BACKSTAGE_PASSES, 0, 30);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(0));
	}
	
	@Test
	public void backStagePassQualityIncreasesByOne() {
		Item item = new Item(GildedRose.BACKSTAGE_PASSES, 15, 20);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(21));		
	}
	
	@Test
	public void backStagePassQualityIncreasesByTwo() {
		Item item = new Item(GildedRose.BACKSTAGE_PASSES, 10, 20);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(22));		
	}
	
	@Test
	public void backStagePassQualityIncreasesByTwo_2() {
		Item item = new Item(GildedRose.BACKSTAGE_PASSES, 10, 49);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(50));		
	}
	
	@Test
	public void backStagePassQualityIncreasesByThree() {
		Item item = new Item(GildedRose.BACKSTAGE_PASSES, 5, 20);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(23));		
	}
	
	@Test
	public void backStagePassQualityNotIncreasedAboveFifty() {
		Item item = new Item(GildedRose.BACKSTAGE_PASSES, 5, 48);
		GildedRose.updateQuality(item);
		assertThat(item.getQuality(), is(50));		
	}
	
}


