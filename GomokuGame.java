public class GomokuGame {
	//Current player tracker
	private GomokuPlayer currentPlayer;
	//Creates player 1 and 2 objects
    private GomokuPlayer player1 = new GomokuPlayer();
    private GomokuPlayer player2 = new GomokuPlayer();
    
    //Constructor
    public GomokuGame() {
    	currentPlayer = player1; //Starting w/ player1
    }
    
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
    	return currentPlayer.getCurrentPlayer();
    }
    
    //Switches current player 
    private void switchPlayers() {
    	currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
    
    //Get current player's name
    public String getCurrentPlayerName() {
    	return (currentPlayer == player1) ? "Player 1" : "Player 2";
    }
}
