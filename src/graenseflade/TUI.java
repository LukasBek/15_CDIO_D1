package graenseflade;

import java.util.Scanner;

import controllere.ProgramController;
import funktionalitet.Funktionalitet;

//textual user interface
public class TUI {

	private Funktionalitet f;

	Scanner sc = new Scanner(System.in);

	ProgramController lC = new ProgramController(sc);

	public TUI(){

		while (true){
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

}
