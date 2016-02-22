package controllere;

import java.util.Scanner;

import funktionalitet.Funktionalitet;

public class ProgramController {
	
	private Scanner sc;
	private Funktionalitet f;
	
	int valg;
	
	public ProgramController(Scanner sc, Funktionalitet f) {
		this.sc=sc;
		this.f=f;
	}

	public void valg(int valg){
		this.valg = valg;
		
		//Operatør login
		if (valg == 1){
			System.out.println("Indtast ID: ");
			int ID = sc.nextInt();
			System.out.println("Indtast Adgangskode: ");
			String kode = sc.nextLine();
			if(f.tjekLogin(ID, kode, 1)){
				operatørMenu();
			}else{
				
			}
		

		}
		if (valg == 2){
			System.out.println("Indtast ID: ");
			int ID = sc.nextInt();
			System.out.println("Indtast Adgangskode: ");
			String kode = sc.nextLine();
			if(f.tjekLogin(ID, kode, 2)){
				sysAdminMenu();
			}
		}
		else{
			System.out.println("Du skal vælge noget mellem 1 og 2: ");
			int nytValg = sc.nextInt();
			valg(nytValg);
		}
	}

	private void sysAdminMenu() {
		System.out.println("Velkommen operatør")
		
	}

	private void operatørMenu() {
		// TODO Auto-generated method stub
		
	}
}
