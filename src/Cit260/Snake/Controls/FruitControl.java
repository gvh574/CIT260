/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cit260.Snake.Controls;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Kevin
 */
public class FruitControl implements Serializable{

    private int[] fruitLocation = {10, 10};
    private Random fruitX = new Random();
    private Random fruitY = new Random();

    public int[] getFruitLocation() {
        return fruitLocation;
    }

    public FruitControl() {
    }

    public boolean checkFruit(Point snakeHead) {
        if (snakeHead.x == fruitLocation[0] && snakeHead.y == fruitLocation[1]) {
            return true;
        }
        return false;
    }
    
    public void generateFruit(ArrayList snake, int boardRows, int boardColumns) {
        fruitLocation[0] = fruitX.nextInt(boardColumns - 2) + 2;
        fruitLocation[1] = fruitY.nextInt(boardRows - 2) + 2;
        for (int fruit = 0; fruit < snake.size(); fruit++) {
            Point bodyParts = (Point) snake.get(fruit);
            if (fruitLocation[0] == bodyParts.x && fruitLocation[1] == bodyParts.y) {
                generateFruit(snake, boardRows, boardColumns);
            }
        }
    }
}
