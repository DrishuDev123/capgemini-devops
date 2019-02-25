package div.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/st")
public class SecondTicketInfo {

	@Path("/insert/{ticket_type}/{date_}/{time_}/{name}/{location}/{price}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	
	public String recieveTicketInfo(@PathParam("ticket_type") String ttype,
		   	@PathParam("date_") String date,
			  @PathParam("time_") String time,
	          @PathParam("name") String name,
              @PathParam("location") String location,
              @PathParam("price") String price)
	         
	{
		if(ttype!=null && date!=null && time !=null && name!=null && location !=null && price!=null)
		{
		System.out.println(ttype+"\t" +date+"\t" +time+"\t"+location+"\t" +price     );
		return "success";
		}
		else {
		return "success";
		}
	}
	
}
