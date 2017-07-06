package cl.patocueck.jdefragranking.service;


import cl.patocueck.jdefragranking.vo.BaseResponse;
import cl.patocueck.jdefragranking.vo.request.LoginRequest;
import cl.patocueck.jdefragranking.vo.response.LoginResponse;


public interface PlayerService {
	
	public BaseResponse<LoginResponse> login(LoginRequest login);
}
