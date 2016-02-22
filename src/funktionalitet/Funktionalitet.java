package funktionalitet;

import data.Operatoer;

public class Funktionalitet implements IFunktionalitet {

	private Operatoer o;

	public Funktionalitet(Operatoer o) {

		this.o = o;

	}






	@Override
	public boolean tjekLogin(int ID, String pass, int admin) {
		int opID = ID;
		int adminCheck = admin;
		String adgangskode = pass;
		int OperatørAntal = o.getOperatoerArrayLaengde()-1;
		for(int i = 0; i < OperatørAntal; i++){
			if (opID == o.getOprId(i)){
				if(adgangskode == o.getAdgangskode(i)){
					if(adminCheck == 2){
						if(o.getAdminStatus(i) == 2){
							return true;
						}break;
					}return true;
				}else{
					
				}
			}
		}
		return false;
	}

	public void nettoVægt(int iD) {
		// TODO Auto-generated method stub
		
	}






	public void setKode(int iD, String kode) {
		
		int index = -1;
		
		for (int i = 0 ; i < o.getOperatoerArrayLaengde() ; i++){
			
			if (iD == o.getOprId(i)){
				
				index = i;
				
			}
			
		}
		
		if (index != -1){
			
			o.setAdgangskode(index, kode);
			
		}
		
	}






	public void createOperatoer(String oprNavn, String cpr, int admin) {
		
		int oprId = 100;
	
		String Adgangskode = "TankeYouComeAgain";
		
		o.addOp(oprId, oprNavn, Adgangskode, cpr, admin);
	}






	public void deleteOperatoer(int iD) {
		
		int index = -1;
		
		for (int i = 0 ; i < o.getOperatoerArrayLaengde() ; i++){
			
			if (iD == o.getOprId(i)){
				
				index = i;
				
			}
			
		}
		
		if (index != -1){
			
			o.fjernOperatoer(index);
			
		}

	}






	public void showOperatoer(int iD) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	









}
