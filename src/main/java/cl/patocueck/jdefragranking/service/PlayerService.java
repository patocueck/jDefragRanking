package cl.patocueck.jdefragranking.service;


import cl.patocueck.jdefragranking.vo.BaseResponse;
import cl.patocueck.jdefragranking.vo.request.LoginRequest;
import cl.patocueck.jdefragranking.vo.request.RegisterTimeRequest;
import cl.patocueck.jdefragranking.vo.response.LoginResponse;
import cl.patocueck.jdefragranking.vo.response.RegisterTimeResponse;


public interface PlayerService {
	
	public BaseResponse<LoginResponse> login(LoginRequest login);
        public BaseResponse<RegisterTimeResponse> registerTime(RegisterTimeRequest registerTime);  
}
