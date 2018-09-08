package dao;

import model.Order;

public class OrderDao {

	private static Order order;
	
	public static Order createOrder(Order order) {
		OrderDao.order = order;
		return OrderDao.order;
	}
	
	public static Order getOrder() {
		return order;
	}
}
