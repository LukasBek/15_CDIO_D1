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
	public void test
}
