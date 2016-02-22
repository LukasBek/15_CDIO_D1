package data;

import java.util.ArrayList;

public class Operator {

ArrayList<op> opArray = new ArrayList<op>();
	
	public void addOp(int oprId, String oprNavn, String ini, String cpr, int admin, String Adgangskode){
		
		opArray.add(new op(oprId, oprNavn, ini, cpr, admin, Adgangskode));

	}
	
	/**
	 * Soetter id'et på et operator objekt
	 * @param index : Placeringen i Array Listen metoden bliver kørt
	 * @param oprId Den id man vil bruge
	 */
	public void setOprId(int index, int oprId){
		(opArray.get(index)).setOprId(oprId);
	}
	
	/**
	 * @param index : the place in the array list the method will be called
	 * @return The ID of the operator
	 */
	public int getOprId(int index){
		return (opArray.get(index)).getOprId();
	}
	
	/**
	 * @param index : the place in the array list the method will be called
	 * @return The Name of the operator
	 */
	public String getOprNavn(int index){
		return (opArray.get(index)).getOprNavn();
	}
	
	/**
	 * Soetter navnet på et operator objekt
	 * @param index : Placeringen i Array Listen metoden bliver kørt
	 * @param oprNavn Navnet der skal bruges
	 */
	public void setOprNavn(int index, String oprNavn) {
		(opArray.get(index)).setOprNavn(oprNavn);
	}
	
	/**
	 * @param index : the place in the array list the method will be called
	 * @return The Ini (?) of the operator
	 */
	public String getIni(int index){
		return (opArray.get(index)).getIni();
	}
	
	/**
	 * Soetter ini på et givent operator objekt
	 * @param index  : Placeringen i Array Listen metoden bliver kørt
	 * @param ini : ini
	 */
	public void setIni(int index, String ini){
		(opArray.get(index)).setIni(ini);
	}
	
	/**
	 * @param index : the place in the array list the method will be called
	 * @return The CPR.nr of the operator
	 */
	public String getCpr(int index){
		return (opArray.get(index)).getCpr();
	}
	
	/**
	 * @param index : the place in the array list the method will be called
	 * @return The Password of the operator
	 */
	public String getAdgangskode(int index){	
		return (opArray.get(index)).getAdgangskode();
	}
	
	/**
	 * Soetter adgangskoden på et operator objekt
	 * @param index : Placeringen i Array Listen metoden bliver kørt
	 * @param adgangskode Adgangskoden man vil bruge
	 */
	public void setAdgangskode(int index, String adgangskode){
		(opArray.get(index)).setAdgangskode(adgangskode);;
	}
	
	/**
	 * For at få admin status af det enkelte operatør objekt
	 * @param index : Placeringen i Array Listen metoden bliver kørt
	 * @return Adminstatus
	 */
	public int getAdminStatus(int index){
		return (opArray.get(index)).getAdmin();
		
	}
	
	/**
	 * For at få mængden af operatør objekter der er i arraylisten
	 * @return Størrelsen på Arraylisten
	 */
	public int getOperatoerArrayLoengde(){
		return opArray.size();
		
	}

	
	private class op{
		
		private int oprId;
		private int admin;
		private String oprNavn;
		private String ini;
		private String cpr;
		private String Adgangskode;
		
		public op(int oprId, String oprNavn, String ini, String cpr, int admin, String Adgangskode){
		
			this.cpr = cpr;
			this.ini = ini;
			this.oprNavn = oprNavn;
			this.oprId = oprId;
			this.Adgangskode = Adgangskode;
			this.admin = admin;
		}
		
		public int getOprId() {
			return oprId;
		}
		public void setOprId(int oprId) {
			this.oprId = oprId;
		}
		public String getOprNavn() {
			return oprNavn;
		}
		public void setOprNavn(String oprNavn) {
			this.oprNavn = oprNavn;
		}
		public String getIni() {
			return ini;
		}
		public void setIni(String ini) {
			this.ini = ini;
		}
		public String getCpr() {
			return cpr;
		}
		public String getAdgangskode() {
			return Adgangskode;	
		}
		public void setAdgangskode(String adgangskode){
			this.Adgangskode = adgangskode;
		}
		public int getAdmin(){
			return admin;
		}
	}
}
