package TEMPMAIN;

import java.util.ArrayList;

public class PassGen {

	private ArrayList<String> karakterer = new ArrayList<String>();
	private String password = "";
	private boolean smaaBogstaver;
	private boolean storeBogstaver;
	private boolean tal;
	private boolean tegn;
	private int tilf;

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
	//små bogstaver ved index 		10-35
	//store bogstaver ved index 	36-61
	//tegn ved index 				62-68

	public String passGen(){
		array();

		for(int i=0 ; password.length()<6 ; i++){
			//hvis alle er true bliver de alle false
			if(smaaBogstaver && storeBogstaver && tal && tegn){
				smaaBogstaver=false;
				storeBogstaver=false;
				tal=false;
				tegn=false;
			}
			tilf = (int) (Math.random()*69);
			if(tilf<=9&&!tal)							password = password + karakterer.get(tilf);
			if(tilf>=10 && tilf<=35&&!smaaBogstaver)	password = password + karakterer.get(tilf);
			if(tilf>=36 && tilf<=61&&!storeBogstaver)	password = password + karakterer.get(tilf);
			if(tilf>=62 && tilf<=68&&!tegn)				password = password + karakterer.get(tilf);

			if(tilf<=9)tal=true;
			if(tilf>=10 && tilf<=35)smaaBogstaver=true;
			if(tilf>=36 && tilf<=61)storeBogstaver=true;
			if(tilf>=62 && tilf<=68)tegn=true;
		}
		return password;
	}
}
