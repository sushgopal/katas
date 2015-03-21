import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import model.Item;
import model.ItemWrapper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import factory.ItemWrapperFactory;

public class GildedRoseTest {
	
	@InjectMocks
	private GildedRose underTest;
	
	@Mock
	private Item item;
	
	@Mock
	private ItemWrapperFactory itemWrapperFactory;

	@Mock
	private ItemWrapper wrappedItem;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		when(itemWrapperFactory.getWrappedItem(item)).thenReturn(wrappedItem);
	}
	
	@Test
	public void shouldCreateWrappedItem() {
		underTest.updateQuality(item);
		verify(itemWrapperFactory).getWrappedItem(item);
	}
	
	@Test
	public void shouldCallUpdateOnWrappedItem() {
		underTest.updateQuality(item);
		verify(wrappedItem).update();
	}
}
