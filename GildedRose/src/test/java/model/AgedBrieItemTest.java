package model;
import static utils.ItemTestUtilities.assertQualityOfItemIs;
import static utils.ItemTestUtilities.createAgedBrieItemWith;
import model.AgedBrieItem;

import org.junit.Test;

public class AgedBrieItemTest {
	private AgedBrieItem underTest;
	
	@Test
	public void agedBrieQualityIncreasesOnUpdate() {
		underTest = createAgedBrieItemWith(5, 43);
		assertQualityOfItemIs(underTest, 44);
	}
	
	@Test
	public void agedBrieQualityIncreasesByTwo() {
		underTest = createAgedBrieItemWith(0, 48);
		assertQualityOfItemIs(underTest, 50);
	}
	
}
