package model;


public class ItemWrapper {

	private final Item item;
	
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
	
	public int getQuality() {
		return item.getQuality();
	}	
	
	public void setQuality(int quality) {
		item.setQuality(quality);
	}
	
	public int getSellIn() {
		return item.getSellIn();
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
	
}
