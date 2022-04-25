package wsrest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/wscalculo")
public class WSCalculo {
	
	@GET
	@Path("/adicao/{valor1}/{valor2}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response adicao(@PathParam("valor1") double valor1, @PathParam("valor2") double valor2)  {
		double resultado = valor1 + valor2;
		return Response
				.status(200)
				.entity(resultado)
				.build();
	}
	
	@GET
	@Path("/adicao2")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response adicao2(@QueryParam("valor1") double valor1,@QueryParam("valor2") double valor2) {
		double resultado = valor1 + valor2;
		return Response
				.status(200)
				.entity(resultado)
				.build();
	}

}
