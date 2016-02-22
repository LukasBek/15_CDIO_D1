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

	public void nettoVægt() {
		// TODO Auto-generated method stub
		
	}






	public void setKode(int iD, String kode) {
		// TODO Auto-generated method stub
		
	}









}
