package greenxplozion.iochallenge.cbase.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/challenges/{category}")
public class ChallengesRestService {

	@GET
	@Produces("text/plain")
	public String getChallengesByCategory(){
		return null;
	}
}
