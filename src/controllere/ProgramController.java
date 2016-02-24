package controllere;

import java.util.Scanner;

import data.Operatoer;
import funktionalitet.AdgangskodeMetoder;
import funktionalitet.Funktionalitet;

public class ProgramController {

	private Scanner sc;
	private Funktionalitet f = new Funktionalitet();
	private AdgangskodeMetoder ak = new AdgangskodeMetoder();


	int valg;
	int ID;

	boolean operatoerMenu = true;
	boolean sysAdminMenu = true;

	public ProgramController(Scanner sc) {
		this.sc=sc;
	}

	public void valg(int valg){
		this.valg = valg;

		//Operatoer login
		if (valg == 1){
			System.out.println("Indtast ID: ");
			ID = sc.nextInt();
			System.out.println("Indtast Adgangskode: ");
			String kode = sc.next();
			if(f.tjekLogin(ID, kode, 1)){
				operatoerMenu(ID);
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
				System.out.println("Operatoer "+ID+" er nu blevet slettet!");
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

	private void operatoerMenu(int ID) {
		operatoerMenu = true;
		System.out.println("Velkommen operatør");
		System.out.println("------------------------------------------");

		while (operatoerMenu){
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
				String kodex;
				//				if(f.tjekLogin(ID, kode, 1)){
				//TODO få koden ind fra brugern fra funktionalitets laget.

				if(ak.korrektBrugerKode(ID, kode)){
					System.out.println("Indtast ny adgangskode her: ");
					do{
						kode = sc.next();
						if(!ak.kontrolKodeLaengde(kode)){
							System.out.print("Din adgangskode skal bestå af mindst 6 karakterer!");
						}
						if(!ak.kontrolKode(kode)){
							System.out.println("Din adgangskode skal indholde mindst 3 følgende: Tal, Specialtegn, Stort Bogstav, Lille Bogstav");
						}
					}while(!ak.kontrolKode(kode));
					System.out.println("Indtast ny adgangskode igen: ");
					kodex = sc.next();
					if(!ak.ensKode(kode, kodex)){
						System.out.println("Kodeordene er ikke ens!");
					}else if(ak.ensKode(kode, kodex)){
						f.setKode(ID, kode);
					}
				}else{
					System.out.println("Forkert adganskode");	
				}
			}
			else if (valg == 3){
				operatoerMenu = false;
			}
			else{
				System.out.println("Ugyldigt valg, proev igen");
			}
		}
	}
}
