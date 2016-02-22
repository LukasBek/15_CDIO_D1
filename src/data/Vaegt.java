package data;

import java.util.ArrayList;

public class Vaegt {
	
ArrayList<v> vArray = new ArrayList<v>();
	
	public void addMaaling(double vaegt, int Id){
		
		vArray.add(new v(vaegt, Id));

	}
	
	/**
	 * Returnere en vaegt på et et givent sted i arrayet
	 * @param index : Placeringen i Array Listen metoden bliver kaldt
	 * @return Vaegten af maalingen
	 */
	public double getVaegt(int index){
		return (vArray.get(index)).getVaerdi();
	}
	/**
	 * Returnere den Id der er lagt til maalingen
	 * @param index : Placeringen i Array Listen metoden bliver kaldt
	 * @return iD for maalingen
	 */
	public int getId(int index){
		return (vArray.get(index)).getId();
	}
	/**
	 * Finder laengden af arrayet
	 * @return en intiger med laengden af arrayet
	 */
	public int getVaegtArratLaengde(){
		return vArray.size();
	}
	/**
	 * Fjerner en maaling fra arrayet
	 * @param index : Placeringen i Array Listen metoden bliver kaldt
	 */
	public void fjernMaaling(int index){
		vArray.remove(index);
	}

	private class v{
		
		private double vaegt;
		private int Id;
		
		private v(double vaegt, int Id){
			
			this.vaegt = vaegt;
			this.Id = Id;
			
		}
		
		private double getVaerdi(){
			return vaegt;
		}
		private int getId(){
			return Id;
		}
	}
}