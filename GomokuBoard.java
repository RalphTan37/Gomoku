import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

public class GomokuBoard extends JFrame {
	//Instance Variables
    private static final int DEFAULT_SIZE = 15;
    private int size;
    private JButton[][] buttons;
    private char[][] board;
    private JPanel boardPanel;
    private JPanel bottomSpacePanel;
    private JPanel leftSpacePanel;
    private JPanel rightSpacePanel;
    
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
        setTitle("Gomoku - Build a Row of Five!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        //Bottom Space Panel 
        bottomSpacePanel = new JPanel();
        bottomSpacePanel.setPreferredSize(new Dimension(400, 50));
        add(bottomSpacePanel, BorderLayout.SOUTH);
        
        //Left Space Panel
        leftSpacePanel = new JPanel();
        leftSpacePanel.setPreferredSize(new Dimension(50, 400));
        add(leftSpacePanel, BorderLayout.WEST);

        //Right Space Panel
        rightSpacePanel = new JPanel();
        rightSpacePanel.setPreferredSize(new Dimension(50, 400));
        add(rightSpacePanel, BorderLayout.EAST);
        
        //Creates a Label the welcomes the user
        JLabel welcomeLabel = new JLabel("Welcome to Gomoku", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 30));
        add(welcomeLabel, BorderLayout.NORTH);
        
        //Creates boardPanel with GridLayout
        boardPanel = new JPanel(new GridLayout(size, size));
        buttons = new JButton[size][size];

        //Creates and Places Buttons
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                buttons[row][col] = new GomokuButton(row, col, board, buttons);
                buttons[row][col].setBackground(new Color(238, 238, 210));
                boardPanel.add(buttons[row][col]);
            }
        }
        
        //Positions Gomoku Board in the center of JFrame
        add(boardPanel, BorderLayout.CENTER);
        
        //Window is set to maximum (fullscreen)
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //Methods Settings up the Window
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}