package funktionalitet;

import java.util.Arrays;

import data.Operatoer;
import data.Vaegt;

public class Funktionalitet implements IFunktionalitet {

	private Vaegt v = new Vaegt();
	private Operatoer o = new Operatoer();
	private Adgangskode ak = new Adgangskode();
	
	private int maalingsID = 1;
	private int oprId = 11;	

	public Funktionalitet() {

	}

	@Override
	public boolean tjekLogin(int ID, String pass, int admin) {
		int opID = ID;
		int adminCheck = admin;
		String adgangskode = pass;
		int OperatørAntal = o.getOperatoerArrayLaengde();
		
		for(int i = 0; i < OperatørAntal; i++){
			if (opID == o.getOprId(i)){
				if(adgangskode.equals(o.getAdgangskode(i))){
					if(adminCheck == 2){
						if(o.getAdminStatus(i) == 2){
							return true;
						}
					} else {
						return true;
					}
				}else{
					System.out.println("Kodeord ikke accepteret!");
				}
			}
		}
		System.out.println("Bruger ikke fundet");
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

		String Adgangskode = ak.getNyKode(6);		
		o.addOp(oprId, oprNavn, Adgangskode, cpr, admin);
		System.out.println(Adgangskode);
		oprId++;
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
	public void showMaalinger(){
		
		for (int i = 0; i < v.getVaegtArratLaengde(); i++){
			System.out.println(v.toString(i));
		}
	}
}
