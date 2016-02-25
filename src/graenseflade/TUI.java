package graenseflade;

import java.util.InputMismatchException;
import java.util.Scanner;

import controllere.ProgramController;

//textual user interface
public class TUI {

	ProgramController lC = new ProgramController(this);

	public void hovedMenu(){
		
		while (true){
			Scanner sc = new Scanner(System.in);
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
			}catch (InputMismatchException ipe){
				System.out.println("\tPlease enter a positive wole number ");
				
			}
		}
	}
}
