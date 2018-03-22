package ndcroos.buildocc;

import java.util.HashSet;
import java.util.Set;

import beans.Building;
import beans.Room;

/**
 * TODO: renaming
 * 
 *
 */
public class Foo {

	Set<Building> buildings;
	
	public void amountRoomsAvailableInBuilding(Building building){
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<Room> getRoomsSatisfyingConditions(){
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
	
	private int getTotalAmountRoomsAvailable(){
		int totalAmount = 0;
		
		buildings.forEach( 
			b -> {
				int bAmountAvailable = b.amountAvailableRooms();
				totalAmount += bAmountAvailable;
			}
		);
		
		return totalAmount;
	}
	
}
