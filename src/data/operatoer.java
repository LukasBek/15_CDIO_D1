package data;

public class operatoer {

	private int oprId;
	private int admin;
	private String oprNavn;
	private String ini;
	private String cpr;
	private String Adgangskode;
	
	public operatoer(int oprId, String oprNavn, String ini, String cpr, int admin, String Adgangskode){
	
		this.cpr = cpr;
		this.ini = ini;
		this.oprNavn = oprNavn;
		this.oprId = oprId;
		this.Adgangskode = Adgangskode;
		this.admin = admin;
	}
	
	public int getOprId() {
		return oprId;
	}
	public void setOprId(int oprId) {
		this.oprId = oprId;
	}
	public String getOprNavn() {
		return oprNavn;
	}
	public void setOprNavn(String oprNavn) {
		this.oprNavn = oprNavn;
	}
	public String getIni() {
		return ini;
	}
	public void setIni(String ini) {
		this.ini = ini;
	}
	public String getCpr() {
		return cpr;
	}
	
	public String getAdgangskode() {
		return Adgangskode;
		
	}
	public void setAdgangskode(String adgangskode){
		this.Adgangskode = adgangskode;
	}
	
	public int getAdmin(){
		return admin;
	}
}

	
