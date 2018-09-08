package resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ProductDao;
import model.Product;

@Path("/product")
public class ProductResource {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts(){
		return ProductDao.getProducts();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("id") Long id) {
		return ProductDao.getProductById(id);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteProduct(@PathParam("id") Long id) {
		ProductDao.delete(id);
	}
}
