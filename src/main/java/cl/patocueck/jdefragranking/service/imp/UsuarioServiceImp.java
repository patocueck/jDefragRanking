package cl.patocueck.jdefragranking.service.imp;

import java.util.Date;

import org.springframework.stereotype.Service;

import cl.patocueck.jdefragranking.enums.ErrorEnum;
import cl.patocueck.jdefragranking.enums.LoginEnum;
import cl.patocueck.jdefragranking.model.Usuario;
import cl.patocueck.jdefragranking.service.UsuarioService;
import cl.patocueck.jdefragranking.vo.BaseResponse;
import cl.patocueck.jdefragranking.vo.request.LoginRequest;
import cl.patocueck.jdefragranking.vo.response.LoginResponse;

@Service
public class UsuarioServiceImp implements UsuarioService {

    public BaseResponse<LoginResponse> login(LoginRequest login) {

            BaseResponse<LoginResponse> response = new BaseResponse<LoginResponse>();
            if (login.isNotValid()) {
                    response.getHeader().setCode(ErrorEnum.DATOS_INVALIDOS.getCode());
                    response.getHeader().setMessage(ErrorEnum.DATOS_INVALIDOS.getMessage());

                    return response;
            }

            LoginResponse body = new LoginResponse();
            Usuario user = new Usuario();

            user.setEmail("patocueck@gmail.com");
            user.setPassword("124");
            user.setNombre("Patricio");
            user.setApellidos("Zuniga Pizarro");

            if (!login.getEmail().equals(user.getEmail()) ){
                    response.getHeader().setCode(LoginEnum.USUARIO_NOEXISTE.getCode());
                    response.getHeader().setMessage(LoginEnum.USUARIO_NOEXISTE.getMessage());
                    return response;
            }

            if (user.getPassword().equals(login.getPassword())){
                    response.getHeader().setCode(ErrorEnum.OK.getCode());
                    response.getHeader().setMessage(ErrorEnum.OK.getMessage());


                    body.setEmail(user.getEmail());
                    body.setNombre(user.getNombre());
                    body.setApellidos(user.getApellidos());;
                    body.setToken(generaToken(user.getEmail() + "/"+ user.getNombre()));

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
}
