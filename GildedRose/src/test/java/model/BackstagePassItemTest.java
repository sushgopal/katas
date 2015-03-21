package model;
import static utils.ItemTestUtilities.assertQualityOfItemIs;
import static utils.ItemTestUtilities.createBackstagePassItemWith;
import model.BackstagePassItem;

import org.junit.Test;

public class BackstagePassItemTest {

	BackstagePassItem underTest;
	
	@Test
	public void backStagePassQualityIsZeroPassedSellIn() {
		underTest = createBackstagePassItemWith(0, 30);
		assertQualityOfItemIs(underTest, 0);
	}
	
	@Test
	public void backStagePassQualityIncreasesByOne() {
		underTest = createBackstagePassItemWith(15, 20);
		assertQualityOfItemIs(underTest, 21);
	}
	
	@Test
	public void backStagePassQualityIncreasesByTwo() {
		underTest = createBackstagePassItemWith(10, 20);
		assertQualityOfItemIs(underTest, 22);
	}
	
	@Test
	public void backStagePassQualityIncreasesByThree() {
		underTest = createBackstagePassItemWith(5, 20);
		assertQualityOfItemIs(underTest, 23);
	}
	
}
