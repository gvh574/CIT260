/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cit260.Snake.Frames;

import Cit260.Snake.Controls.DirectionControl;
import Cit260.Snake.Controls.FruitControl;
import Cit260.Snake.Controls.GameThread;
import Cit260.Snake.Controls.SnakeControl;
import Cit260.Snake.Controls.highscore.HighScoreManager;
import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Kevin
 */
public class BoardFrame extends javax.swing.JFrame implements Serializable {

    /**
     * Creates new form BoardFrame
     */
    private SnakeControl snakeControl;
    private BoardFrame boardFrame;
    private DirectionControl directionControl;
    private GameThread gameThread;
    private FruitControl fruitControl;
    private MainFrame menu;
    private String gameStatus = "NEWGAME";
    private String statusMessage;
    private HighScoreManager hm;
    
    JLabel[][] labels = new JLabel[20][30];

    public void setHm(HighScoreManager hm) {
        this.hm = hm;
    }

    public void setSnakeControl(SnakeControl snakeControl) {
        this.snakeControl = snakeControl;
    }

    public BoardFrame getBoardFrame() {
        return boardFrame;
    }

    public void setBoardFrame(BoardFrame boardFrame) {
        this.boardFrame = boardFrame;
    }

    public void setDirectionControl(DirectionControl directionControl) {
        this.directionControl = directionControl;
    }

    public void setGameThread(GameThread gameThread) {
        this.gameThread = gameThread;
    }

    public void setFruitControl(FruitControl fruitControl) {
        this.fruitControl = fruitControl;
    }
    
    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public BoardFrame(MainFrame menu) {
        initComponents();
        this.menu = menu;
        //Sets a true transparent layer for the directions textarea
        jScrollPane1.getViewport().setOpaque(false);
        this.setBoard();
        //labels[10][10].setBackground(Color.BLUE);
    }

    private void setBoard() {
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 30; col++) {
                labels[row][col] = new JLabel();
                labels[row][col].setLocation(col * 19, row * 19);
                labels[row][col].setSize(18, 18);
                labels[row][col].setOpaque(true);
                labels[row][col].setBackground(Color.darkGray);
                board.add(labels[row][col]);
            }
        }
        showStatus();
    }
    
    private void resetBoard() {
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 30; col++) {
                labels[row][col].setBackground(Color.darkGray);
            }
        }
    }

    public void setThread() {
        SnakeControl snakeControl = new SnakeControl();
        snakeControl.createSnake();
        this.setSnakeControl(snakeControl);

        DirectionControl directionControl = new DirectionControl();
        this.setDirectionControl(directionControl);
        
        FruitControl fruitControl = new FruitControl();
        this.setFruitControl(fruitControl);

        GameThread gameThread = new GameThread();
        gameThread.setSnakeControl(snakeControl);
        gameThread.setBoardFrame(boardFrame);
        gameThread.setDirectionControl(directionControl);
        gameThread.setFruitControl(fruitControl);
        gameThread.setHm(hm);
        this.setGameThread(gameThread);
        directionControl.setGameThread(gameThread);

        Thread thread1 = new Thread((Runnable) gameThread);
        thread1.start();
    }

    public boolean checkWall(Point snakeHead) {
        if (snakeHead.x < 0 || snakeHead.x > 29 || snakeHead.y < 0 || snakeHead.y > 19) {
            return true;
        } else {
            return false;
        }
    }

    public void paintBoard(Point lastPos) {
        //Print Fruit
        int[] fruitLocation = fruitControl.getFruitLocation();
        labels[fruitLocation[1]][fruitLocation[0]].setBackground(Color.ORANGE);
        //Print snake
        ArrayList fullSnake = snakeControl.getSnake();
        Point snakeHead = (Point) fullSnake.get(0);
        labels[snakeHead.y][snakeHead.x].setBackground(Color.GREEN);
        for (int i = 1; i < fullSnake.size(); i++) {
            Point snakeTail = (Point) fullSnake.get(i);
            labels[snakeTail.y][snakeTail.x].setBackground(Color.RED);
        }
        //Reset where the snake was
        labels[lastPos.y][lastPos.x].setBackground(Color.darkGray);
        //Get score from thread
        int gameScore = gameThread.getGameScore();
        labelGameScore.setText("Score: " + gameScore);
        
        this.board.repaint();
    }
    
    public void showStatus() {
        switch (gameStatus) {
            case "GAMEOVER":
                statusMessage = "Game Over! Press the \"Spacebar\" to begin a new game.";
                break;
            case "NEWGAME":
                statusMessage = "Press the \"Spacebar\" to start your game.";
                break;
            case "PLAYING":
                statusMessage = " ";
                break;
            case "PAUSED":
                statusMessage = "Paused";
                break;
        }
        labelStatus.setText(statusMessage);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bgPanel = new javax.swing.JPanel();
        board = new javax.swing.JPanel();
        labelTheBoard = new javax.swing.JLabel();
        labelGameScore = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        boardDirections = new javax.swing.JTextArea();
        backButton = new javax.swing.JLabel();
        bgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        bgPanel.setOpaque(false);

        board.setBackground(new java.awt.Color(0, 0, 0));

        org.jdesktop.layout.GroupLayout boardLayout = new org.jdesktop.layout.GroupLayout(board);
        board.setLayout(boardLayout);
        boardLayout.setHorizontalGroup(
            boardLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 569, Short.MAX_VALUE)
        );
        boardLayout.setVerticalGroup(
            boardLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 379, Short.MAX_VALUE)
        );

        labelTheBoard.setFont(new java.awt.Font("SnakeStitch", 0, 34)); // NOI18N
        labelTheBoard.setForeground(new java.awt.Color(255, 255, 255));
        labelTheBoard.setText("The Board");

        labelGameScore.setFont(new java.awt.Font("Helvetica Neue", 1, 30)); // NOI18N
        labelGameScore.setForeground(new java.awt.Color(255, 255, 255));
        labelGameScore.setText("Score: 0");

        labelStatus.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelStatus.setForeground(new java.awt.Color(255, 255, 255));
        labelStatus.setText("Status appears here");

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        boardDirections.setColumns(20);
        boardDirections.setForeground(new java.awt.Color(255, 255, 255));
        boardDirections.setLineWrap(true);
        boardDirections.setRows(5);
        boardDirections.setText("Spacebar - Play/Pause\n\nKey Strokes:\nUp Arrow or \"W\" - UP\nLeft Arrow or \"A\" - Left\nRight Arrow or \"D\" - Right\nDown Arrow or \"S\" - Down");
        boardDirections.setFocusable(false);
        boardDirections.setOpaque(false);
        jScrollPane1.setViewportView(boardDirections);

        backButton.setFont(new java.awt.Font("SnakeStitch", 0, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonClicked(evt);
            }
        });
        backButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                backKeyPressed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout bgPanelLayout = new org.jdesktop.layout.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(bgPanelLayout.createSequentialGroup()
                .add(bgPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(bgPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(labelStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 569, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, bgPanelLayout.createSequentialGroup()
                        .add(23, 23, 23)
                        .add(bgPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(bgPanelLayout.createSequentialGroup()
                                .add(labelTheBoard)
                                .add(86, 86, 86)
                                .add(labelGameScore, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(board, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(18, 18, 18)
                .add(bgPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 175, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(backButton))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(bgPanelLayout.createSequentialGroup()
                .add(20, 20, 20)
                .add(bgPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelGameScore)
                    .add(labelTheBoard))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(bgPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(board, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(bgPanelLayout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(backButton)))
                .add(18, 18, 18)
                .add(labelStatus)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(bgPanel, gridBagConstraints);

        bgLabel.setBackground(new java.awt.Color(0, 0, 0));
        bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cit260/Snake/Images/board-background.png"))); // NOI18N
        bgLabel.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(bgLabel, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == 32) {
            switch (gameStatus) {
                case "GAMEOVER":
                    this.resetBoard();
                //No break here because we want the game to reset playing
                case "NEWGAME":
                    gameStatus = "PLAYING";
                    this.setThread();
                    break;
                case "PLAYING":
                    gameStatus = "PAUSED";
                    gameThread.setGameStopped(true);
                    break;
                case "PAUSED":
                    gameStatus = "PLAYING";
                    gameThread.setGameStopped(false);
                    Thread thread1 = new Thread((Runnable) gameThread);
                    thread1.start();
                    break;
            }
        } else if (gameStatus == "PLAYING") {
            directionControl.changeDirection(evt.getKeyCode());
        }
        showStatus();
    }//GEN-LAST:event_formKeyPressed

    private void backKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_backKeyPressed

    private void backButtonClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonClicked
        menu.setVisible(true);
        this.dispose();    }//GEN-LAST:event_backButtonClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel bgLabel;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JPanel board;
    private javax.swing.JTextArea boardDirections;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelGameScore;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelTheBoard;
    // End of variables declaration//GEN-END:variables
}
