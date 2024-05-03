public class GomokuGame {
	//Creates player 1 and 2 objects
    private GomokuPlayer player1 = new GomokuPlayer();
    private GomokuPlayer player2 = new GomokuPlayer();
    
    //Handles players' turns and checks if the game is over
    public void startGame() {
    	while(!isGameOver()) {
    		char currentPlayerSymbol = getCurrentPlayerSymbol();
    		switchPlayers();
    	}
    }
    
    //Checks for game condition
    private boolean isGameOver() {
    	return false;
    }
    
    //Returns stone for current player
    private char getCurrentPlayerSymbol() {
    	return (player1.getCurrentPlayer() == 'O') ? 'O' : 'X';
    }
    
    //Switches current player from player1 or player2
    private void switchPlayers() {
    	player1.switchPlayer();
    	player2.switchPlayer();
    }
}
