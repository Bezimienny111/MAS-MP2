package MP_1;

import java.util.ArrayList;
import java.util.List;

public class Team {

	public String name;
	private List<ServiceWorker> workers = new ArrayList<>(); 
	
	
	public Team(String name) {
		this.name = name;
	}
	
	public void addWorker(ServiceWorker newWorker) throws Exception {
			if(!workers.contains(newWorker)){
			workers.add(newWorker);
		}
		newWorker.addteamQualif(this);
		
	}
		

	public void removerWorker(ServiceWorker serviceWorker) throws Exception {
		if(workers.contains(serviceWorker)) {
			workers.remove(serviceWorker);
            // Remove the reverse link
			serviceWorker.deleteFromTeam(this.name);
        }
		
	}

	
	public String toString() {
		if(!this.workers.isEmpty())
			return "Team: " +this.name  + " ;Personel : " + workers.toString();
		return "error";
	}
	
	
}
