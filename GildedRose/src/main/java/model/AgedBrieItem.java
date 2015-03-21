package model;


public class AgedBrieItem extends ItemWrapper {

	public AgedBrieItem(Item item) {
		super(item);
	}

	@Override
	public void update() {
		incrementQuantity();
		decrementSellIn();
		if(pastSellInDate()) {
			incrementQuantity();
		}
	}

}
