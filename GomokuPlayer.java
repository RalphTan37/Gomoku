public class GomokuPlayer {
    //Instance Variable
	private char currentPlayer = 'O';
	
	//Returns current player's symbol
	public char getCurrentPlayer() {
		return currentPlayer;
	}
	
	//Changing current player's symbol
	public void switchPlayer() {
		currentPlayer = (currentPlayer == 'O') ? 'X' : 'O';
	}
}
