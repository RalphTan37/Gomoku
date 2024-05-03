public class GomokuGame {
    private GomokuPlayer player1 = new GomokuPlayer();
    private GomokuPlayer player2 = new GomokuPlayer();
    
    public void startGame() {
    	while(!isGameOver()) {
    		char currentPlayerSymbol = getCurrentPlayerSymbol();
    		switchPlayers();
    	}
    }
    
    private boolean isGameOver() {
    	return false;
    }
    
    private char getCurrentPlayerSymbol() {
    	return (player1.getCurrentPlayer() == 'O') ? 'O' : 'X';
    }
    
    private void switchPlayers() {
    	player1.switchPlayer();
    	player2.switchPlayer();
    }
}
