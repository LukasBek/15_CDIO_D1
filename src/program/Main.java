package program;

import java.io.IOException;

import graenseflade.TUI;

public class Main {

	public static void main(String[] args) {


		TUI tui = new TUI();
		try {
			tui.hovedMenu();
		} catch (IOException e) {
			System.out.println("Hov, der skete en fejl - venligst kontakt devs for support.");
		}

	}

}
