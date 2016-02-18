package TEMPMAIN;

import java.util.ArrayList;

public class PassGen {

	private ArrayList<String> karakterer = new ArrayList<String>();
	private String password;
	
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
	
	public void passGen(){
		array();
		for(int i = 0 ; i < karakterer.size() ; i++)
		System.out.println(karakterer.get(i)+" at index: "+i);
	}
}
