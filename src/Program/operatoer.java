package Program;

public class operatoer {

	private int oprId;
	private String oprNavn;
	private String ini;
	private String cpr;
	private String Password;
	
	public operatoer(int oprId, String oprNavn, String ini, String cpr, boolean admin, String Password){
	
		this.cpr = cpr;
		this.ini = ini;
		this.oprNavn = oprNavn;
		this.oprId = oprId;
		this.Password = Password;
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
	
	public void setCpr(String cpr) {
		
	}
	public String getPassword() {
		return Password;
		
	}
	public void setPassword(String password){
		

	}
}

	
