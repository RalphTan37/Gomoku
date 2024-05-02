import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GomokuButton extends JButton implements ActionListener {
    private int row;
    private int col;
    private char[][] board;
    private JButton[][] buttons;
    private static boolean isXPlayer = true;

    public GomokuButton(int row, int col, char[][] board, JButton[][] buttons) {
        this.row = row;
        this.col = col;
        this.board = board;
        this.buttons = buttons;
        this.setPreferredSize(new Dimension(50, 50));
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (board[row][col] == '-') {
            if (isXPlayer) {
                board[row][col] = 'X';
                this.setText("X");
            } else {
                board[row][col] = 'O';
                this.setText("O");
            }
            isXPlayer = !isXPlayer; // Toggle the player turn

            if (checkFiveInARow(board[row][col])) {
                JOptionPane.showMessageDialog(null, "Congrats, Player " + (board[row][col] == 'X' ? "1" : "2") + " won!");
            }
        }
    }

    private boolean checkFiveInARow(char player) {
        // Check all four directions: horizontal, vertical, and two diagonals
        return checkDirection(row, col, 1, 0, player) >= 4 ||  // horizontal
               checkDirection(row, col, 0, 1, player) >= 4 ||  // vertical
               checkDirection(row, col, 1, 1, player) >= 4 ||  // diagonal (down-right)
               checkDirection(row, col, 1, -1, player) >= 4;  // diagonal (up-right)
    }

    private int checkDirection(int startRow, int startCol, int rowStep, int colStep, char player) {
        int count = 0;
        // Check in the positive direction
        for (int r = startRow, c = startCol; r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == player; r += rowStep, c += colStep) {
            count++;
        }
        // Check in the negative direction
        for (int r = startRow - rowStep, c = startCol - colStep; r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == player; r -= rowStep, c -= colStep) {
            count++;
        }
        return count - 1;  // Subtract one because we counted the start position twice
    }
}
