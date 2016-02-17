/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cit260.Snake.Controls.highscore;

import java.util.Comparator;

/**
 *
 * @author GregoryHall
 */
public class ScoreCompare implements Comparator<Score> {

    @Override
    public int compare(Score score1, Score score2) {

        int sc1 = score1.getScore();
        int sc2 = score2.getScore();

        if (sc1 > sc2) {
            return -1;
        } else if (sc1 < sc2) {
            return +1;
        } else {
            return 0;
        }
    }
}
