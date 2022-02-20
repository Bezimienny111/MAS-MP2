package MP_1;

public class Licence {
		private String onWhat = null;
		private String key = null;
	
		public Licence() {
			
		}
		
		
		public Licence(String sOne,String sTwo) {
			this.onWhat = sOne;
			this.key = sTwo;
		}
		
		public String toString() {
			
			return ";Licencja na: " + this.onWhat + " Nr: " + this.key; 
		}
		
		public void edit(String naCo) {
			this.onWhat = naCo;
		}
		
		public void edit(String naCo, String klucz) {
			this.onWhat = naCo;
			this.key = klucz;
		}
		
}
