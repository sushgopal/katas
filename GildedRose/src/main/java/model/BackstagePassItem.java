package model;


public class BackstagePassItem extends ItemWrapper {

	public BackstagePassItem(Item item) {
		super(item);
	}

	@Override
	public void update() {
		incrementQuantity();
		if (sellInLessThanElevenDays()) {
			incrementQuantity();
		}
		if (sellInLessThanSixDays()) {
			incrementQuantity();
		}
		decrementSellIn();
		if (pastSellInDate()) {
			setQuality(0);
		}
	}
	
	private boolean sellInLessThanSixDays() {
		return getSellIn() < 6;
	}

	private boolean sellInLessThanElevenDays() {
		return getSellIn() < 11;
	}

}
