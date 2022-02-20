package MP_1;

public class UsedParts {

	
	//atrybut
		private Service serv;
		private PartType part;
		private int quantity;
		
	public UsedParts(Service s,PartType p, int q) {
		super();
		this.serv =s;
		this.serv.addPartUsed(this);
		this.part = p;
		this.part.addActualService(this);
		this.quantity = q;
	}
		
		public void setService(Service s) {
			if(this.serv != null)
				s.deletePartUsed(this);
			this.serv = s;
			this.serv.addPartUsed(this);
		}
		
		public void setPart(PartType s) {
			if(this.part != null)
				s.deleteActualService(this);
			this.part = s;
			this.part.addActualService(this);
		}

		@Override
		public String toString() {
			return "UsedParts [serv=" + serv + ", part=" + part + ", quantity=" + quantity + "]";
		}
		
		
		
}
