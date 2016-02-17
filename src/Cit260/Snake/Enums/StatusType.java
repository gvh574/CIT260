/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cit260.Snake.Enums;

/**
 *
 * @author Kevin
 */
public enum StatusType {
    PREGAME ("PREGAME"),
    NEW_GAME ("NEW_GAME"),
    PLAYING ("PLAYING"),  
    QUIT ("QUIT"), 
    ERROR ("ERROR"),
    EXIT ("EXIT");
    
    String value;
    
    StatusType(String value) {
        this.value = value;   
    }
    
    public String getValue() {
        return value;
    }
}