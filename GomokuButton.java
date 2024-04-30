import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GomokuButton extends JButton implements ActionListener {
    private int row;
    private int col;
    private char[][] board;
    private JButton[][] buttons;

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
            board[row][col] = 'O';
            setText("O");
            
        }
    }

    
}
