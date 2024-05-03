public class GomokuPlayer {
    //Instance Variable
	private char currentPlayer = 'O';
	
	public char getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void switchPlayer() {
		currentPlayer = (currentPlayer == 'O') ? 'X' : 'O';
	}
}
