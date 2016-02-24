package graenseflade;

import java.util.InputMismatchException;
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
			
			try{
			lC.valg(sc.nextInt());
			}catch (NumberFormatException ne) {
				System.out.println("\tPlease enter a positive whole number.");
			}
		}
	}
}
