package data;

public interface IOperatoer {

	void addOp(int oprId, String oprNavn, String adgangskode, String cpr, int admin);

	void setOprId(int index, int oprId);

	int getOprId(int index);

	String getOprNavn(int index);

	void setOprNavn(int index, String oprNavn);

	String getAdgangskode(int index);

	void setAdgangskode(int index, String ini);

	String getCpr(int index);

	void setCpr(int index, String value);

	int getAdminStatus(int index);

	int getOperatoerArrayLaengde();

	void fjernOperatoer(int index);

}
