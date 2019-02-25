package div.ws;

import java.awt.PageAttributes.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/test")
public class Test {

	@GET
	@Path("/hi")
	@Produces()
	public String sayHi()
	{
		return "hiii dvh good";
	}
}
