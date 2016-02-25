package funktionalitet;

public interface IFunktionalitet {

	boolean tjekLogin(int ID, String pass, int admin);

	double nettoVaegt(int ID, double brutto, double tarra);

	void setKode(int ID, String kode);

	void createOperatoer(String navn, String cpr, int admin) throws FException;

	void deleteOperatoer(int iD) throws FException;

	String[] getOperatoer(int iD) throws FException;

	void showMaalinger();
	
	void showMaalinger(int iD);
	
	void updateOperatoer(int iD, int choice, String value) throws FException;
		
}
