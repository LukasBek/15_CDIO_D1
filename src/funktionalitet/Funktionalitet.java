package funktionalitet;

import java.util.Arrays;

import data.Operatoer;
import data.Vaegt;

public class Funktionalitet implements IFunktionalitet {

	private Vaegt v;
	private Operatoer o;
	
	private int maalingsID = 1;

	public Funktionalitet(Operatoer o, Vaegt v) {
		this.o = o;
		this.v = v;
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

	@Override
	public double nettoVaegt(int iD, double brutto, double tarra) {
		
		double nettovaegt = brutto - tarra;
		v.addMaaling(maalingsID, nettovaegt, iD);
		maalingsID++;
		return nettovaegt;
	}
	
	@Override
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

	@Override
	public void createOperatoer(String oprNavn, String cpr, int admin) {		
		
		int oprId = 100;	
		String Adgangskode = "TankeYouComeAgain";		
		o.addOp(oprId, oprNavn, Adgangskode, cpr, admin);
	}

	@Override
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

	@Override
	public void showOperatoer(int iD) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void getMaalinger(){
		for (int i = 0; i < v.getVaegtArratLaengde(); i++){
			v.toString(i);
		}
	}
}
