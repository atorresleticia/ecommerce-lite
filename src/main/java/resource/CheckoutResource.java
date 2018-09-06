package resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.OrderDao;
import model.Checkout;
import model.Item;

@Path("/order/checkout")
public class CheckoutResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Checkout> getCheckout() {
		
		List<Checkout> checkout = new ArrayList<Checkout>();
		
		List<Item> items = OrderDao.getOrder().getItems();
		
		for (int i = 0; i < items.size(); i++) {
			
			Checkout temp = new Checkout();
			temp.setItem(items.get(i));
			temp.setSalePrice();		
			
			checkout.add(temp);
			
		}
		
		return checkout;
		
	}
	
}
