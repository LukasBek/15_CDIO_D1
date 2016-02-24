package funktionalitet;


import data.AdgangskodeData;
import data.Operatoer;
import data.Vaegt;

public class Funktionalitet implements IFunktionalitet {

	private Vaegt v = new Vaegt();
	private AdgangskodeData ak = new AdgangskodeData();
	private Operatoer o;
	
	
	
	private int maalingsID = 1;
	private int oprId = 11;	

	public Funktionalitet(Operatoer o) {
		this.o = o;

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

		String Adgangskode = ak.getNyKode(6);		
		o.addOp(oprId, oprNavn, Adgangskode, cpr, admin);
		System.out.println("DEV NOTICE - den nye operatoers adganskode (copy paste): "+Adgangskode);
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
	public String[] getOperatoer(int iD) {
		for (int i = 0 ; i < o.getOperatoerArrayLaengde() ; i++){		
			if (iD == o.getOprId(i)){			
				iD = i;			
			}		
		}
		String[] opValues = new String[5];
		opValues[0] = Integer.toString(o.getOprId(iD));
		opValues[1] = o.getOprNavn(iD);
		opValues[2] = o.getCpr(iD);
		opValues[3] = o.getAdgangskode(iD);
		opValues[4] = Integer.toString(o.getAdminStatus(iD));
		return opValues;
	}

	@Override
	public void showMaalinger(){
		
		for (int i = 0; i < v.getVaegtArratLaengde(); i++){
			System.out.println(v.toString(i));
		}
	}
	
	
	@Override
	public void changeOperatoer(int iD, int choice, String value){
		for (int i = 0 ; i < o.getOperatoerArrayLaengde() ; i++){		
			if (iD == o.getOprId(i)){			
				iD = i;			
			}		
		}
		if (choice == 1){
			o.setOprNavn(iD, value);
		} else if (choice == 2){
			o.setCpr(iD, value);
		}else if (choice == 3){
			o.setAdgangskode(iD, value);
		}
	}

	@Override
	public void showMaalinger(int iD) {
		int index = -1;
		for (int i = 0 ; i < v.getVaegtArratLaengde() ; i++){
			if (iD == v.getId(index)){
				System.out.println(v.toString(index));	
			}	
		}	
	}
}
