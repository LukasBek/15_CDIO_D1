package controllere;

import java.util.Scanner;

import funktionalitet.Funktionalitet;

public class ProgramController {

	private Scanner sc;
	private Funktionalitet f = new Funktionalitet();

	int valg;
	int ID;

	boolean operatørMenu = true;
	boolean sysAdminMenu = true;

	public ProgramController(Scanner sc) {
		this.sc=sc;
	}

	public void valg(int valg){
		this.valg = valg;

		//Operatør login
		if (valg == 1){
			System.out.println("Indtast ID: ");
			ID = sc.nextInt();
			System.out.println("Indtast Adgangskode: ");
			String kode = sc.next();
			if(f.tjekLogin(ID, kode, 1)){
				operatørMenu(ID);
			}else{

			}


		} else if (valg == 2){
			String kode;
			System.out.println("Indtast ID: ");
			ID = sc.nextInt();
			
			System.out.println("Indtast Adgangskode: ");
			kode = sc.next();
			
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
		sysAdminMenu = true;
		System.out.println("Velkommen sysAdmin");
		System.out.println("----------------------------------------");

		while (sysAdminMenu){
			System.out.println("Tast 1 for at oprette en ny operatør");
			System.out.println("Tast 2 for at slette en operatør");
			System.out.println("Tast 3 for at ændre i en operatør");
			System.out.println("Tast 4 for at se en operatør");
			System.out.println("Tast 5 for at logge ud");
			valg = sc.nextInt();
			if (valg == 1){
				System.out.println("Indtast navn: ");
				String navn = sc.next();
				System.out.println("Indtast cpr-nummer: ");
				String cpr = sc.next();
				System.out.println("Er det en administrator? (tast 1 hvis nej, 2 hvis ja)");
				int admin = sc.nextInt();
				f.createOperatoer(navn, cpr, admin);
				System.out.println("En ny operator er nu blevet oprettet.");
			}
			else if (valg == 2){
				System.out.println("Indtast ID for den operatør du ønsker at slette"
						+ "(Advarsel - det er ikke muligt at få operatøren tilbage: ");
				ID = sc.nextInt();
				f.deleteOperatoer(ID);
				System.out.println("Operatør "+ID+" er nu blevet slettet!");
			}
			else if (valg == 3){
				//TODO implement this...
			}
			else if (valg == 4){
				System.out.println("Indtast ID for den operatør du ønsker at se: ");
				ID = sc.nextInt();
				f.showOperatoer(ID);
			}
			else if (valg == 5){
				sysAdminMenu = false;
			}else{
				System.out.println("Ugyldigt valg, prøv igen");
			}
		}
	}

	private void operatørMenu(int ID) {
		operatørMenu = true;
		System.out.println("Velkommen operatør");
		System.out.println("------------------------------------------");

		while (operatørMenu){
			System.out.println("Tast 1 for at bruge nettovægtberegneren");
			System.out.println("Tast 2 for at skifte adgangskode");
			System.out.println("Tast 3 for at logge ud");
			valg = sc.nextInt();

			if (valg == 1){
				System.out.println("Indtast tarravægt (kg): ");
				double tarra = sc.nextDouble();
				System.out.println("Indtast bruttovægt (kg): ");
				double brutto = sc.nextDouble();
				f.nettoVaegt(ID, brutto, tarra);
			}
			else if (valg == 2){
				System.out.println("Indtast din gamle adganskode: ");
				String kode = sc.next();
				if(f.tjekLogin(ID, kode, 1)){
					System.out.println("Indtast din ønskede adgangskode her: ");
					kode = sc.next();
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
