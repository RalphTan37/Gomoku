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
	private JPanel topSpacePanel;
	
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
	
	private void setupGomokuGUI() {
		setTitle("GOMOKU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		topSpacePanel = new JPanel();
	    topSpacePanel.setPreferredSize(new Dimension(400, 50)); 
	    add(topSpacePanel, BorderLayout.NORTH);
	     
	    //Welcome Label
		welcomeLabel = new JLabel("Welcome to Gomoku");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
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
