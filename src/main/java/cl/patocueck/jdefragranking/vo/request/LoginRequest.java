package cl.patocueck.jdefragranking.vo.request;

public class LoginRequest {

	private String email;
	private String password;
	
	public boolean isNotValid(){
		if (email == null) return true;
		if (password == null) return true;
		if (password.equals("")) return true;
		if (email.equals("")) return true;
		
		return false;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
}
