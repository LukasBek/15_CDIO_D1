package controllere;

import java.util.Scanner;

import funktionalitet.Funktionalitet;

public class ProgramController {
	
	private Scanner sc;
	private Funktionalitet f;
	
	int valg;
	int ID;
	
	public ProgramController(Scanner sc, Funktionalitet f) {
		this.sc=sc;
		this.f=f;
	}

	public void valg(int valg){
		this.valg = valg;
		
		//Operatør login
		if (valg == 1){
			System.out.println("Indtast ID: ");
			ID = sc.nextInt();
			System.out.println("Indtast Adgangskode: ");
			String kode = sc.nextLine();
			if(f.tjekLogin(ID, kode, 1)){
				operatørMenu(ID);
			}else{
				
			}
		

		}
		if (valg == 2){
			System.out.println("Indtast ID: ");
			ID = sc.nextInt();
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
		
	}

	private void operatørMenu(int ID) {
		System.out.println("Velkommen operatør");
		System.out.println("------------------------------------------");
		System.out.println("Tast 1 for at bruge nettovægtberegneren"
				+ ""
				+ "Hvad sker der her");
		System.out.println("Tast 2 for at skifte adgangskode");
		System.out.println("Tast 3 for at logge ud");
		valg = sc.nextInt();
		
		if (valg == 1){
			f.nettoVægt();
		}
		if (valg == 2){
			System.out.println("Indtast din ønskede adgangskode her: ");
			String kode = sc.nextLine();
			f.setKode(ID, kode);
			operatørMenu(ID);
		}
	}
}
