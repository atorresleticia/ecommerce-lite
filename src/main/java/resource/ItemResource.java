package resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ItemDao;
import dao.ProductDao;
import model.Item;

@Path("/item")
public class ItemResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getItems(){
		return ItemDao.getItems();
	}
	
	@GET
	@Path("/{id}/{qty}")
	@Produces(MediaType.APPLICATION_JSON)
	public Item addItem(@PathParam("id") Long productId, @PathParam("qty") int quantity) {
		
		int productExists = ItemDao.productExists(productId);
		
		return productExists == -1 ? ItemDao.insert(new Item(ProductDao.getProductById(productId), quantity)) :
			ItemDao.updateQuantity(productExists, quantity);
	}
}
