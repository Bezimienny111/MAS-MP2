package MP_1;

import java.util.ArrayList;

public class Client {

	private String name;
	private String telNumber;
	
	private ArrayList<Device> devices;
	
	public Client(String name,String tel) {
		this.name = name;
		this.telNumber = tel;
		this.devices = new ArrayList<Device>();
	}
	
	
	public void addDevice(Device dev) {
		if(dev.getOwner()== null) {
		if(!devices.contains(dev)) {
			devices.add(dev);
			dev.setOwner(this);	
		//	System.out.println("Device added to owner");
		}
		}
	}
	
	public void removeDevices() {
		ArrayList<Device> tmpA = new ArrayList<Device>();
		for (Device d : devices) {
			tmpA.add(d);
		}
		for (Device d : tmpA) {	
				removeDevice(d);
			}
		
		
	}
	
	public void removeDevice(Device d) {
		System.out.println(d);
		if(devices.contains(d)) {
			
			devices.remove(d);
			d.removeOwner(this);
		}
	}
	
	public String getAllDevices() {
		StringBuilder ret = new StringBuilder();
		if(!this.devices.isEmpty()) {
		for(Device d: this.devices) {
			ret.append(d.toString());
			ret.append(System.lineSeparator());
	}
		return ret.toString();
	}
		return "No Devices";
	}
	public String toString() {
		return "Name: " + this.name + " Tel: " + this.telNumber;
		
	}
	
}
