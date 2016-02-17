/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cit260.Snake.Controls;

import Cit260.Snake.Controls.highscore.HighScoreManager;
import Cit260.Snake.Frames.BoardFrame;
import Cit260.Snake.Frames.PlayerNameFrame;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Kevin Okerlund
 */
public class GameThread implements Runnable, Serializable {
    
    private BoardFrame boardFrame;
    private SnakeControl snakeControl;
    private DirectionControl directionControl;
    private FruitControl fruitControl;
    private HighScoreManager hm;
    PlayerNameFrame playerName = new PlayerNameFrame();
    
    private boolean gameStopped = false;
    private boolean firstFruit = false;
    private int gameScore = 0;
    
    private ArrayList fullSnake;
    private Point snakeHead;
    private Point lastPos;
    
    public GameThread(){
    
    }

    public void setHm(HighScoreManager hm) {
        this.hm = hm;
    }
    
    public void setBoardFrame(BoardFrame boardFrame) {
        this.boardFrame = boardFrame;
    }

    public void setSnakeControl(SnakeControl snakeControl) {
        this.snakeControl = snakeControl;
    }
    
    public void setDirectionControl(DirectionControl directionControl) {
        this.directionControl = directionControl;
    }

    public void setFruitControl(FruitControl fruitControl) {
        this.fruitControl = fruitControl;
    }

    public boolean isGameStopped() {
        return gameStopped;
    }

    public void setGameStopped(boolean gameStopped) {
        this.gameStopped = gameStopped;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void run() {
        while (!gameStopped) {
            
            
            
            snakeControl.changeHead(directionControl.getDirection());
            
            fullSnake = snakeControl.getSnake();
            snakeHead = (Point) fullSnake.get(0);
            
            boolean checkTail = snakeControl.checkTail(snakeHead, fullSnake);
            boolean checkWall = boardFrame.checkWall(snakeHead);
            
            if (checkTail || checkWall) {
                gameStopped = true;
                boardFrame.setGameStatus("GAMEOVER");
                boardFrame.showStatus();
                    if (hm.testHighScore(gameScore) == true) {
                        playerName.setHm(hm);
                        playerName.setVisible(true);
                        hm.setGameThread(this);
                }

                
                continue;
            }
            
            if (fruitControl.checkFruit(snakeHead)) {
                gameScore += 10;
                fruitControl.generateFruit(fullSnake, 20, 30);
            } else if (!firstFruit) {
                fruitControl.generateFruit(fullSnake, 20, 30);
                lastPos = snakeControl.cutTail();
                firstFruit = true;
            } else {
                lastPos = snakeControl.cutTail();
            }
            
            boardFrame.paintBoard(lastPos);
            
            try {
                Thread.sleep(80);
            } catch (InterruptedException interruptedException) {
                System.out.println("First Thread is interrupted when it is sleeping" + interruptedException);
            }
        }
    }
}
