package controllere;

import java.util.Scanner;
import java.util.Arrays;
import data.Operatoer;
import funktionalitet.AdgangskodeMetoder;
import funktionalitet.FException;
import funktionalitet.Funktionalitet;

public class ProgramController {

	private Scanner sc;
	private Operatoer o = new Operatoer();
	private Funktionalitet f = new Funktionalitet(o);
	private AdgangskodeMetoder ak = new AdgangskodeMetoder(o);

	int valg;
	int ID;
	String input;

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
			input = sc.next();

			ID = Integer.parseInt(input);


			System.out.println("Indtast Adgangskode: ");
			String kode = sc.next();
			if(f.tjekLogin(ID, kode, 1)){
				operatoerMenu(ID);
			}
			else{
				System.out.println("Forkert login");
			}
			


			//sysAdminLogin
		} else if (valg == 2){

			String kode;
			System.out.println("Indtast ID: ");
			input = sc.next();
			ID = Integer.parseInt(input);

			System.out.println("Indtast Adgangskode: ");
			kode = sc.next();

			if(f.tjekLogin(ID, kode, 2)){
				sysAdminMenu();
			}else{
				System.out.println("Forkert login");
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
			System.out.println("Tast 5 for at se målinger lavet, med nettovægtsberegneren");
			System.out.println("Tast 6 for at logge ud");
			valg = sc.nextInt();

			if (valg == 1){
				String navn;
				do{
					System.out.println("Indtast navn: ");
					navn = sc.next();
				} while (navn.length() >= 2 && navn.length() <= 20);
				System.out.println("Indtast cpr-nummer: ");
				String cpr = sc.next();
				System.out.println("Er det en administrator? (tast 1 hvis nej, 2 hvis ja)");
				int admin = sc.nextInt();
				try {
					f.createOperatoer(navn, cpr, admin);
				} catch (FException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("En ny operator er nu blevet oprettet.");
			}

			else if (valg == 2){
				System.out.println("Indtast ID for den operatør du ønsker at slette"
						+ "(Advarsel - det er ikke muligt at få operatøren tilbage: ");
				ID = sc.nextInt();
				try {
					f.deleteOperatoer(ID);
				} catch (FException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Operatoer "+ID+" er nu blevet slettet!");
			}

			else if (valg == 3){
				System.out.println("Tast 1 for at ændre navn på en operatør");
				System.out.println("Tast 2 for at ændre cpr-nummer på en operatør");
				System.out.println("Tast 3 for at ændre i adgangskoden på en operatør");
				int m3Valg = sc.nextInt();
				String m3ValgString;

				if(m3Valg == 1){
					System.out.println("Intast operatørens ID");
					m3Valg = sc.nextInt();
					do{
						System.out.println("Intast nyt navn til operatør");
						m3ValgString = sc.next();
					} while (m3ValgString.length() >= 2 && m3ValgString.length() <= 20);
					try {
						f.updateOperatoer(m3Valg, 1, m3ValgString);
					} catch (FException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Operatørens navn er nu ændret");
				} 

				else if (m3Valg == 2){
					System.out.println("Intast operatørens ID");
					m3Valg = sc.nextInt();
					System.out.println("Intast ny cpr-nummer til operatør");
					m3ValgString = sc.next();
					try {
						f.updateOperatoer(m3Valg, 2, m3ValgString);
					} catch (FException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Operatørens cpr-nummer er nu ændret");
				} 

				else if (m3Valg == 3){
					System.out.println("Intast operatørens ID");
					m3Valg = sc.nextInt();
					System.out.println("Intast ny adgangskode til operatør");
					m3ValgString = ak.kontrollerKode(m3Valg, sc);
					try {
						f.updateOperatoer(m3Valg, 3, m3ValgString);
					} catch (FException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Operatørens navn er nu ændret");
				}
			}

			else if (valg == 4){
				System.out.println("Indtast ID for den operatør du ønsker at se: ");
				ID = sc.nextInt();
				try {
					System.out.println(Arrays.toString(f.getOperatoer(ID)));
				} catch (FException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			else if (valg == 5){
				f.showMaalinger();
			}

			else if (valg == 6){
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
				double netto = f.nettoVaegt(ID, brutto, tarra);
				System.out.println("Nettovægt: "+ netto);
			}

			else if (valg == 2){
				System.out.println("Indtast din gamle adganskode: ");

				String kode = sc.next();
				String kodex;

				if(ak.korrektBrugerKode(ID, kode)){
					System.out.println("Indtast ny adgangskode her: ");
					kode = ak.kontrollerKode(ID, sc);
					System.out.println("Indtast ny adgangskode igen: ");
					kodex = sc.next();
					if(!ak.ensKode(kode, kodex)){
						System.out.println("Kodeordene er ikke ens!");
					}

					else if(ak.ensKode(kode, kodex)){
						f.setKode(ID, kode);
					}
				}else{
					System.out.println("Forkert adganskode!");	
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
