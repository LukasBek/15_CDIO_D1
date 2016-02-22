package funktionalitet;

public interface IFunktionalitet {

	boolean tjekLogin(int ID, String pass, int admin);

	void nettoVægt();

	void setKode(int ID, String kode);
}
