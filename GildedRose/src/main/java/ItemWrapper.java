
public class ItemWrapper {

	Item item;
	
	public ItemWrapper(Item item) {
		this.item = item;
	}
	
	public void update() {
		decrementQuality();
		decrementSellIn();
		if (pastSellInDate()) {
			decrementQuality();
		}
	}

	boolean pastSellInDate() {
		return item.getSellIn() < 0;
	}

	void decrementSellIn() {
		item.setSellIn(item.getSellIn() - 1);
	}
	
	void decrementQuality() {
		if (item.getQuality() > 0) {
			item.setQuality(item.getQuality() - 1);
		}
	}
	
	void incrementQuantity() {
		if (item.getQuality() < 50) {
			item.setQuality(item.getQuality() + 1);
		}
	}

	public Item getItem() {
		return item;
	}	
	
}
