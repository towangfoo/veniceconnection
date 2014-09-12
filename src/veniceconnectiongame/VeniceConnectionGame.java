
package veniceconnectiongame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author towangfoo
 */
public class VeniceConnectionGame implements Runnable
{
    public static final int NUM_PIECES = 16;
    
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    
    private List<Piece> piecesPlayed;

    public VeniceConnectionGame() 
    {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
    }
    
    @Override
    public void run()
    {
        startGame();
    }
    
    public void startGame()
    {        
        // reset the board
        piecesPlayed = new ArrayList<>();
        
        // decide who starts
        currentPlayer = player1;
        
        // main game loop
        System.out.println("entering game loop");
        while(!hasMetEndCondition()) {
            waitForPlayerMove();
            switchPlayer();
        }
        
        System.out.println("game has ended");
    }
    
    public boolean hasMetEndCondition()
    {
        if(isCircuitClosed()) {
            System.out.println("canale circuit is closed");
            System.out.println(currentPlayer.name + " won");
            return true;
        }
        else if(piecesPlayed.size() == NUM_PIECES) {
            // no more pieces - other player won
            System.out.println("no pieces left");
            if(currentPlayer == player1)
                System.out.println(player2.name + " won");
            else
                System.out.println(player1.name + " won");
            return true;
        }
        
        return false;
    }
    
    /**
     * Check whether the canale circuit is closed current pieces.
     * 
     * @return boolean 
     */
    public boolean isCircuitClosed() 
    {
        // check for any piece with an open canale ending
        for (Piece p : piecesPlayed) {
            if(p.isCanaleTop() && p.getTopNeighbor() == null)
                return false;
            else if(p.isCanaleRight() && p.getRightNeighbor() == null)
                return false;
            else if(p.isCanaleBottom() && p.getBottomNeighbor() == null)
                return false;
            else if(p.isCanaleLeft() && p.getLeftNeighbor() == null)
                return false;
        }
        
        return true;
    }
    
    /**
     * Wait for a player move to come in, validate and execute it.
     */
    private void waitForPlayerMove()
    {
        GameMove move = null;
        // get a valid move
        do {
//            move = getGameMove();
            try {Thread.sleep(100);} catch (InterruptedException e) {}
        } while (move == null || !move.isValid());
        
        
    }
    
    /**
     * Switch the current player.
     */
    private void switchPlayer()
    {
        if(currentPlayer == player1) 
            currentPlayer = player2;
        else
            currentPlayer = player1;
    }
}
