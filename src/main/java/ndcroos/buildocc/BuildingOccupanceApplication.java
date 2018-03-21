package ndcroos.buildocc;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ndcroos.buildocc.services.InhabitantResourceService;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Nick Decroos
 *
 */
@ApplicationPath("/services")
public class BuildingOccupanceApplication extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public BuildingOccupanceApplication() {
		singletons.add(new InhabitantResourceService());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}