import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class GomokuButton extends JButton implements ActionListener {
    //Instance Variables
	private int row;
    private int col;
    private char[][] board;
    private JButton[][] buttons;
    private GomokuPlayer currentPlayer;
    private GomokuBoard gameBoard;

    //Gomoku Button Constructor
    public GomokuButton(int row, int col, char[][] board, JButton[][] buttons, GomokuPlayer currentPlayer, GomokuBoard gameBoard) {
        this.row = row;
        this.col = col;
        this.board = board;
        this.buttons = buttons;
        this.currentPlayer = currentPlayer;
        this.gameBoard = gameBoard;
        this.setPreferredSize(new Dimension(50, 50));
        this.addActionListener(this);
    }

    //Event Handler for Button Clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (board[row][col] == '-') {
        	char stone = currentPlayer.getCurrentPlayer();
            board[row][col] = stone;
            this.setText(String.valueOf(stone));
            if (checkFiveInARow(stone)) {
                String playerName = (stone == 'O') ? "Player 1" : "Player 2";
            	JOptionPane.showMessageDialog(null, "Congrats, " + playerName + " won!");
            	//In 2 seconds, the program closes
            	Timer timer = new Timer(2000, (event) ->{
            		System.exit(0);
            	});
            	timer.setRepeats(false);
            	timer.start();
            }
            currentPlayer.switchPlayer(); //Switches Player
            gameBoard.updateCurrentPlayerLabel();
        }
    }

    //Checks the Winning Condition - Five in a Row!
    private boolean checkFiveInARow(char stone) {
        return checkDirection(1, 0, stone) ||  
               checkDirection(0, 1, stone) ||  
               checkDirection(1, 1, stone) ||  
               checkDirection(1, -1, stone);   
    }

    //Checks for 5 consecutive stones in a row & direction
    private boolean checkDirection(int rowStep, int colStep, char stone) {
        //Variables
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