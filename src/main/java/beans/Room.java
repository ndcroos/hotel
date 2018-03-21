package beans;

public class Room {
	
	private int id;
	
	private int department;
	
	private boolean wifiAvailable;
	
	private boolean wheelchairAccessible;
	
	private boolean WindowToOutside;
	
	private boolean doorClosable;
	
	private boolean doucheAvailable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public boolean isWifiAvailable() {
		return wifiAvailable;
	}

	public void setWifiAvailable(boolean wifiAvailable) {
		this.wifiAvailable = wifiAvailable;
	}

	public boolean isWheelchairAccessible() {
		return wheelchairAccessible;
	}

	public void setWheelchairAccessible(boolean wheelchairAccessible) {
		this.wheelchairAccessible = wheelchairAccessible;
	}

	public boolean isWindowToOutside() {
		return WindowToOutside;
	}

	public void setWindowToOutside(boolean windowToOutside) {
		WindowToOutside = windowToOutside;
	}

	public boolean isDoorClosable() {
		return doorClosable;
	}

	public void setDoorClosable(boolean doorClosable) {
		this.doorClosable = doorClosable;
	}

	public boolean isDoucheAvailable() {
		return doucheAvailable;
	}

	public void setDoucheAvailable(boolean doucheAvailable) {
		this.doucheAvailable = doucheAvailable;
	}
	
	
	
}
