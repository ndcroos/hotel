package ndcroos.buildocc;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import beans.Building;
import beans.Room;

/**
 * TODO: renaming
 * 
 *
 */
public class Foo {

	private Set<Building> buildings;
	
	private int totalAmountRoomsAvailable;
	
	public Foo(){
		this.totalAmountRoomsAvailable = 0;
		this.calculateTotalAmountRoomsAvailable();
	}
	
	public void amountRoomsAvailableInBuilding(Building building){
		
	}
	
	/**
	 * Given a set of conditions, returns a corresponding set of rooms.
	 * 
	 * @return a set of rooms, satisfying the given conditions.
	 */
	public Optional<Set<Room>> getRoomsSatisfyingConditions(){
		Set<Room> setRooms = new HashSet<>();
		
		
		
		return setRooms;
	}
	
	/**
	 * 
	 * @return
	 */
	private Set<Room> getAllRooms(){
		Set<Room> allRooms = new HashSet<>();
		buildings.forEach( 
			b -> {
				Set<Room> bRooms = b.getAllRooms();
				allRooms.addAll(bRooms);
			}
		);
		return allRooms;
	}
	
	private void calculateTotalAmountRoomsAvailable(){
		
		buildings.forEach( 
			b -> {
				int bAmountAvailable = b.amountAvailableRooms();
				this.totalAmountRoomsAvailable += bAmountAvailable;
			}
		);
	}
	
	private int getAmountTotalRoomsAvailable(){
		return this.totalAmountRoomsAvailable;
	}
	
	
}
