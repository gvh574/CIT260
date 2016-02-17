/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cit260.Snake.Controls;

import java.io.Serializable;

/**
 *
 * @author Kevin
 */
public class DirectionControl implements Serializable {
    
    private GameThread gameThread;
    
    private String direction = "left";

    public void setGameThread(GameThread gameThread) {
        this.gameThread = gameThread;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
    
    public DirectionControl() {
    }
    
    public void changeDirection(int keyCode) {
        if (!gameThread.isGameStopped()) {
            switch (keyCode) {
                case 37:
                case 65:
                    if (direction != "right") {
                        direction = "left";
                    }
                    break;
                case 39:
                case 68:
                    if (direction != "left") {
                        direction = "right";
                    }
                    break;
                case 38:
                case 87:
                    if (direction != "down") {
                        direction = "up";
                    }
                    break;
                case 40:
                case 83:
                    if (direction != "up") {
                        direction = "down";
                    }
                    break;
            }
        }
    }
}
