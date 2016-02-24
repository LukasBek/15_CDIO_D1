package funktionalitet;

public interface IFunktionalitet {

	boolean tjekLogin(int ID, String pass, int admin);

	double nettoVaegt(int ID, double brutto, double tarra);

	void setKode(int ID, String kode);

	void createOperatoer(String navn, String cpr, int admin);

	void deleteOperatoer(int iD);

	void showOperatoer(int iD);

	void showMaalinger();
	
	void showMaalinger(int iD);
	
	void changeOperatoer(int iD, int choice, String value);
	
	
	
}
