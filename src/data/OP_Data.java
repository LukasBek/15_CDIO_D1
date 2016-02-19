package data;

import java.util.ArrayList;

public class OP_Data {
	
	ArrayList<operatoer> opArray = new ArrayList<operatoer>();
	
	
	public void addOp(int oprId, String oprNavn, String ini, String cpr, boolean admin, String Adgangskode){
		
		opArray.add(new operatoer(oprId, oprNavn, ini, cpr, admin, Adgangskode));

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
	 * @return The Ini (?) of the operator
	 */
	public String getIni(int index){
		return (opArray.get(index)).getIni();
	}
	
	/**
	 * @param index : the place in the array list the method will be called
	 * @return The Name of the operator
	 */
	public String getOprNavn(int index){
		return (opArray.get(index)).getOprNavn();
	}	
	
	/**
	 * @param index : the place in the array list the method will be called
	 * @return The Password of the operator
	 */
	public String getAdgangskode(int index){	
		return (opArray.get(index)).getAdgangskode();
	}
	
	/**
	 * @param index : the place in the array list the method will be called
	 * @return The ID of the operator
	 */
	public int getOprId(int index){
		return (opArray.get(index)).getOprId();
	}
	
	
	

}
