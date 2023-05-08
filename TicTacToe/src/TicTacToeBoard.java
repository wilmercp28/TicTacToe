
import static java.lang.String.valueOf;
import java.util.Random;
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


public class TicTacToeBoard extends javax.swing.JFrame {
char player = 'X';
char machine = 'O';
char[][] gameBoard = {{' ', ' ', ' '},
                      {' ', ' ', ' '},
                      {' ', ' ', ' '}};
boolean playerTurn = true;
int playerWins = 0;
int machineWins = 0;
boolean gameIsOver = false;
int emptySlots = 9;
int tie = 0;


    public TicTacToeBoard() {
        initComponents();
    }
    
    private void restartGame(){

       for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {
            gameBoard[row][col] = ' '; // change ' ' to '_'
            gameBoardUpdate();
            gameIsOver = false;
            emptySlots = 9;
            playerTurn = true;
        }
    }
    }
    
    
    //When checkForWinner is true
    public void gameOverCheck(){
     if (checkForWinner(player)) {
    System.out.println("Player Won");
    playerWins++;
    gameIsOver = true;
       } else if (checkForWinner(machine)) {
    System.out.println("Machine Won");
    machineWins++;
    gameIsOver = true;
    } else if (emptySlots == 1){
    tie++;
    gameIsOver = true;
    }
       

scoreBoard.setText("Player wins " + playerWins + " Machine wins " + machineWins + " Ties " + tie);
    
    }
    
    public boolean checkForWinner(char symbol){
   // Check rows
    for (int row = 0; row < 3; row++) {
        if (gameBoard[row][0] == symbol && gameBoard[row][1] == symbol && gameBoard[row][2] == symbol) {
            return true;
        }
    }

    // Check columns
    for (int col = 0; col < 3; col++) {
        if (gameBoard[0][col] == symbol && gameBoard[1][col] == symbol && gameBoard[2][col] == symbol) {
            return true;
        }
    }

    // Check diagonals
    if (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) {
        return true;
    }
    return gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol;
    
    
    
    }
    
    // gameBoard update buttom text value
    public void gameBoardUpdate(){
    b1.setText(valueOf(gameBoard[0][0]));
    b2.setText(valueOf(gameBoard[0][1]));
    b3.setText(valueOf(gameBoard[0][2]));
    b4.setText(valueOf(gameBoard[1][0]));
    b5.setText(valueOf(gameBoard[1][1]));
    b6.setText(valueOf(gameBoard[1][2]));
    b7.setText(valueOf(gameBoard[2][0]));
    b8.setText(valueOf(gameBoard[2][1]));
    b9.setText(valueOf(gameBoard[2][2]));
    
    }
    
    // machine player movements
    public void machineMove(){
    
    Random random = new Random();
if (emptySlots == 1) {
        restartGame();
    }
    
    if (!gameIsOver) {
        while (!playerTurn) {
            // Check if machine can win
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (gameBoard[row][col] == ' ') {
                        gameBoard[row][col] = machine;
                        emptySlots--;
                        
                        if (checkForWinner(machine)) {
                            gameBoardUpdate();
                            gameOverCheck();
                            
                            if (emptySlots == 1) {
                                restartGame();
                            }
                            
                            return;
                        }
                        
                        gameBoard[row][col] = ' ';
                        emptySlots++;
                    }
                }
            }
            // Check if player can win next move, then block it
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (gameBoard[row][col] == ' ') {
                        gameBoard[row][col] = player;
                        emptySlots--;
                        
                        if (checkForWinner(player)) {
                            gameBoard[row][col] = machine;
                            gameBoardUpdate();
                            gameOverCheck();
                            
                            if (emptySlots == 1) {
                                restartGame();
                            }
                            
                            return;
                        }
                        
                        gameBoard[row][col] = ' ';
                        emptySlots++;
                    }
                }
                
            }
            // If no win nor block, random move
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            if (gameBoard[row][col] == ' ') {
                gameBoard[row][col] = machine;
                gameBoardUpdate();
                gameOverCheck();
                emptySlots--;
                
                if (emptySlots == 1) {
                    restartGame();
                }
                
                return;
            }
        }
    }
    System.out.println(emptySlots);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        playerLabel = new javax.swing.JLabel();
        playerChange = new javax.swing.JButton();
        scoreBoard = new javax.swing.JTextField();
        restartGame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        b1.setMaximumSize(new java.awt.Dimension(50, 50));
        b1.setMinimumSize(new java.awt.Dimension(50, 50));
        b1.setPreferredSize(new java.awt.Dimension(50, 50));
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b1MouseClicked(evt);
            }
        });

        b2.setMaximumSize(new java.awt.Dimension(50, 50));
        b2.setMinimumSize(new java.awt.Dimension(50, 50));
        b2.setPreferredSize(new java.awt.Dimension(50, 50));
        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b2MouseClicked(evt);
            }
        });

        b3.setMaximumSize(new java.awt.Dimension(50, 50));
        b3.setMinimumSize(new java.awt.Dimension(50, 50));
        b3.setPreferredSize(new java.awt.Dimension(50, 50));
        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b3MouseClicked(evt);
            }
        });

        b4.setMaximumSize(new java.awt.Dimension(50, 50));
        b4.setMinimumSize(new java.awt.Dimension(50, 50));
        b4.setPreferredSize(new java.awt.Dimension(50, 50));
        b4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b4MouseClicked(evt);
            }
        });

        b5.setMaximumSize(new java.awt.Dimension(50, 50));
        b5.setMinimumSize(new java.awt.Dimension(50, 50));
        b5.setPreferredSize(new java.awt.Dimension(50, 50));
        b5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b5MouseClicked(evt);
            }
        });

        b6.setMaximumSize(new java.awt.Dimension(50, 50));
        b6.setMinimumSize(new java.awt.Dimension(50, 50));
        b6.setPreferredSize(new java.awt.Dimension(50, 50));
        b6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b6MouseClicked(evt);
            }
        });

        b8.setMaximumSize(new java.awt.Dimension(50, 50));
        b8.setMinimumSize(new java.awt.Dimension(50, 50));
        b8.setPreferredSize(new java.awt.Dimension(50, 50));
        b8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b8MouseClicked(evt);
            }
        });

        b7.setMaximumSize(new java.awt.Dimension(50, 50));
        b7.setMinimumSize(new java.awt.Dimension(50, 50));
        b7.setPreferredSize(new java.awt.Dimension(50, 50));
        b7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b7MouseClicked(evt);
            }
        });

        b9.setMaximumSize(new java.awt.Dimension(50, 50));
        b9.setMinimumSize(new java.awt.Dimension(50, 50));
        b9.setPreferredSize(new java.awt.Dimension(50, 50));
        b9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b9MouseClicked(evt);
            }
        });

        playerLabel.setBackground(new java.awt.Color(255, 255, 255));
        playerLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        playerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerLabel.setText("You are: " + player);

        playerChange.setText("Change Player");
        playerChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerChangeMouseClicked(evt);
            }
        });

        scoreBoard.setEditable(false);
        scoreBoard.setBackground(new java.awt.Color(255, 255, 255));
        scoreBoard.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        scoreBoard.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        scoreBoard.setText("Player wins " + playerWins + " Machine wins " + machineWins + " Ties " + tie);
        scoreBoard.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        scoreBoard.setFocusable(false);

        restartGame.setText("Restart");
        restartGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restartGameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scoreBoard, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(playerChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(restartGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(7, 7, 7)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b1, b2, b3, b4, b5, b6, b7, b8, b9});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(playerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerChange, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(restartGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scoreBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b1, b2, b3, b4, b5, b6, b7, b8, b9});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playerChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerChangeMouseClicked
    //Changing player symbol
    if (player == 'X'){
    player = 'O';
    machine = 'X';
    } else {
    player = 'X';
    machine = 'O';
    }
    playerLabel.setText("You are: " + player);
    }//GEN-LAST:event_playerChangeMouseClicked

    private void b1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseClicked
    if( !gameIsOver && gameBoard[0][0] == ' '){
      if (gameBoard[0][0] == ' ') {
        gameBoard[0][0] = player;
        gameBoardUpdate();
        playerTurn = false;
        gameOverCheck();
        machineMove();
        emptySlots--;
      }
    }
    }//GEN-LAST:event_b1MouseClicked

    private void b2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseClicked
    if( !gameIsOver && gameBoard[0][1] == ' '){
      if (gameBoard[0][1] == ' ') {
        gameBoard[0][1] = player;
        gameBoardUpdate();
        playerTurn = false;
        gameOverCheck();
        machineMove();
        emptySlots--;
      }
    }
    }//GEN-LAST:event_b2MouseClicked

    private void b3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseClicked
    if( !gameIsOver && gameBoard[0][2] == ' '){
      if (gameBoard[0][2] == ' ') {
        gameBoard[0][2] = player;
        gameBoardUpdate();
        playerTurn = false;
        gameOverCheck();
        machineMove();
        emptySlots--;
      }
    }
    }//GEN-LAST:event_b3MouseClicked

    private void b4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b4MouseClicked
     if( !gameIsOver && gameBoard[1][0] == ' '){
      if (gameBoard[1][0] == ' ') {
        gameBoard[1][0] = player;
        gameBoardUpdate();
        playerTurn = false;
        gameOverCheck();
        machineMove();
        emptySlots--;
      }
    }
    }//GEN-LAST:event_b4MouseClicked

    private void b5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b5MouseClicked
    if( !gameIsOver && gameBoard[1][1] == ' '){
      if (gameBoard[1][1] == ' ') {
        gameBoard[1][1] = player;
        gameBoardUpdate();
        playerTurn = false;
        gameOverCheck();
        machineMove();
        emptySlots--;
      }
    }
    }//GEN-LAST:event_b5MouseClicked

    private void b6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b6MouseClicked
     if( !gameIsOver && gameBoard[1][2] == ' '){
      if (gameBoard[1][2] == ' ') {
        gameBoard[1][2] = player;
        gameBoardUpdate();
        playerTurn = false;
        gameOverCheck();
        machineMove();
        emptySlots--;
      }
    }
    }//GEN-LAST:event_b6MouseClicked

    private void b7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b7MouseClicked
    if( !gameIsOver && gameBoard[2][0] == ' '){
      if (gameBoard[2][0] == ' ') {
        gameBoard[2][0] = player;
        gameBoardUpdate();
        playerTurn = false;
        gameOverCheck();
        machineMove();
        emptySlots--;
      }
    }
    }//GEN-LAST:event_b7MouseClicked

    private void b8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b8MouseClicked
    if( !gameIsOver && gameBoard[2][1] == ' '){
      if (gameBoard[2][1] == ' ') {
        gameBoard[2][1] = player;
        gameBoardUpdate();
        playerTurn = false;
        gameOverCheck();
        machineMove();
        emptySlots--;
      }
    }
    }//GEN-LAST:event_b8MouseClicked

    private void b9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b9MouseClicked
    if( !gameIsOver && gameBoard[2][2] == ' '){
      if (gameBoard[2][2] == ' ') {
        gameBoard[2][2] = player;
        gameBoardUpdate();
        playerTurn = false;
        gameOverCheck();
        machineMove();
        emptySlots--;
      }
    }
    }//GEN-LAST:event_b9MouseClicked

    private void restartGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restartGameMouseClicked
     restartGame();
    }//GEN-LAST:event_restartGameMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToeBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToeBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToeBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToeBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton playerChange;
    private javax.swing.JLabel playerLabel;
    private javax.swing.JButton restartGame;
    private javax.swing.JTextField scoreBoard;
    // End of variables declaration//GEN-END:variables
JButton[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9};

}

