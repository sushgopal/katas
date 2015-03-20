
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
			item.setQuality(0);
		}
	}
	
	private boolean sellInLessThanSixDays() {
		return item.getSellIn() < 6;
	}

	private boolean sellInLessThanElevenDays() {
		return item.getSellIn() < 11;
	}

}
