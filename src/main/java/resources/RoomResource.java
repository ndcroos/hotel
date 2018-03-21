package resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@Path("rooms")
public interface RoomResource {
	
	@POST
	@Consumes("application/xml")
	public Response createRoom(InputStream is);

	@GET
	@Path("{id}")
	@Produces("application/xml")
	public StreamingOutput getRoom(@PathParam("id") int id);

	@PUT
	@Path("{id}")
	@Consumes("application/xml")
	public void updateRoom(@PathParam("id") int id, InputStream is);

}