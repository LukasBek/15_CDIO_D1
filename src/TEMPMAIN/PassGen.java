package TEMPMAIN;

import java.util.ArrayList;

public class PassGen {

	ArrayList<Character> alfabet = new ArrayList<Character>();
	ArrayList<Character> Alfabet = new ArrayList<Character>();
	ArrayList<Integer> cifre = new ArrayList<Integer>();
	ArrayList<Character> specialtegn = new ArrayList<Character>();
	ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();
	private String password;
	
	public void array(){
		for (char letter = 'a'; letter <= 'z'; letter++){
			alfabet.add(letter);
		}
		for (char letter = 'A'; letter <= 'Z'; letter++){
			Alfabet.add(letter);
		}
		for (int i = 0; i<=9 ; i++){
			cifre.add(i);
		}
		specialtegn.add('.');
		specialtegn.add('-');
		specialtegn.add('_');
		specialtegn.add('+');
		specialtegn.add('!');
		specialtegn.add('?');
		specialtegn.add('=');

		list.add(alfabet);
		list.add(Alfabet);
		list.add(specialtegn);
	}


	public void passGen(){
		array();
		System.out.println(list.get(0).get(0));
	}



	//tester
	public static void main(String[] args) {
		passGen();
	}
}
