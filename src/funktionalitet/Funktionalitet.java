package funktionalitet;

import data.OP_Data;

public class Funktionalitet implements IFunktionalitet {

	private OP_Data oD;

	public Funktionalitet(OP_Data OP_Data) {

		this.oD = OP_Data;

	}






	@Override
	public boolean tjekLogin(int ID, String pass, int admin) {
		int opID = ID;
		int adminCheck = admin;
		String adgangskode = pass;
		int OperatørAntal = oD.getOperatoerArrayLaengde()-1;
		for(int i = 0; i < OperatørAntal; i++){
			if (opID == oD.getOprId(i)){
				if(adgangskode == oD.getAdgangskode(i)){
					if(adminCheck == 2){
						if(oD.getAdminStatus(i) == 2){
							return true;
						}break;
					}return true;
				}else{
					
				}
			}
		}
		return false;
	}

	public void ThisDoStuff(int index){

		oD.getCpr(index);
		oD.getIni(index);
		oD.getOprNavn(index);
		oD.getAdgangskode(index);
		oD.getOprId(index);

	}






	public void nettoVægt() {
		// TODO Auto-generated method stub
		
	}






	public void setKode(int iD, String kode) {
		// TODO Auto-generated method stub
		
	}









}
