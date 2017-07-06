package cl.patocueck.jdefragranking.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.patocueck.jdefragranking.service.UsuarioService;
import cl.patocueck.jdefragranking.vo.BaseResponse;
import cl.patocueck.jdefragranking.vo.request.LoginRequest;
import cl.patocueck.jdefragranking.vo.response.LoginResponse;

@Service
@Path("/Login")
public class LoginRestService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@POST
	@Path("/login")
	@Produces("application/json")
    @Consumes("application/json")
	public BaseResponse<LoginResponse> login(LoginRequest login){  
		BaseResponse<LoginResponse> response = new BaseResponse<LoginResponse>();
	
		response = usuarioService.login(login);
		
		return response;  
	}  
}
