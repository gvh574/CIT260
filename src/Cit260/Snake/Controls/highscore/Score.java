/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cit260.Snake.Controls.highscore;

import java.io.Serializable;

/**
 *
 * @author GregoryHall
 */
public class Score implements Serializable {

    private int score;
    private String name;
    
    public Score(){
    }
    
    public Score(String name, int score) {
        this.score = score;
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
