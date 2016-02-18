package graenseflade;

import java.util.Scanner;

import controllere.loginController;
import funktionalitet.Funktion;

//textual user interface
public class TUI {
	
	private Funktion f;
	
	Scanner sc = new Scanner(System.in);
	
	loginController lC = new loginController(sc, f);

	
	public TUI(Funktion f){

		System.out.println(
				"---------------------------------------\n"
						+"Velkommen til nettovægts-beregneren\n"
						+"---------------------------------------\n"
						+"For operatør-login, tast 1 \n"
						+"For sysAdmin-login, tast 2");
		int valg = sc.nextInt();

		lC.valg(valg);
	}

}
