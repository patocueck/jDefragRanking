package cl.patocueck.jdefragranking.service.imp;

import java.util.Date;

import org.springframework.stereotype.Service;

import cl.patocueck.jdefragranking.enums.ErrorEnum;
import cl.patocueck.jdefragranking.enums.LoginEnum;
import cl.patocueck.jdefragranking.model.Player;
import cl.patocueck.jdefragranking.vo.BaseResponse;
import cl.patocueck.jdefragranking.vo.request.LoginRequest;
import cl.patocueck.jdefragranking.vo.response.LoginResponse;
import cl.patocueck.jdefragranking.service.PlayerService;
import cl.patocueck.jdefragranking.vo.request.RegisterTimeRequest;
import cl.patocueck.jdefragranking.vo.response.RegisterTimeResponse;

@Service
public class PlayerServiceImp implements PlayerService {

    public BaseResponse<LoginResponse> login(LoginRequest login) {

        BaseResponse<LoginResponse> response = new BaseResponse<LoginResponse>();
        if (login.isNotValid()) {
            response.getHeader().setCode(ErrorEnum.DATOS_INVALIDOS.getCode());
            response.getHeader().setMessage(ErrorEnum.DATOS_INVALIDOS.getMessage());

            return response;
        }

        LoginResponse body = new LoginResponse();
        Player player = new Player();

        //TODO: Ir a BD a buscar 
        player.setEmail("patocueck@gmail.com");
        player.setPassword("123");
        player.setNombre("Patricio");
        player.setNick("ZzZ|Hoopz");
        player.setApellidos("Zuniga Pizarro");

        if (!login.getEmail().equals(player.getEmail()) ){
            response.getHeader().setCode(LoginEnum.USUARIO_NOEXISTE.getCode());
            response.getHeader().setMessage(LoginEnum.USUARIO_NOEXISTE.getMessage());
            return response;
        }

        if (player.getPassword().equals(login.getPassword())){
            response.getHeader().setCode(ErrorEnum.OK.getCode());
            response.getHeader().setMessage(ErrorEnum.OK.getMessage());

            body.setEmail(player.getEmail());
            body.setNombre(player.getNombre());
            body.setApellidos(player.getApellidos());;
            body.setToken(generaToken(player.getEmail() + "/"+ player.getNombre()));

            response.setBody(body);

        }else{
            response.getHeader().setCode(LoginEnum.USUARIO_INCORRECTO.getCode());
            response.getHeader().setMessage(LoginEnum.USUARIO_INCORRECTO.getMessage());
        }

        return response;
    }

    private String generaToken(String data){
        Date fecha = new Date();
        return data + fecha.toString();
    }

    @Override
    public BaseResponse<RegisterTimeResponse> registerTime(RegisterTimeRequest registerTime) {
        BaseResponse<RegisterTimeResponse> response = new BaseResponse<RegisterTimeResponse>();
        if (registerTime.isNotValid()) {
            response.getHeader().setCode(ErrorEnum.DATOS_INVALIDOS.getCode());
            response.getHeader().setMessage(ErrorEnum.DATOS_INVALIDOS.getMessage());

            return response;
        }
        RegisterTimeResponse body = new RegisterTimeResponse();
        Player player = new Player();

        //TODO: Ir a BD a buscar 
        
        
        
        
        return response;
    }
}
