package beans;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Building {
	
	private String shortName;
	private int id;
	private Map<Integer, Room> rooms;
	
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Map<Integer, Room> getRooms() {
		return rooms;
	}
	public void setRooms(Map<Integer, Room> rooms) {
		this.rooms = rooms;
	}
	
	public void addRoom(Integer integer, Room room){
		this.rooms.put(integer, room);
	}
	
	
	/**
	 * 
	 * @return a set of all rooms in the building.
	 */
	public Set<Room> getAllRooms(){
		Set<Room> setRooms = new HashSet<Room>();
		for(Entry<Integer, Room> entry : this.rooms.entrySet()){
			Room entryRoom = entry.getValue();
			setRooms.add(entryRoom);
		}
		return setRooms;
	}
	
	/**
	 * 
	 * @return amount of available rooms in the building.
	 */
	public int amountAvailableRooms(){
		int amountAvailable = 0; 
		for(Entry<Integer, Room> entry : this.rooms.entrySet()){
			Room entryRoom = entry.getValue();
			if(entryRoom.isAvailable()){
				amountAvailable += 1;
			}
		}
		return amountAvailable;
	}
}
