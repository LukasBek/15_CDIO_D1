package funktionalitet;

public interface IFunktionalitet {

	boolean tjekLogin(int ID, String pass, int admin);

	void nettoVægt(int ID);

	void setKode(int ID, String kode);

	void createOperatoer(String navn, String cpr, int admin);

	void deleteOperatoer(int iD);

	void showOperatoer(int iD);
}
