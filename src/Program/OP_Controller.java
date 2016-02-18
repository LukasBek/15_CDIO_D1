package Program;

import java.util.ArrayList;

public class OP_Controller {
	
	private operatoer operatoer;
	
	ArrayList<operatoer> opArray = new ArrayList<operatoer>();
	
	
	public void addOp(int oprId, String oprNavn, String ini, String cpr, boolean admin, String Password){
		
		opArray.add(new operatoer(oprId, oprNavn, ini, cpr, admin, Password));

		
	}
	

/**
 * Will return the ID of the operator on the given index
 * @param index the place in the array list the method will be called
 * @return The ID of the operator
 */
	
	public int getOprId(int index){
	
		return (opArray.get(index)).getOprId();
	
	}
	
	
	
	
	
	

}
