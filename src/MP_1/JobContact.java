package MP_1;

import java.text.SimpleDateFormat;

public class JobContact {




	public String doc; 
	private ServiceWorker sw = null;
	private SimpleDateFormat startDate;
	private SimpleDateFormat endDate;

	private float grossSalary;
	protected static float sklEmProc = 0.0976f; // atrybut klasowy
	protected static float sklRentProc = 0.015f; // atrybut klasowy
	protected static float sklChorProc = 0.0245f;// atrybut klasowy
	protected static float kosztUzPrzych = 250.0f;// atrybut klasowy
	protected static float miesUlga= 43.76f;// atrybut klasowy
	protected static float stawkaIProg= 0.17f;// atrybut klasowy
	
	public static float getStawkaIProg() {
		return stawkaIProg;
	}
	
	// atrybut pochodny
	public float getNetSalary() {
		return Netto(this.grossSalary);
	}


	
	public JobContact(SimpleDateFormat startDate,SimpleDateFormat endDate,float grossSalary ){
		this.startDate = startDate;
		this.endDate = endDate;
		this.grossSalary = grossSalary;

	}
	
	public JobContact(SimpleDateFormat startDate,float endDate ){

		
	}
	
	public float Netto(float grossSalary) {
		float mainRate =  (grossSalary - (grossSalary*sklEmProc) - (grossSalary*sklRentProc) - (grossSalary*sklChorProc));
	//	System.out.println(stawkaZasad);
		float income = Math.round(mainRate -kosztUzPrzych);
	//	System.out.println(dochod);
		float advance = income*stawkaIProg;
	//	System.out.println(zaliczka);
		float THIEF = (mainRate*0.09f);
	//	System.out.println(ZUS);
		float deduction = (mainRate*0.0775f);
	//	System.out.println(odliczenie);
		float tax = Math.round(advance - miesUlga - deduction);
		//System.out.println(PIT);
		return Math.round((mainRate - THIEF - tax)*100.0f)/100.0f;
		
		
		
	}

	@Override
	public String toString() {
		return doc + "\n UmowaOPrace [pensjaBrutto=" + grossSalary + "]";
	}

	public void setWorker(ServiceWorker serviceWorker) throws Exception {
	if(this.sw!= serviceWorker) {
	//	this.sw.deleteJobCon(doc);
		this.sw = serviceWorker;
		this.sw.addContract(this);
	}
	}
	
	

	
	
	
}
