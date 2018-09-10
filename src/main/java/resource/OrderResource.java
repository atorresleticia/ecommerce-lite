package resource;

import java.util.List;

import javax.sound.sampled.Line;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.ItemDao;
import dao.OrderDao;
import model.Item;
import model.Order;

@Path("/order")
public class OrderResource {

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Order getOrder() {
		return OrderDao.getOrder();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Order createOrder(@DefaultValue("400") @QueryParam("expenses") float expenses, 
			@DefaultValue("0") @QueryParam("profit") float profit) {

		Order order = new Order();
		
		order.setItems(ItemDao.getItems());
		

		List<Item> items = order.getItems();
		
		int totalProducts = 0;
		
		for (Item item : items) {
			totalProducts += item.getQuantity();			
		}
		
		System.out.println(totalProducts);
		
		order.setExpenses(expenses);
		order.setAverage(expenses / totalProducts);
		order.setProfit(profit);

		return OrderDao.createOrder(order);

	}
}
