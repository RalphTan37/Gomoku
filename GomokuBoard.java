//Ralph is currently working on this
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GomokuBoard extends JFrame {
   //Instance Variables
	private static final int DEFAULT_SIZE = 15;
	private int size;
	private JButton[][] buttons;
	private char[][] board;
	private JPanel boardPanel;
	private JLabel welcomeLabel;
	private JPanel spacePanel1;
	private JPanel spacePanel2;
	private JPanel spacePanel3;
	private JPanel spacePanel4;
	
	public void GomokuGUI() {
		this.size = DEFAULT_SIZE;
		this.board = new char[size][size];
		initializeBoard();
		setupGomokuGUI();
	}
	
	private void initializeBoard() {
		for (int row = 0; row < size; row++)
		{
			for (int col = 0; col < size; col++) {
				board[row][col] = '-';
			}
		}
	}
	
	//Gomoku GUI
	private void setupGomokuGUI() {
		setTitle("GOMOKU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		spacePanel1 = new JPanel();
	    spacePanel1.setPreferredSize(new Dimension(400, 100)); 
	    add(spacePanel1, BorderLayout.NORTH);
	    
	    spacePanel2 = new JPanel();
	    spacePanel2.setPreferredSize(new Dimension(50, 400));
	    add(spacePanel2, BorderLayout.EAST);
	    
	    spacePanel3 = new JPanel();
	    spacePanel3.setPreferredSize(new Dimension(50, 400));
	    add(spacePanel3, BorderLayout.WEST);
	    
	    spacePanel4 = new JPanel();
	    spacePanel4.setPreferredSize(new Dimension (400,50));
	    add(spacePanel4, BorderLayout.SOUTH);
	     
	    //Welcome Label
		welcomeLabel = new JLabel("Welcome to Gomoku");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Serif", Font.BOLD, 30));
		add(welcomeLabel, BorderLayout.NORTH);
		
		//Gomoku Board
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(size, size));
		
		buttons = new JButton[size][size];
		
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				JButton button = new JButton();
				button.setPreferredSize(new Dimension(50, 50));
				button.addActionListener(new ButtonClickListener(row, col));
				buttons[row][col] = button;
				boardPanel.add(button);
			}
		}
		
		add(boardPanel, BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class ButtonClickListener implements ActionListener{
		private int row;
		private int col;
		
		public ButtonClickListener(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (board[row][col] == '-') {
				board[row][col] = 'X';
				buttons[row][col].setText("X");
			}
		}
	}
}
