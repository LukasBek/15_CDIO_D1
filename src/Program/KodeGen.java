package Program;

import java.util.ArrayList;

public class KodeGen {

	private ArrayList<String> karakterer = new ArrayList<String>();
	private String adgangskode = "";
	private boolean smaaBogstaver;
	private boolean storeBogstaver;
	private boolean tal;
	private boolean tegn;
	private int tilf;
	private int kodeLaengde;

	//Metoden opretter et array med alle de mulige cifre til det tilfaeldige password.
	public void array(){
		for (int i = 0; i<=9 ; i++){
			karakterer.add(Integer.toString(i));
		}
		for (char letter = 'a'; letter <= 'z'; letter++){
			karakterer.add(Character.toString(letter));
		}
		for (char letter = 'A'; letter <= 'Z'; letter++){
			karakterer.add(Character.toString(letter));
		}
		karakterer.add(".");
		karakterer.add("-");
		karakterer.add("_");
		karakterer.add("+");
		karakterer.add("!");
		karakterer.add("?");
		karakterer.add("=");
	}
	//tal starter ved index 		0-9
	//sm� bogstaver ved index 		10-35
	//store bogstaver ved index 	36-61
	//tegn ved index 				62-68

	public void kodeGen(int kodeL�ngde){
		//Opretter arrayet
		array();
		
		//Hvor langt skal adgangskode v�re? (krav paa min 6)
		kodeLaengde = kodeL�ngde;

		while(adgangskode.length()<kodeLaengde){
			//2. (se 1. l�ngere nede) Naar de alle er blacklisted, bliver de alle whitelisted igen.
			if(smaaBogstaver && storeBogstaver && tal && tegn){
				smaaBogstaver=false;
				storeBogstaver=false;
				tal=false;
				tegn=false;
			}
			//Generer et tilfaeldigt tal som bruges til arrayet.
			tilf = (int) (Math.random()*69);
			
			//Indsaetter v�rdien i koden hvis den er whitelisted.
			if(tilf<=9&&!tal)							adgangskode = adgangskode + karakterer.get(tilf);
			if(tilf>=10 && tilf<=35&&!smaaBogstaver)	adgangskode = adgangskode + karakterer.get(tilf);
			if(tilf>=36 && tilf<=61&&!storeBogstaver)	adgangskode = adgangskode + karakterer.get(tilf);
			if(tilf>=62 && tilf<=68&&!tegn)				adgangskode = adgangskode + karakterer.get(tilf);
			
			//1. For at der er 1 af hver 4 mulige tegn bliver de blacklisted her 1 af gangen.
			if(tilf<=9)tal=true;
			if(tilf>=10 && tilf<=35)smaaBogstaver=true;
			if(tilf>=36 && tilf<=61)storeBogstaver=true;
			if(tilf>=62 && tilf<=68)tegn=true;
		}
	}
	/**
	 * 
	 * @return Genererer et tilf�ldigt kodeord med DTU's krav for et kodeord.
	 * @param Indsaet hvor langt du �nsker kodeordet skal v�re
	 * 
	 */
	public String getTilfAdgangskode(int kodeLaengde){
		kodeGen(kodeLaengde);
		return adgangskode;
	}
}
