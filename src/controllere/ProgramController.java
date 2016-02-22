package controllere;

import java.util.Scanner;

import funktionalitet.Funktionalitet;

public class ProgramController {

	private Scanner sc;
	private Funktionalitet f;

	int valg;
	int ID;

	boolean operatørMenu = true;
	boolean sysAdminMenu = true;

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
			System.out.println("Du skal vælge enten 1 eller 2: ");
			int nytValg = sc.nextInt();
			valg(nytValg);
		}
	}

	private void sysAdminMenu() {

		System.out.println("Velkommen sysAdmin");
		System.out.println("----------------------------------------");

		while (operatørMenu){
			System.out.println("Tast 1 for at oprette en ny operatør");
			System.out.println("Tast 2 for at slette en operatør");
			System.out.println("Tast 3 for at ændre i en operatør");
			System.out.println("Tast 4 for at se en operatør");
			System.out.println("Tast 5 for at logge ud");
			valg = sc.nextInt();
			if (valg == 1){
				System.out.println("Indtast navn: ");
				String navn = sc.nextLine();
				System.out.println("Indtast navn: ");
				String cpr = sc.nextLine();
				int admin = sc.nextInt();
				f.createOperatoer(navn, cpr, admin);
				
			}
			else if (valg == 2){
				f.deleteOperatoer(ID);
			}
			else if (valg == 3){
				
			}
			else if (valg == 4){
				f.showOperatoer(ID);
			}
			else if (valg == 5){

			}else{
				System.out.println("Ugyldigt valg, prøv igen");
			}
		}
	}

	private void operatørMenu(int ID) {

		System.out.println("Velkommen operatør");
		System.out.println("------------------------------------------");

		while (operatørMenu){
			System.out.println("Tast 1 for at bruge nettovægtberegneren");
			System.out.println("Tast 2 for at skifte adgangskode");
			System.out.println("Tast 3 for at logge ud");
			valg = sc.nextInt();

			if (valg == 1){
				f.nettoVægt(ID);
			}
			else if (valg == 2){
				System.out.println("Indtast din gamle adganskode: ");
				String kode = sc.nextLine();
				if(f.tjekLogin(ID, kode, 1)){
					System.out.println("Indtast din ønskede adgangskode her: ");
					kode = sc.nextLine();
					f.setKode(ID, kode);	
				}else{
					System.out.println("Forkert adganskode");	
				}
			}
			else if (valg == 3){
				operatørMenu = false;
			}
			else{
				System.out.println("Ugyldigt valg, prøv igen");
			}
		}
	}
}
