package cl.patocueck.jdefragranking.enums;

public enum ErrorEnum {

	OK("00", "Respuesta correcta"),
	DATOS_INVALIDOS("01","Datos Inv�lidos"),	
	NOK("9999","Error gen�rico");
	
	private String code;
	private String menssage;
	
	private ErrorEnum(String code, String menssage){
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
