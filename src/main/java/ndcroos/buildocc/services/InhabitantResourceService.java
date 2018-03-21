package ndcroos.buildocc.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Inhabitant;
import resources.InhabitantResource;

public class InhabitantResourceService implements InhabitantResource {
	
	// Will store created inhabitant objects in memory.
	// ConcurrentHashMap because concurrent requests accessing the map.
	private Map<Integer, Inhabitant> inhabDB = new ConcurrentHashMap<Integer, Inhabitant>();
	private AtomicInteger idCounter = new AtomicInteger();
	
	
	public void updateInhabitant(int id, InputStream is)  {
		
		Inhabitant update = readInhabitant(is, Inhabitant.class);
		Inhabitant current = inhabDB.get(id);
		if (current == null)
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		current.setFirstName(update.getFirstName());
		current.setLastName(update.getLastName());
	}

	public Response createInhabitant(InputStream is) {
		Inhabitant inhab = readInhabitant(is, Inhabitant.class);
		inhab.setId(idCounter.incrementAndGet());
		inhabDB.put(inhab.getId(), inhab);
		System.out.println("Created inhabitant " + inhab.getId());
		return Response.created(URI.create("/inhabitants/" + inhab.getId())).build();
	}
	
	/**
	 * TODO
	 */
	public StreamingOutput getInhabitant(int id)  {
		final Inhabitant inhab = inhabDB.get(id);
		if (inhab == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return null;
		/*
		return new StreamingOutput() {
			public void write(OutputStream outputStream) throws IOException, WebApplicationException {
				outputInhabitant(outputStream, inhab);
			}
		};*/
	}
	
	
	protected <T> T readInhabitant(InputStream is, Class<? extends T> clazz){
		ObjectMapper mapper = new ObjectMapper();
		T objectInstance = null;
		try {
			objectInstance = mapper.readValue(is, clazz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectInstance;
	}
	

}