package greenxplozion.iochallenge.cbase.rest;

import greenxplozion.iochallenge.cbase.rest.resources.CategoriesGateway;
import greenxplozion.iochallenge.cbase.rest.resources.Category;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/categories")
public class CategoriesRestService {

	private CategoriesGateway gateway = new CategoriesGateway();
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getCategories() {
		return gateway.fetchAll();
	}
}
