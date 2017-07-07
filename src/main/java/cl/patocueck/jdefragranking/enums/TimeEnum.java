/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.patocueck.jdefragranking.enums;

/**
 *
 * @author pzunigap
 */
public enum TimeEnum {
    
    PLAYER_REACHED_TIME("30", "%1 ^7reached the time in %2"),
    NOT_IMPROVE_TIME("31", "^7El nuevo tiempo no es mejor que el registrado.");
        
    private String code;
    private String menssage;

    private TimeEnum(String code, String menssage){
            this.code = code;
            this.menssage = menssage;
    }

    public String getCode() {
            return code;
    }
    public void setCode(String code) {
            this.code = code;
    }
    public String getMessage() {
            return menssage;
    }
    public void setMenssage(String menssage) {
            this.menssage = menssage;
    }
}
