/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cit260.Snake.Controls;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class SnakeControl implements Serializable {
    
    private ArrayList snake = new ArrayList();

    public ArrayList getSnake() {
        return snake;
    }
    
    public SnakeControl() {
    }
    
    public void createSnake() {
        snake.add(new Point(15, 10));
        snake.add(new Point(16, 10));
        snake.add(new Point(17, 10));
        snake.add(new Point(18, 10));
    }
    
    public void changeHead(String direction) {
        Point snakeHead = (Point) snake.get(0);
        switch (direction) {
            case "left":
                snake.add(0, new Point(snakeHead.x - 1, snakeHead.y));
                break;
            case "right":
                snake.add(0, new Point(snakeHead.x + 1, snakeHead.y));
                break;
            case "up":
                snake.add(0, new Point(snakeHead.x, snakeHead.y -1 ));
                break;
            case "down":
                snake.add(0, new Point(snakeHead.x, snakeHead.y + 1));
                break;
        }
    }
    
    public Point cutTail() {
        Point lastPos = (Point) snake.get(snake.size() - 1);
        snake.remove(snake.size() - 1);
        return lastPos;
    } 
    
    public boolean checkTail(Point snakeHead, ArrayList snake) {
        for (int tail = 1; tail < snake.size(); tail++) {
            Point snakeBody = (Point) snake.get(tail);
            if (snakeHead.x == snakeBody.x && snakeHead.y == snakeBody.y) {
                return true;
            }
        }
        return false;
    }
}
