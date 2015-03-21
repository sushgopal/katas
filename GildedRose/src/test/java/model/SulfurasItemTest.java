package model;
import static utils.ItemTestUtilities.assertQualityOfItemIs;
import static utils.ItemTestUtilities.assertSellInOfItemIs;
import static utils.ItemTestUtilities.createSulfurasItemWith;
import model.SulfurasItem;

import org.junit.Test;

public class SulfurasItemTest {

	SulfurasItem underTest;
	
	@Test
	public void sulfurasQualityDoesNotDecrease() {
		underTest = createSulfurasItemWith(-1, 80);
		assertQualityOfItemIs(underTest, 80);
	}
	
	@Test
	public void sulfurasSellInDoesNotDecrease() {
		underTest = createSulfurasItemWith(0, 80);
		assertSellInOfItemIs(underTest, 0);		
	}
}
