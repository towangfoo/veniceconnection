
package veniceconnectiongame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author towangfoo
 */
public class GameMove
{
    public static final int PIECES_MIN = 1;
    public static final int PIECES_MAX = 3;
    
    private List<Piece> piecesState;
    
    private List<Piece> piecesAdded;
    
    private Player player;
    
    public GameMove(List<Piece> piecesState, Player player)
    {
        this.piecesState = piecesState;
        piecesAdded = new ArrayList<>();
    }
    
    /**
     * Check if move is valid.
     * 
     * @return boolean 
     */
    public boolean isValid()
    {
        if(piecesAdded.size() < PIECES_MIN) {
            return false;
        }
        if(piecesAdded.size() > PIECES_MAX) {
            return false;
        }
        
        // check for all pieces being in a row and adjacent to each other
        // TODO ...
        
        return true;
    }
}
