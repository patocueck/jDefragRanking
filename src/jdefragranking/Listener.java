/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdefragranking;

/**
 *
 * @author pzunigap
 */
public class Listener {
    
    
    public String escribirComando(){
        return "dir";
    }
    
    /**
     * Funcion detecta un comando de cada linea de la consola 
     * y retorna el tipo de comando.
     * @param lineFromConsole Línea que viene desde la consola.
     * @return 
     */
    public String readCommand(String lineFromConsole){
        if ( lineFromConsole.startsWith("!top")){
            return "top";
        }
        return null;
    }
}
