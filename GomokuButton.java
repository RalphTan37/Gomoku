import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class GomokuButton extends JButton implements ActionListener {
    private int row;
    private int col;
    private char[][] board;
    private JButton[][] buttons;
    private GomokuPlayer currentPlayer;
<<<<<<< HEAD
    private GomokuBoard gameBoard;

    //Gomoku Button Constructor
=======
    private GomokuBoard gameBoard;  


>>>>>>> 21dd64b4d41a7e90ddf2ee978475997ffe67137e
    public GomokuButton(int row, int col, char[][] board, JButton[][] buttons, GomokuPlayer currentPlayer, GomokuBoard gameBoard) {
        this.row = row;
        this.col = col;
        this.board = board;
        this.buttons = buttons;
        this.currentPlayer = currentPlayer;
<<<<<<< HEAD
        this.gameBoard = gameBoard;
=======
        this.gameBoard = gameBoard; 
>>>>>>> 21dd64b4d41a7e90ddf2ee978475997ffe67137e
        this.setPreferredSize(new Dimension(50, 50));
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (board[row][col] == '-') {
            char stone = currentPlayer.getCurrentPlayer();
            board[row][col] = stone;
            this.setText(String.valueOf(stone));
            if (checkFiveInARow(stone)) {
                String playerName = (stone == 'O') ? "Player 1" : "Player 2";
                JOptionPane.showMessageDialog(null, "Congrats, " + playerName + " won!");
                Timer timer = new Timer(2000, (event) -> {
                    System.exit(0);
                });
                timer.setRepeats(false);
                timer.start();
            } else {
                currentPlayer.switchPlayer();  
                gameBoard.updateCurrentPlayerLabel();  
            }
<<<<<<< HEAD
            currentPlayer.switchPlayer(); //Switches Player
            gameBoard.updateCurrentPlayerLabel();
=======
>>>>>>> 21dd64b4d41a7e90ddf2ee978475997ffe67137e
        }
    }

    
    private boolean checkFiveInARow(char stone) {
        return checkDirection(1, 0, stone) ||  
               checkDirection(0, 1, stone) ||  
               checkDirection(1, 1, stone) ||  
               checkDirection(1, -1, stone);   
    }

    
    private boolean checkDirection(int rowStep, int colStep, char stone) {
     
    	int count = 1;  
        int r = row + rowStep;
        int c = col + colStep;

        //Traverses through board array
        while (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == stone) {
            count++;
            if (count == 5) return true;
            r += rowStep;
            c += colStep;
        }

        //Traverses in the opposite direction of rowStep & colStep
        r = row - rowStep;
        c = col - colStep;
        while (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == stone) {
            count++;
            if (count == 5) return true;
            r -= rowStep;
            c -= colStep;
        }
        return false;
    }
}