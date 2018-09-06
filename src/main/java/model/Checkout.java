package model;

import dao.OrderDao;

public class Checkout {

	private Item item;
	
	private float salePrice;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice() {
		
		float itemCost = item.getTotalCost();
		float orderAverage = OrderDao.getOrder().getAverage();
		float profit = OrderDao.getOrder().getProfit();
		
		this.salePrice = profit == 0 ? itemCost + orderAverage : (itemCost + orderAverage) * (1 - profit / 100f);
	}
}
