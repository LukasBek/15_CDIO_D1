package controllere;

import java.util.Scanner;

import funktionalitet.Funktion;

public class loginController {
	
	private Scanner sc;
	private Funktion f;
	
	int valg;
	
	public loginController(Scanner sc, Funktion f) {
		this.sc=sc;
		this.f=f;
	}

	public void valg(int valg){
		this.valg = valg;
		
		if (valg == 1){
			System.out.println("Indtast ID: ");
			int ID = sc.nextInt();
			System.out.println("Indtast Password: ");
			String pass = sc.nextLine();
			f.tjekOPLogin(ID, pass);
			
			if()
		}
		if (valg == 2){
			
		}
		else{
			
		}
	}
}
