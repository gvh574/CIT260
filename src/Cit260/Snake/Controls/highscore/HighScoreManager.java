/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cit260.Snake.Controls.highscore;

/**
 *
 * @author GregoryHall
 */
import Cit260.Snake.Controls.GameThread;
import java.util.*;
import java.io.*;

public class HighScoreManager {

    private ArrayList<Score> scores;
    private static final String HIGHSCORE_FILE = "highscores.txt";
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    static int max = 10;
    private GameThread gameThread;

    public HighScoreManager() {
        //initialising the scores-arraylist
        scores = new ArrayList<Score>();
    }

    public void setGameThread(GameThread gameThread) {
        this.gameThread = gameThread;
    }

    public ArrayList<Score> getScores() {
        this.loadScoreFile();
        this.sort();
        return scores;
    }

    private void sort() {
        ScoreCompare comparator = new ScoreCompare();
        Collections.sort(scores, comparator);
    }

    public void addScore(String name, int score) {
        this.loadScoreFile();
        scores.add(new Score(name, score));
        this.updateScoreFile();
    }

    public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Laad] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Laad] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Laad] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
    }

    public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE, false));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }

    public String getHighscoreString() {
        ArrayList<Score> scores;
        scores = this.getScores();
        String highscoreString = "";
        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t\t" + scores.get(i).getScore() + "\n";
            i++;
        }
        return highscoreString;
    }
    
    public boolean testHighScore(int newScore) {
        
        Integer lowestScore = (Integer) scores.get(scores.size()-1).getScore();
        int lowestTest = (int) lowestScore;
        if(newScore > lowestTest){
        return true;
        }
        return false;
        
    }
    
    public void newHighScore(String playerName){

        int hs = gameThread.getGameScore();
        this.addScore(playerName, hs);
    }
    
    public boolean startingScores() {
        if(scores.size() < 10){
        return true;
        }
        return false;
    }
}