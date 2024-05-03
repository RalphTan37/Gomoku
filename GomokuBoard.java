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
    private GomokuPlayer currentPlayer;
    private JLabel currentPlayerLabel;

    //Gomoku Constructor
    public GomokuBoard() {
        this.size = DEFAULT_SIZE;
        this.board = new char[size][size];
        initializeBoard();
        currentPlayer = new GomokuPlayer();
        setupGomokuGUI();
    }
    
    //Update current player label
    public void updateCurrentPlayerLabel(String playerName, char playerSymbol) {
    	currentPlayerLabel.setText("Current Turn: " + playerName + " (" + playerSymbol + ")");
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
        
        //Creates a Label the welcomes the user
        JLabel welcomeLabel = new JLabel("Welcome To Gomoku", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));

        //Panel to hold welcome label
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.add(welcomeLabel, BorderLayout.NORTH);
        
        //Adds welcome panel to the frame
        add(welcomePanel, BorderLayout.NORTH);
        
        //Creates Current Player Label
        currentPlayerLabel = new JLabel("Current Turn: Player 1 (O)", SwingConstants.CENTER);
        currentPlayerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        //Creates reset button
        JButton resetButton = new JButton("Reset Board");
        resetButton.addActionListener(e ->{
        	initializeBoard(); //clears board
        	currentPlayerLabel.setText("Current Turn: Player 1 (O)");
        	for (int row = 0; row < size; row++) {
        		for (int col = 0; col < size; col++) {
        			buttons[row][col].setText(" ");
        		}
        	}
        });
        
        //Bottom Space Panel 
        bottomSpacePanel = new JPanel();
        bottomSpacePanel.setPreferredSize(new Dimension(400, 50));
        bottomSpacePanel.add(resetButton);
        add(bottomSpacePanel, BorderLayout.SOUTH);

        //Left Space Panel
        leftSpacePanel = new JPanel();
        leftSpacePanel.setPreferredSize(new Dimension(50, 400));
        add(leftSpacePanel, BorderLayout.WEST);

        //Right Space Panel
        rightSpacePanel = new JPanel();
        rightSpacePanel.setPreferredSize(new Dimension(50, 400));
        add(rightSpacePanel, BorderLayout.EAST);

        //Creates boardPanel with GridLayout
        boardPanel = new JPanel(new GridLayout(size, size));
        buttons = new JButton[size][size];
        
        //Creates and Places Buttons
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                buttons[row][col] = new GomokuButton(row, col, board, buttons, currentPlayer);
                buttons[row][col].setBackground(new Color(238, 238, 210));
                boardPanel.add(buttons[row][col]);
            }
        }
        
        //Positions Gomoku Board in the center of JFrame
        add(boardPanel, BorderLayout.CENTER);
        
        //Adds current player label to welcome panel
        welcomePanel.add(currentPlayerLabel, BorderLayout.SOUTH);
        
        //Methods Settings up the Window
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}