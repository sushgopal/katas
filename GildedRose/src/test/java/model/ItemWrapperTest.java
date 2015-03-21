package model;
import static utils.ItemTestUtilities.assertQualityOfItemIs;
import static utils.ItemTestUtilities.assertSellInOfItemIs;
import static utils.ItemTestUtilities.createWrappedItemWith;
import model.ItemWrapper;

import org.junit.Test;

public class ItemWrapperTest {
	ItemWrapper underTest;
	
	@Test
	public void qualityDecreases() {
		underTest = createWrappedItemWith(1, 10);
		assertQualityOfItemIs(underTest, 9);	
	}
	
	@Test
	public void sellInDecreases() {
		underTest = createWrappedItemWith(1, 10);
		assertSellInOfItemIs(underTest, 0);
	}
	
	@Test
	public void qualityDecreasesByTwoForPassedSellIn() {
		underTest = createWrappedItemWith(0, 10);
		assertQualityOfItemIs(underTest, 8);		
	}
	
	@Test
	public void qualityNotDecreasesByTwoForPassedSellIn() {
		underTest = createWrappedItemWith(0, 1);
		assertQualityOfItemIs(underTest, 0);		
	}
	
	@Test
	public void qualityIsNotDecreasedWhenZero() {
		underTest = createWrappedItemWith(1, 0);
		assertQualityOfItemIs(underTest, 0);			
	}
}
