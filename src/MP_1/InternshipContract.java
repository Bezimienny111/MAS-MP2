package MP_1;

import java.text.SimpleDateFormat;

public class InternshipContract extends JobContact{

	public InternshipContract(SimpleDateFormat startDate, SimpleDateFormat endDate, float grossSalary) {
		super(startDate, endDate, grossSalary);
		//this.pensjaNetto = Netto(pensjaBruttoIn);
	
	}

	
	public float Netto(float grossSalary) {
		float mainRate =  (grossSalary - (grossSalary*super.sklEmProc) - (grossSalary*sklRentProc) - (grossSalary*sklChorProc));
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
		return (Math.round((mainRate - THIEF - tax)*100.0f)/100.0f)*0.8f;
		
		
		
	}
	
}
