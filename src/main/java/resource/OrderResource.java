package resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.ItemDao;
import dao.OrderDao;
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
		order.setExpenses(expenses);
		order.setAverage(expenses / order.getItems().size());
		order.setProfit(profit);

		return OrderDao.createOrder(order);

	}
}
