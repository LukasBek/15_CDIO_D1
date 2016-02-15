package Program;

public class Sysadmin {

	private int ini;
	private String Password;
	private boolean admin;
	

public Sysadmin(int ini, String Password, boolean admin){
	this.ini=ini;
	this.Password=Password;
	this.admin=admin;

}

public int getini(){
	return ini;
}
public void setini(int ini){
	this.ini=ini;
}

public String getPassword(){
	return Password;
}
public void setPassword(String Password){
	this.Password=Password;
}
public boolean getadmin(){
	return admin;
}
public void setadmin(boolean admin){
	this.admin=admin;
}



}