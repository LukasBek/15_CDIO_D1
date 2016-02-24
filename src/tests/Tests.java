package tests;

import controllere.ProgramController;
import funktionalitet.Funktionalitet;
import data.Operatoer;
import java.util.Scanner;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {
	static Scanner sc;
	static ProgramController pC;
	static Operatoer o;
	static Funktionalitet f;
	
	@BeforeClass
	public static void init(){
		sc = new Scanner(System.in);
		pC = new ProgramController(sc);
		o = new Operatoer();
		f = new Funktionalitet(o);
	}
	@Before
	public void resetOps(){
		sc = new Scanner(System.in);
		pC = new ProgramController(sc);
		o = new Operatoer();
		f = new Funktionalitet(o);
	}
	@Test
	public void testCreateOperatoer(){
		f.createOperatoer("Jens", "1234567890", 1);
		int arrayELength = o.getOperatoerArrayLaengde();
		
		int actualValue = arrayELength;
		int expectedValue = 3;
		
		assertEquals(actualValue, expectedValue);
	}
	@Test
	public void testDeleteOperatoer(){
		f.createOperatoer("Jens", "1234567890", 1);
		f.deleteOperatoer(11);
		int actualValue = o.getOperatoerArrayLaengde();
		int expectedValue = 2;
		
		assertEquals(actualValue, expectedValue);
	}
	@Test
	public void testGetOperatoer(){
		f.createOperatoer("Jens", "1234567890", 1);
		String[] operatoer = f.getOperatoer(11);
		String actualValue = operatoer[1];
		String expectedValue = "Jens";
		
		assertEquals(actualValue, expectedValue);
	}
	@Test
	public void testChangeOperatoerName(){
		f.changeOperatoer(1, 1, "Bob");
		
		String actualValue = o.getOprNavn(1);
		String expectedValue = "Bob";
		
		assertEquals(actualValue, expectedValue);
		
	}
	@Test
	public void testChangeOperatoerCpr(){
		f.changeOperatoer(1, 2, "1234567890");
		
		String actualValue = o.getCpr(1);
		String expectedValue = "1234567890";
		
		assertEquals(actualValue, expectedValue);
			
	}
	@Test
	public void testChangeOperatoerPass(){
		f.changeOperatoer(1, 3, "B0b");
		
		String actualValue = o.getAdgangskode(1);
		String expectedValue = "B0b";
		
		assertEquals(actualValue, expectedValue);
		
	}
	@Test
	public void testTjekLoginTrue(){
		assertTrue(f.tjekLogin(1, "Test", 1));
	}
	@Test
	public void testTjekLoginFalse(){
		assertFalse(f.tjekLogin(1, "wrongPassword", 1));
	}
	@Test
	public void testNettoVaegt(){
		double actualValue = f.nettoVaegt(1, 2, 1);
		double expectedValue = 2-1;
		
		assertTrue(actualValue == expectedValue);
		
	}
	@Test
	public void testSetKode(){
		f.setKode(1, "bu3M");
		String actualValue = o.getAdgangskode(1);
		String expectedValue = "bu3M";
		
		assertEquals(actualValue, expectedValue);
	}
}
