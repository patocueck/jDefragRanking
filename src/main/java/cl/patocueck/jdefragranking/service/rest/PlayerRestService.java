/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.patocueck.jdefragranking.service.rest;

import cl.patocueck.jdefragranking.service.PlayerService;
import cl.patocueck.jdefragranking.vo.BaseResponse;
import cl.patocueck.jdefragranking.vo.request.RegisterTimeRequest;
import cl.patocueck.jdefragranking.vo.response.RegisterTimeResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pzunigap
 */
@Service
@Path("/Player")
public class PlayerRestService {
    
    @Autowired
    private PlayerService playerService;

    @POST
    @Path("/registerTime")
    @Produces("application/json")
    @Consumes("application/json")
    public BaseResponse<RegisterTimeResponse> login(RegisterTimeRequest registerTime){  
        BaseResponse<RegisterTimeResponse> response = new BaseResponse<RegisterTimeResponse>();

        response = playerService.registerTime(registerTime);

        return response;  
    }  
}
