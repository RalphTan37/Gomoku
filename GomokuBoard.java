import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GomokuBoard extends JFrame {
    private static final int DEFAULT_SIZE = 15;
    private int size;
    private JButton[][] buttons;
    private char[][] board;
    private JPanel boardPanel;

    public GomokuBoard() {
        this.size = DEFAULT_SIZE;
        this.board = new char[size][size];
        initializeBoard();
        setupGomokuGUI();
    }

    private void initializeBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = '-';
            }
        }
    }

    private void setupGomokuGUI() {
        setTitle("GOMOKU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JLabel welcomeLabel = new JLabel("Welcome to Gomoku", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 30));
        add(welcomeLabel, BorderLayout.NORTH);
        
        boardPanel = new JPanel(new GridLayout(size, size));
        buttons = new JButton[size][size];
        
        JButton resetButton = new JButton("Reset board");
        add(resetButton, BorderLayout.SOUTH);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                initializeBoard();
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        buttons[row][col].setText(" ");
                    }
                }
                boardPanel.revalidate();
                boardPanel.repaint();
            }
        });
        
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
