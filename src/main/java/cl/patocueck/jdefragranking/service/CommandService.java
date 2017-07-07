/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.patocueck.jdefragranking.service;

import cl.patocueck.jdefragranking.vo.BaseResponse;
import cl.patocueck.jdefragranking.vo.request.TopRequest;
import cl.patocueck.jdefragranking.vo.response.TopResponse;

/**
 *
 * @author pato
 */
public interface CommandService {
    
    public BaseResponse<TopResponse> getTop(TopRequest topRequest);
    
}
