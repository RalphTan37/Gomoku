import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GomokuBoard extends JFrame {
	//Instance Variables
    private static final int DEFAULT_SIZE = 15;
    private int size;
    private JButton[][] buttons;
    private char[][] board;
    private JPanel boardPanel;

    //Gomoku Constructor
    public GomokuBoard() {
        this.size = DEFAULT_SIZE;
        this.board = new char[size][size];
        initializeBoard();
        setupGomokuGUI();
    }

    //Initializes Gomoku Game Board
    private void initializeBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = '-';
            }
        }
    }

    //Create GUI for Gomoku Game
    private void setupGomokuGUI() {
        setTitle("GOMOKU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JLabel welcomeLabel = new JLabel("Welcome to Gomoku", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 30));
        add(welcomeLabel, BorderLayout.NORTH);
        
        boardPanel = new JPanel(new GridLayout(size, size));
        buttons = new JButton[size][size];
        
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                buttons[row][col] = new GomokuButton(row, col, board, buttons);
                boardPanel.add(buttons[row][col]);
            }
        }
        
        add(boardPanel, BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}