package data;

public class Sysadmin {

	private int ini;
	private String Adgangskode;
	private boolean admin;
	

public Sysadmin(int ini, String Adgangskode, boolean admin){
	this.ini=ini;
	this.Adgangskode=Adgangskode;
	this.admin=admin;

}

public int getini(){
	return ini;
}
public void setini(int ini){
	this.ini=ini;
}

public String getPassword(){
	return Adgangskode;
}
public void setPassword(String Adgangskode){
	this.Adgangskode=Adgangskode;
}
public boolean getadmin(){
	return admin;
}
public void setadmin(boolean admin){
	this.admin=admin;
}



}