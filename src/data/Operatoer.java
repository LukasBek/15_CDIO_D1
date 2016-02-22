package data;

import java.util.ArrayList;

public class Operatoer {

ArrayList<op> opArray = new ArrayList<op>();
	
	public void addOp(int oprId, String oprNavn, String adgangskode, String cpr, int admin){
		
		opArray.add(new op(oprId, oprNavn, adgangskode, cpr, admin));

	}
	
	/**
	 * Soetter id'et paa et operator objekt
	 * @param index : Placeringen i Array Listen metoden bliver kaldt
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
	 * Soetter navnet paa et operator objekt
	 * @param index : Placeringen i Array Listen metoden bliver kaldt
	 * @param oprNavn Navnet der skal bruges
	 */
	public void setOprNavn(int index, String oprNavn) {
		(opArray.get(index)).setOprNavn(oprNavn);
	}
	
	/**
	 * @param index : the place in the array list the method will be called
	 * @return The Ini (?) of the operator
	 */
	public String getAdgangskode(int index){
		return (opArray.get(index)).getIni();
	}
	
	/**
	 * Soetter ini paa et givent operator objekt
	 * @param index  : Placeringen i Array Listen metoden bliver kaldt
	 * @param ini : ini
	 */
	public void setAdgangskode(int index, String ini){
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
	 * For at faa admin status af det enkelte operatoer objekt
	 * @param index : Placeringen i Array Listen metoden bliver kaldt
	 * @return Adminstatus
	 */
	public int getAdminStatus(int index){
		return (opArray.get(index)).getAdmin();
		
	}
	
	/**
	 * For at faa maengden af operatoer objekter der er i arraylisten
	 * @return Stoerrelsen paa Arraylisten
	 */
	public int getOperatoerArrayLaengde(){
		return opArray.size();
		
	}
	/**
	 * Fjerner en operatoer fra arraylisten
	 * @param index : Placeringen i Array Listen metoden bliver kaldt
	 */
	public void fjernOperatoer(int index){
		opArray.remove(index);
	}

	
	private class op{
		
		private int oprId;
		private int admin;
		private String oprNavn;
		private String ini;
		private String cpr;
		
		private op(int oprId, String oprNavn, String ini, String cpr, int admin){
		
			this.cpr = cpr;
			this.ini = ini;
			this.oprNavn = oprNavn;
			this.oprId = oprId;
			this.admin = admin;
		}
		
		private int getOprId() {
			return oprId;
		}
		private void setOprId(int oprId) {
			this.oprId = oprId;
		}
		private String getOprNavn() {
			return oprNavn;
		}
		private void setOprNavn(String oprNavn) {
			this.oprNavn = oprNavn;
		}
		private String getIni() {
			return ini;
		}
		private void setIni(String ini) {
			this.ini = ini;
		}
		private String getCpr() {
			return cpr;
		}
		private int getAdmin(){
			return admin;
		}
	}
}
