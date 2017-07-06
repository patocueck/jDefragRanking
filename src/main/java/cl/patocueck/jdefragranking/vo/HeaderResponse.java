package cl.patocueck.jdefragranking.vo;

import cl.patocueck.jdefragranking.enums.ErrorEnum;

public class HeaderResponse {
		
	private String code;
	private String menssage;
	
	public HeaderResponse(){
		this.code = ErrorEnum.DATOS_INVALIDOS.getCode();
		this.menssage = ErrorEnum.DATOS_INVALIDOS.getMessage();
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
	public void setMessage(String menssage) {
		this.menssage = menssage;
	}
}
