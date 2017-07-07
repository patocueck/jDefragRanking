/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.patocueck.jdefragranking.service.imp;

import cl.patocueck.jdefragranking.dao.PlayerDao;
import cl.patocueck.jdefragranking.dao.TimeDao;
import cl.patocueck.jdefragranking.enums.ErrorEnum;
import cl.patocueck.jdefragranking.model.Player;
import cl.patocueck.jdefragranking.model.Time;
import cl.patocueck.jdefragranking.service.CommandService;
import cl.patocueck.jdefragranking.vo.BaseResponse;
import cl.patocueck.jdefragranking.vo.request.TopRequest;
import cl.patocueck.jdefragranking.vo.response.TopResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pzunigap
 */
@Service
public class CommandServiceImp implements CommandService {

    @Autowired
    PlayerDao playerDao; 
    @Autowired
    TimeDao timeDao;
            
    @Override
    public BaseResponse<TopResponse> getTop(TopRequest topRequest) {
        BaseResponse<TopResponse> response = new BaseResponse<TopResponse>();
        if (topRequest.isNotValid()) {
            response.getHeader().setCode(ErrorEnum.DATOS_INVALIDOS.getCode());
            response.getHeader().setMessage(ErrorEnum.DATOS_INVALIDOS.getMessage());

            return response;
        }
        
        TopResponse body = new TopResponse();
        
        List<Time> times = timeDao.getTop(topRequest.getMap(), topRequest.getPhysic());
        
        StringBuilder sb = new StringBuilder();
        sb.append("========== TOP 10 ==========\n");
        int i = 1;
        for (Time time : times) {
            Player player = playerDao.getById(time.getEmail());
            sb.append(i)
            .append(") ")
            .append(time.getTime())
            .append("  ")
            .append(player.getNick())
            .append("   \n");
            i++;
        }
        
        body.setResponse(sb.toString());
        
        return response;
    }
    
}
