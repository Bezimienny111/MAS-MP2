package MP_1;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;



public class ServiceWorker {

	private String Name;
	private String surname;
	private JobContact contract = null; // opcjonalny 
	private LinkedHashSet<JobContact> contracts = new LinkedHashSet<JobContact>(); // atrybut powtarzalny
	
	// z kwalifikatorem Worker 1 - * Teams
	private Map<String, Team> teamQualif = new TreeMap<>();
	
	public void addteamQualif(Team newTeam) throws Exception {
        if(!teamQualif.containsKey(newTeam.name)) {
        	teamQualif.put(newTeam.name, newTeam);

        	newTeam.addWorker(this);
        }
    }
 
    public Team findTeam(String teamName) throws Exception {
        if(!teamQualif.containsKey(teamName)) {
            throw new Exception("Error there is no: " + teamName);
        }
 
        return teamQualif.get(teamName);
    }
	
	public void deleteFromTeam(String teamName) throws Exception {
		if(!teamQualif.containsKey(teamName))
			 throw new Exception("Error, there is no: " + teamName);
		teamQualif.get(teamName).removerWorker(this);
		teamQualif.remove(teamName);
		
	}
	
    
    
    
    
	public ServiceWorker(String nameIN, String surnameIn, JobContact contractIn) {
		super();
		Name = nameIN;
		surname = surnameIn;
		manageContract(contractIn);
	}

	
	public ServiceWorker(String nameIN, String surnameIn) {
		super();
		Name = nameIN;
		surname = surnameIn;
	}

	
	@Override
	public String toString() {
		if(contract == null)
			return "Serwisant [Imie=" + Name + ", Nazwisko=" + surname + "]";
		return "Serwisant [Imie=" + Name + ", Nazwisko=" + surname + ", Aktualna umowa=" + contract + ", Poprzednie umowy=" + contracts + "]" + " contract map" + teamQualif;
	}

	public void addContract(JobContact um) {
		this.contract = um;
	}
	
	
	
	public void manageContract(JobContact um) {
		
		contracts.add(um);
		//System.out.println(umowy);
		contract = (JobContact) contracts.toArray()[(contracts.toArray().length-1)];
	}


	
	
}
