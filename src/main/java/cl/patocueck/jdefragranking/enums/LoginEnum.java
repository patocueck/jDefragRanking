package cl.patocueck.jdefragranking.enums;

public enum LoginEnum {

	USUARIO_NOEXISTE("20", "El usuario no existe"),
	USUARIO_INCORRECTO("21","Usuario/password incorrectos");
		
	private String code;
	private String menssage;
	
	private LoginEnum(String code, String menssage){
		this.code = code;
		this.menssage = menssage;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return menssage;
	}
	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}
}
