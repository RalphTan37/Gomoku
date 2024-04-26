//Ralph is currently working on this
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GomokuBoard extends JFrame implements ActionListener{
    private JButton [][] board;
    private JLabel statusLabel;
    private int currentPlayer;
    
    public GomokuBoard() 
    {
    	setTitle("Gomoku");
    	
    	board = new JButton[15][15];
    	
    	currentPlayer = 1;
    	JPanel gamePanel = new JPanel(new GridLayout(15,15));
    	for(int i = 0; i < 15; i++)
    	{
    		for(int j = 0; j < 15; j++)
    		{
    			board[i][j] = new JButton();
    			board[i][j].addActionListener(this);
    			gamePanel.add(board[i][j]);
    		}
    	}
    	
    	statusLabel = new JLabel("Turn");
    	add(gamePanel, BorderLayout.CENTER);
    	add(statusLabel, BorderLayout.SOUTH);
    	
    	setSize(500, 500);
    	setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
    	
    }
}
