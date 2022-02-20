package MP_1;

import java.util.ArrayList;
//------------------------------------
//--------Asocjacja z atrybutem-------
//-PartType 1 - * UsedParts * - 1 Service-
//------------------------------------
public class Service {
	
	private Device dev;

	 private ArrayList<UsedParts> used = new ArrayList<UsedParts>();
	
	
	public Service(Device dev) {
		super();
		this.dev = dev;
	}

	public void deletePartUsed(UsedParts parts) {
		used.remove(parts);
		
	}

	public void addPartUsed(UsedParts parts) {
		if(!used.contains(parts))
			used.add(parts);
		
	}

	@Override
	public String toString() {
		return "Service [dev=" + dev + "]";
	}
	
}
