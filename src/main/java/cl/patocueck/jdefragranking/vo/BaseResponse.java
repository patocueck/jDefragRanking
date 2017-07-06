package cl.patocueck.jdefragranking.vo;


public class BaseResponse<T> {
	
	private HeaderResponse header;
	private T body;
	
	public BaseResponse(){
		header = new HeaderResponse();
	}
	
	public HeaderResponse getHeader() {
		return header;
	}
	public void setHeader(HeaderResponse header) {
		this.header = header;
	}
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
}
