package factory;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import model.AgedBrieItem;
import model.BackstagePassItem;
import model.Item;
import model.ItemWrapper;
import model.SulfurasItem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import factory.ItemWrapperFactory;

public class ItemWrapperFactoryTest {
	@InjectMocks
	ItemWrapperFactory underTest;
	
	@Mock
	private Item item;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldCreateWrappedItem() {
		stubItemToReturnName(ItemWrapperFactory.VEST);
		assertCreatedWrappedItemIsInstanceOf(ItemWrapper.class);
	}
	
	@Test
	public void shouldCreateAgedBrieWrappedItem() {
		stubItemToReturnName(ItemWrapperFactory.AGED_BRIE);
		assertCreatedWrappedItemIsInstanceOf(AgedBrieItem.class);
	}
	
	@Test
	public void shouldCreateBackstagePassWrappedItem() {
		stubItemToReturnName(ItemWrapperFactory.BACKSTAGE_PASSES);
		assertCreatedWrappedItemIsInstanceOf(BackstagePassItem.class);
	}
	
	@Test
	public void shouldCreateSulfurasWrappedItem() {
		stubItemToReturnName(ItemWrapperFactory.SULFURAS);
		assertCreatedWrappedItemIsInstanceOf(SulfurasItem.class);
	}
	
	private void assertCreatedWrappedItemIsInstanceOf(Class<?> clazz) {
		ItemWrapper result = underTest.getWrappedItem(item);
		assertThat(result, is(instanceOf(clazz)));
	}

	private void stubItemToReturnName(String name) {
		when(item.getName()).thenReturn(name);
	}
	
}
