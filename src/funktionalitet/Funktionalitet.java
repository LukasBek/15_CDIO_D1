package funktionalitet;

import data.OP_Data;

public class Funktionalitet implements IFunktionalitet {

	private OP_Data OP_Data;
	
	public Funktionalitet(OP_Data OP_Data) {
		
		this.OP_Data = OP_Data;
	
	}
	
	

	
	
	
	@Override
	public boolean tjekOPLogin(int ID, String pass) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void ThisDoStuff(int index){
		
		OP_Data.getCpr(index);
		OP_Data.getIni(index);
		OP_Data.getOprNavn(index);
		OP_Data.getAdgangskode(index);
		OP_Data.getOprId(index);
		
	}
	

}
