package MP_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import com.badlogic.gdx.utils.Json;



public class Device {

	private Type deviceType = null; 
	private String serialNumber = null;
	private String brand = null; 
	private String model = null; 
	private Licence lic = null; // Atrybut złożony.
	


	private static ArrayList<Device> devices  = new ArrayList<Device>(); //ekstensja

	public Device() {
		
	};
	
	
	public Device(Type type, String serial, String brandIn, String model) {
		super();
		this.deviceType = type;
		this.serialNumber = serial;
		this.brand = brandIn;
		this.model = model;		
		addDevice(this);
	}

	public Device(Type type, String serial, String brandIn, String model, Licence lic) {
		super();
		this.deviceType = type;
		this.serialNumber = serial;
		this.brand = brandIn;
		this.model = model;
		this.lic = lic;
		addDevice(this);
	}
	
//	public String toString() {
//		if(lic == null)
//			return "Urządzenie : " + this.deviceType.toString().toLowerCase() + "; Nr Seryjny : " + this.serialNumber + "; Marka : " + this.brand+ "; Model: " +  this.model;
//		return "Device : " + this.deviceType.toString().toLowerCase() + "; Serial : " + this.serialNumber + "; Brand : " + this.brand+ "; Model: " +  this.model + " " +  this.lic;
//	}
	
	public static void addDevice(Device dev) {
		if(!(devices.contains(dev))) {
	
		devices.add(dev);
		}
	}
	
	public static void deleteDevice(Device urz) {
	devices.remove(urz);

}
	// matoda klasowa
	public static void printTyp(Type typ) { 
		if(!devices.isEmpty()) {
			int tmp = 0;
		for(Device urz : devices) {
			if (typ.equals(urz.deviceType)) {
				System.out.println(urz);
			++tmp;
			}
		}
		if (tmp ==0 )
			System.out.println("no device");
		}else
			System.out.println("list is empty");
	}
	
	
	public static ArrayList<Device> getDevices() {
		return devices;
	}
	public static void setDevices(ArrayList<Device> devi) {
		Device.devices = devi;
	}
	
	
	//trwałość - zapis i odczyt do pliku

	public static void SaveToFile() throws IOException {
		String path = "Data/file.json";
	
		Json json = new Json();
		FileOutputStream outputStream;
		
			outputStream = new FileOutputStream(path);
		
	    byte[] strToBytes = json.prettyPrint(devices).getBytes();
	    outputStream.write(strToBytes);
	    outputStream.flush();
	    outputStream.close();
		
	}

	public static void LoadFromFile() throws IOException {
		String path = "Data/file.json";
	
		BufferedReader br = new BufferedReader(new FileReader(path));
	    StringBuilder sb = new StringBuilder();
	    String line = br.readLine();

	    while (line != null) {
	        sb.append(line);
	        sb.append(System.lineSeparator());
	        line = br.readLine();
	    }
	    String everything = sb.toString();
	//System.out.println(everything);
	    br.close();
		Json json = new Json();
		//json.setIgnoreUnknownFields(true);
		
		devices = json.fromJson(ArrayList.class, everything);
		//System.out.println(wordList[0]);
	
		
		
	}
	
	//-----------------------------------------------
	//-------------------Binarna -----------------
	//--------------Device*-1 Client------------
	//-----------------------------------------------
	private Client owner = null;
	
	
	public Client getOwner() {
		return this.owner;
	}
	public void setOwner(Client cl) {
		if(this.owner == null) {
		this.owner = cl;	
		cl.addDevice(this);
		//System.out.println("Owner set in device");
		}
	}
	public void removeOwner(Client cl) {
		System.out.println(cl.toString());
		System.out.println(this.owner);
		if(this.owner ==  cl) {
		this.owner = null;	
		cl.removeDevice(this);
		}
	}
	
	public String toString() {
		String own = "no owner";
		String acc = "non";
		if(this.owner != null)
		own = this.owner.toString();
		if(!this.accesories.isEmpty()) {
			StringBuilder tmpacc = new StringBuilder();
			
			for(Accessories a: accesories) {
				tmpacc.append(a.toString());
				tmpacc.append(";;");
			}
			acc = tmpacc.toString();
		}
		if(lic == null)
			return "Owner:" + own + " Device : " + this.deviceType.toString().toLowerCase() + "; Serial : " + this.serialNumber + "; Brand : " + this.brand+ "; Model: " +  this.model + " Akcesoria" + acc;
		return "Owner:" + own + " Device : " + this.deviceType.toString().toLowerCase() + "; Serial : " + this.serialNumber + "; Brand : " + this.brand+ "; Model: " +  this.model + " " +  this.lic+ " Akcesoria" + acc;
	}
	
	
	
	
	//-----------------------------------------------
	//-------------------Kompozycja -----------------
	//--------------Accessories*-1 Device------------
	//-----------------------------------------------
	private ArrayList<Accessories> accesories = new ArrayList<Accessories>();
	
	

	
	public Accessories addAccessorieToDevice(String name,boolean toRep) {
		Accessories acc = new Accessories(name,toRep);
		if(!accesories.contains(acc))	
		accesories.add(acc);
		return acc;
	
	}
	
	public void deleteAccessorieFromDevice(Accessories acc){
		if(accesories.contains(acc))
			accesories.remove(acc);
	}
	
	
	public class Accessories{
		private String acessorieName;
		private boolean toRepairs = false;
		
		public Device getDevice() {
			return Device.this;
		}
		
		
		private Accessories(String name,boolean rep) {
			this.acessorieName = name;
			this.toRepairs = rep;
		}
		
		
		
		public String toString() {
				 if (toRepairs)
		            return " Accessorie: " + acessorieName + ": sprawne";
				 return " Accessorie: " + acessorieName + ": do naprawy";
		        }
			
			
		}
		
		
		
	}
	
	

