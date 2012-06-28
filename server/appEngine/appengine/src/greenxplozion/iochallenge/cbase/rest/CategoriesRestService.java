package greenxplozion.iochallenge.cbase.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/categories")
public class CategoriesRestService {

	@GET
	@Produces("text/plain")
	public String getCategories(){
		
	}
}
