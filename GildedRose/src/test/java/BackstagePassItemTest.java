import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class BackstagePassItemTest {

	BackstagePassItem underTest;
	
	@Test
	public void backStagePassQualityIsZeroPassedSellIn() {
		underTest = new BackstagePassItem(new Item(GildedRose.BACKSTAGE_PASSES, 0, 30));
		underTest.update();
		assertThat(underTest.getItem().getQuality(), is(0));
	}
	
	@Test
	public void backStagePassQualityIncreasesByOne() {
		underTest = new BackstagePassItem(new Item(GildedRose.BACKSTAGE_PASSES, 15, 20));
		underTest.update();
		assertThat(underTest.getItem().getQuality(), is(21));	
	}
	
	@Test
	public void backStagePassQualityIncreasesByTwo() {
		underTest = new BackstagePassItem(new Item(GildedRose.BACKSTAGE_PASSES, 10, 20));
		underTest.update();
		assertThat(underTest.getItem().getQuality(), is(22));
	}
	
	@Test
	public void backStagePassQualityIncreasesByThree() {
		underTest = new BackstagePassItem(new Item(GildedRose.BACKSTAGE_PASSES, 5, 20));
		underTest.update();
		assertThat(underTest.getItem().getQuality(), is(23));
	}
	
}
