package MP_1;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//------------Binarna Klasy:
		// - Device od linijki 135
		// - Client
		
		//------------------------------------
		//--------Asocjacja z atrybutem-------
		//-PartType 1 - * UsedParts * - 1 Service-
		//------------------------------------
		
		
		// z kwalifikatorem
		//-----Worker 1 - * Teams
		
		
		//-----------------------------------------------
		//-------------------Kompozycja -----------------
		//--------------Accessories*-1 Device------------
		//Od linijki 179 w Device
		//-----------------------------------------------
		
		//Binarna utworzenie danych
		Client testTwo = new Client("Rob","22222");
		Client testOne = new Client("Rob","11111");
		Device u1 = new Device(Type.LAPTOP,"1","Dell","Lattidue");
		Device u2 = new Device(Type.LAPTOP,"5","Dell","Lattidue",new Licence("Windows","54214fae-dsafa"));
		testOne.addDevice(u1);
		testOne.addDevice(u2);
		testTwo.addDevice(u1);
		//Oba urządzenia przypisane do testOne ponieważ nie można przypisać tego samego do dwóch róznych klientów
		System.out.println("Binarna");
		System.out.println("Od Strony urządzeń:");
		System.out.println(u1);
		System.out.println(u2);
		System.out.println("Od Strony klientów:");
		System.out.println(testOne.getAllDevices());
		System.out.println(testTwo.getAllDevices());
		
		
		//Asocjacja z atrybutem
		System.out.println();
		System.out.println("Asocjacja z atrybutem");
		Device u3 = new Device(Type.PRINTER,"1","HP","DeskJet");
		Service s1 = new Service(u3);
		PartType part1 = new PartType("wałek");
		
		UsedParts usedP= new UsedParts(s1,part1,2);
		System.out.println("Użyte część szczegóły: " + usedP.toString());
		
		
		// z kwalifikatorem
		//-----Worker 1 - * Teams
		
		Team teamOne = new Team("Printers");
		Team teamTwo = new Team("PC");
		ServiceWorker sw1 = new ServiceWorker("Robert", "Kowalski"); 
		ServiceWorker sw2 = new ServiceWorker("Michał", "Michałowski");
		teamOne.addWorker(sw2);
		teamOne.addWorker(sw1);
		teamTwo.addWorker(sw2);
		System.out.println();
		System.out.println("Z kwalifikatorem:");
		System.out.println(teamTwo);
		System.out.println(teamOne);
		
		
		
		//-------------------Kompozycja -----------------
		//--------------Accessories*-1 Device------------
		System.out.println();
		System.out.println("Kompozycja:");
		Device d1 = new Device(Type.PC,"1","Asus","...");
		d1.addAccessorieToDevice("Mysz", false);
		d1.addAccessorieToDevice("Klawiatura", true);
		System.out.println(d1);
	}

}
