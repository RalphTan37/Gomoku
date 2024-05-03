import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GomokuButton extends JButton implements ActionListener {
    //Instance Variables
	private int row;
    private int col;
    private char[][] board;
    private JButton[][] buttons;
    private GomokuPlayer currentPlayer;

    //Gomoku Button Constructor
    public GomokuButton(int row, int col, char[][] board, JButton[][] buttons, GomokuPlayer currentPlayer) {
        this.row = row;
        this.col = col;
        this.board = board;
        this.buttons = buttons;
        this.currentPlayer = currentPlayer;
        this.setPreferredSize(new Dimension(50, 50));
        this.addActionListener(this);
    }

    //Event Handler for Button Clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (board[row][col] == '-') {
            board[row][col] = currentPlayer.getCurrentPlayer();  
            this.setText(String.valueOf(currentPlayer.getCurrentPlayer()));
            if (checkFiveInARow()) {
                JOptionPane.showMessageDialog(null, "Congrats, Player 1 won!");
            }
            currentPlayer.switchPlayer();
        }
    }

    //Checks the Winning Condition - Five in a Row!
    private boolean checkFiveInARow() {
        return checkDirection(1, 0) ||  
               checkDirection(0, 1) ||  
               checkDirection(1, 1) ||  
               checkDirection(1, -1);   
    }

    //Checks for 5 consecutive stones in a row & direction
    private boolean checkDirection(int rowStep, int colStep) {
        int count = 1;  
        int r = row + rowStep;
        int c = col + colStep;

        
        while (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'O') {
            count++;
            if (count == 5) return true;
            r += rowStep;
            c += colStep;
        }

        
        r = row - rowStep;
        c = col - colStep;
        while (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'O') {
            count++;
            if (count == 5) return true;
            r -= rowStep;
            c -= colStep;
        }

        return false;
    }
}