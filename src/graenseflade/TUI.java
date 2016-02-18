package graenseflade;

import java.util.Scanner;

import funktionalitet.Funktion;

//textual user interface
public class TUI {
	
	private Funktion f;

	Scanner sc = new Scanner(System.in);
	public TUI(Funktion f){

		System.out.println(
				"---------------------------------------\n"
						+"Velkommen til nettovægts-beregneren\n"
						+"---------------------------------------\n"
						+"For operatør-login, tast 1 \n"
						+"For sysAdmin-login, tast 2");
		int valg = sc.nextInt();

		if (valg==1){
			f.operatoerLogin();
		}
		if (valg==2){
			f.sysAdminLogin();
			System.out.println("Venligst indtast dit ID herunder: ");
			String inID = sc.nextLine();
			System.out.println("Venligst indtast dit pass herunder");
			String inPass = sc.nextLine();
			
		}
	}

}
