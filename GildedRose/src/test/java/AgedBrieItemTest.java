import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class AgedBrieItemTest {
	AgedBrieItem underTest;
	
	@Test
	public void agedBrieQualityIncreasesOnUpdate() {
		underTest = new AgedBrieItem(new Item(GildedRose.AGED_BRIE, 5, 43));
		underTest.update();
		assertThat(underTest.getItem().getQuality(), is(44));
	}
	
	@Test
	public void agedBrieQualityIncreasesByTwo() {
		underTest = new AgedBrieItem(new Item(GildedRose.AGED_BRIE, 0, 48));
		underTest.update();
		assertThat(underTest.getItem().getQuality(), is(50));
	}
	
	
}
