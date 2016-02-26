package tests;

import controllere.ProgramController;
import funktionalitet.FException;
import funktionalitet.Funktionalitet;
import graenseflade.TUI;
import data.Operatoer;
import java.util.Scanner;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {
	static TUI t;
	static ProgramController pC;
	static Operatoer o;
	static Funktionalitet f;

	@Before
	public void resetOps(){
		t = new TUI();
		pC = new ProgramController(t);
		o = new Operatoer();
		f = new Funktionalitet(o);
	}
	@Test
	public void testCreateOperatoer(){
		f.createOperatoer("Jens", "1234567890", 1);

		int actualValue = o.getOperatoerArrayLaengde();
		int expectedValue = 2;

		assertEquals(actualValue, expectedValue);
	}
	@Test
	public void testDeleteOperatoer(){
		f.createOperatoer("Jens", "1234567890", 1);
		try {
			f.deleteOperatoer(11);
		} catch (FException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int actualValue = o.getOperatoerArrayLaengde();
		int expectedValue = 1;

		assertEquals(actualValue, expectedValue);
	}
	@Test
	public void testGetOperatoer(){
		f.createOperatoer("Jens", "1234567890", 1);
		String[] operatoer = null;
		try {
			operatoer = f.getOperatoer(11);
		} catch (FException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualValue = operatoer[1];
		String expectedValue = "Jens";

		assertEquals(actualValue, expectedValue);
	}
	@Test
	public void testChangeOperatoerName(){
		f.createOperatoer("Jens", "1234567890", 1);
		try {
			f.updateOperatoer(11, 1, "Bob");
		} catch (FException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String actualValue = o.getOprNavn(1);
		String expectedValue = "Bob";

		assertEquals(actualValue, expectedValue);

	}
	@Test
	public void testChangeOperatoerCpr(){
		f.createOperatoer("Jens", "1234567890", 1);
		try {
			f.updateOperatoer(11, 2, "1234567890");
		} catch (FException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String actualValue = o.getCpr(1);
		String expectedValue = "1234567890";

		assertEquals(actualValue, expectedValue);

	}
	@Test
	public void testChangeOperatoerPass(){
		f.createOperatoer("Jens", "1234567890", 1);
		try {
			f.updateOperatoer(11, 3, "B0b");
		} catch (FException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String actualValue = o.getAdgangskode(1);
		String expectedValue = "B0b";

		assertEquals(actualValue, expectedValue);

	}
	@Test
	public void testTjekLoginTrue(){
		f.createOperatoer("Jens", "1234567890", 1);
		assertTrue(f.tjekLogin(11, o.getAdgangskode(1), 1));
	}
	@Test
	public void testTjekLoginFalse(){
		f.createOperatoer("Jens", "1234567890", 1);
		assertFalse(f.tjekLogin(11, "wrongPassword", 1));
	}
	@Test
	public void testNettoVaegt(){
		double actualValue = f.nettoVaegt(1, 2, 1);
		double expectedValue = 2-1;

		assertTrue(actualValue == expectedValue);

	}
	@Test
	public void testSetKode(){
		f.createOperatoer("Jens", "1234567890", 1);
		f.setKode(11, "bu3M");
		String actualValue = o.getAdgangskode(1);
		String expectedValue = "bu3M";

		assertEquals(actualValue, expectedValue);
	}
}
