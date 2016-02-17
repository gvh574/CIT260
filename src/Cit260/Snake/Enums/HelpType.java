/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cit260.Snake.Enums;

/**
 *
 * @author jacksonrkj
 */
public enum HelpType {
        HOWTOPLAY ("YOU are the snake. You control him. Move him around the board"
                + " and obtain points. Each time you eat fruit the snake grows"
                + " in length. If you control the snake into either the walls"
                + " or yourself, GAME OVER."),
        
        BOARD ("The board is the area in which the snake moves."
                + " The board dimensions are 20 rows by 30 columns."),
          
        SCORING ("As you go about the board, your score is increased"
                + " or decreased as you obtain fruit. If you obtain a high score"
                + " in the top 10,your score will be recorded."),

        FRUIT ("Fruit is worth 10 points."
                + " Fruit is placed on the board in random locations."
                + " There will only be one fruit on the board"
                + " at a time."), 

        ABOUT ("Snake is a video game which originated during the late 1970s in"
                + " arcades and has maintained popularity since then, becoming a classic."
                + "The Game was invented by Scott McCarthy.");
        
        String helpText;

    private HelpType(String helpText) {
        this.helpText = helpText;
    }

    public String getHelpText() {
        return helpText;
    }
    
    

}
