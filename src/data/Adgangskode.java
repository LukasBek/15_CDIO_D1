package data;

import java.util.ArrayList;

public class Adgangskode {

	private ArrayList<String> karakterer = new ArrayList<String>();
	
	private String adgangskode = "";
	private boolean smaaBogstaver;
	private boolean storeBogstaver;
	private boolean tal;
	private boolean tegn;
	private int tilf;
	private int forskelige;
	
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
	//smaa bogstaver ved index 		10-35
	//store bogstaver ved index 	36-61
	//tegn ved index 				62-68


	/**
	 * 
	 * @return Genererer et tilfaeldigt kodeord med DTU's krav for et kodeord.
	 * @param Indsaet hvor langt du oensker kodeordet skal vaere
	 * 
	 */
	public String getNyKode(int kodeLaengde){

		tal=false;
		tegn= false;
		smaaBogstaver=false;
		storeBogstaver=false;
		forskelige=0;

		//Opretter arrayet
		array();

		while(adgangskode.length()<kodeLaengde){
			//2. (se 1. laengere nede) Naar de alle er blacklisted, bliver de alle whitelisted igen.
			if(smaaBogstaver && storeBogstaver && tal && tegn||forskelige>=3){
				smaaBogstaver=false;
				storeBogstaver=false;
				tal=false;
				tegn=false;
			}
			//Generer et tilfaeldigt tal som bruges til arrayet.
			tilf = (int) (Math.random()*69);

			//Indsaetter vaerdien i koden hvis den er whitelisted.
			if(tilf<=9&&!tal){
				adgangskode = adgangskode + karakterer.get(tilf);
				forskelige++;
			}
			if(tilf>=10 && tilf<=35&&!smaaBogstaver){
				adgangskode = adgangskode + karakterer.get(tilf);
				forskelige++;
			}
			if(tilf>=36 && tilf<=61&&!storeBogstaver){
				adgangskode = adgangskode + karakterer.get(tilf);
				forskelige++;
			}
			if(tilf>=62 && tilf<=68&&!tegn){
				adgangskode = adgangskode + karakterer.get(tilf);
				forskelige++;
			}

			//1. For at der er 1 af hver 4 mulige tegn bliver de blacklisted her 1 af gangen.
			if(tilf<=9)tal=true;
			if(tilf>=10 && tilf<=35)smaaBogstaver=true;
			if(tilf>=36 && tilf<=61)storeBogstaver=true;
			if(tilf>=62 && tilf<=68)tegn=true;


		}

		return adgangskode;
	}

	public boolean kontrolKode(String adgangskode){

		array();

		tal=false;
		tegn= false;
		smaaBogstaver=false;
		storeBogstaver=false;
		forskelige = 0;

		if(adgangskode.length()<6){
			System.out.print("Din adgangskode skal bestaa af mindst 6 karakterer!");
			return false;
		}else{
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
					System.out.println("Din adgangskode skal indholde mindst 3 følgende: Tal, Specialtegn, Stort Bogstav, Lille Bogstav");
					return false;
					}
				}
		}
		return true;
	}
}
