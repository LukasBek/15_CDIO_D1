package funktionalitet;

import java.util.ArrayList;

import data.AdgangskodeData;

public class AdgangskodeMetoder {

	private AdgangskodeData AD = new AdgangskodeData();
	
	private ArrayList<String> karakterer = AD.getKarakterer();
	private boolean smaaBogstaver;
	private boolean storeBogstaver;
	private boolean tal;
	private boolean tegn;
	private int forskelige;

	/**
	 * 
	 * @param adgangskode Indsæt adgangskoden som skal kontrolleres
	 * @return true hvis den er på 6 tegn eller derover
	 */
	public boolean kontrolKodeLaengde(String adgangskode){
		if(adgangskode.length()<6){
//			System.out.print("Din adgangskode skal bestå af mindst 6 karakterer!");
			return false;
		}else if(adgangskode.length()>=6){
			return true;
		}else{
			System.out.println("Fejl i kontrolKodeLaengde");
			return false;
		}
		
	}
	
/**
 * 
 * @param adgangskode Indsæt adgangskoden som skal kontrolleres
 * @return true hvis den består...
 */
	public boolean kontrolKode(String adgangskode){

		AD.array();

		tal=false;
		tegn= false;
		smaaBogstaver=false;
		storeBogstaver=false;
		forskelige = 0;

			for(int j=0; j<=9; j++){
				if(adgangskode.contains(karakterer.get(j))){
					tal = true;
					forskelige++;
					break;
				}
			}
			for(int j=10; j<=35; j++){
				if(adgangskode.contains(karakterer.get(j))){
					smaaBogstaver = true;
					forskelige++;
					break;
				}
			}
			for(int j=36; j<=61; j++){
				if(adgangskode.contains(karakterer.get(j))){
					storeBogstaver = true;
					forskelige++;
					break;
				}
			}
			for(int j=62; j<=68; j++){
				if(adgangskode.contains(karakterer.get(j))){
					tegn = true;
					forskelige++;
					break;
				}
			}

				if(!tal||!smaaBogstaver||!storeBogstaver||!tegn){
					if(forskelige<3){
//					System.out.println("Din adgangskode skal indholde mindst 3 følgende: Tal, Specialtegn, Stort Bogstav, Lille Bogstav");
					return false;
					}
				}
		return true;
	}


	public boolean ensKode(String kode, String kodex) {
		
		if(kode == kodex) return true;
		else if (kode != kodex){
//			System.out.println("Kodeordene er ikke ens!");
		}
		return false;
		

		
		
	}
}