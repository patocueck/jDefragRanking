package cl.patocueck.jdefragranking.service.imp;

import cl.patocueck.jdefragranking.dao.PlayerDao;
import cl.patocueck.jdefragranking.dao.TimeDao;
import java.util.Date;

import org.springframework.stereotype.Service;

import cl.patocueck.jdefragranking.enums.ErrorEnum;
import cl.patocueck.jdefragranking.enums.LoginEnum;
import cl.patocueck.jdefragranking.enums.TimeEnum;
import cl.patocueck.jdefragranking.model.Player;
import cl.patocueck.jdefragranking.model.Time;
import cl.patocueck.jdefragranking.vo.BaseResponse;
import cl.patocueck.jdefragranking.vo.request.LoginRequest;
import cl.patocueck.jdefragranking.vo.response.LoginResponse;
import cl.patocueck.jdefragranking.service.PlayerService;
import cl.patocueck.jdefragranking.vo.request.RegisterTimeRequest;
import cl.patocueck.jdefragranking.vo.response.RegisterTimeResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PlayerServiceImp implements PlayerService {

    @Autowired
    PlayerDao playerDao; 
    @Autowired
    TimeDao timeDao;
            
    public BaseResponse<LoginResponse> login(LoginRequest login) {

        BaseResponse<LoginResponse> response = new BaseResponse<LoginResponse>();
        if (login.isNotValid()) {
            response.getHeader().setCode(ErrorEnum.DATOS_INVALIDOS.getCode());
            response.getHeader().setMessage(ErrorEnum.DATOS_INVALIDOS.getMessage());

            return response;
        }

        LoginResponse body = new LoginResponse();
        Player player = null;

        player = playerDao.getById(login.getEmail());
        
        if (player == null){
            response.getHeader().setCode(LoginEnum.USUARIO_NOEXISTE.getCode());
            response.getHeader().setMessage(LoginEnum.USUARIO_NOEXISTE.getMessage());
            return response;
        }

        if (player.getPassword().equals(login.getPassword())){
            response.getHeader().setCode(ErrorEnum.OK.getCode());
            response.getHeader().setMessage(ErrorEnum.OK.getMessage());

            body.setEmail(player.getEmail());
            body.setNombre(player.getNombre());
            body.setApellidos(player.getApellidos());
            
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
        Player player = null;
        player = playerDao.getById(registerTime.getEmail());
        
        Time time = null;
        
        time = timeDao.getTimeByEmail(registerTime.getEmail());
        //Ya tiene un tiempo, verificar cual es mas bajo
        if ( time != null ){
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
            Date newDate;
            try {
                newDate = sdf.parse(registerTime.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(PlayerServiceImp.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            if ( newDate.compareTo(time.getTime()) > 0 ){
                response.getHeader().setCode(TimeEnum.NOT_IMPROVE_TIME.getCode());
                response.getHeader().setMessage(TimeEnum.NOT_IMPROVE_TIME.getMessage());
                return response;
            }            
        }
        
        time = new Time();
        time.setEmail(registerTime.getEmail());
        time.setMap(registerTime.getMap());
        time.setPhysic(registerTime.getPhysic());
        Date timeFormat = new Date(registerTime.getTime()); //yyyy-MM-dd HH:mm:ss.SSS
        time.setTime(timeFormat);

        timeDao.add(time);

        response.getHeader().setCode(TimeEnum.PLAYER_REACHED_TIME.getCode());
        response.getHeader().setMessage(TimeEnum.PLAYER_REACHED_TIME.getMessage());
        
        String sResponse = TimeEnum.PLAYER_REACHED_TIME.getMessage();
        
        sResponse = String.format(sResponse, player.getNick(),time.getTime());
        body.setResponse(sResponse);
        response.setBody(body);

        return response;
    }
}
