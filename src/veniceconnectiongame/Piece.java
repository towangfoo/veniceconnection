
package veniceconnectiongame;

/**
 *
 * @author towangfoo
 */
public class Piece 
{
    private Piece top;
    private Piece right;
    private Piece bottom;
    private Piece left;
    
    private boolean canaleTop;
    private boolean canaleRight;
    private boolean canaleBottom;
    private boolean canaleLeft;
    
    public Piece(boolean top, boolean right, boolean bottom, boolean left)
    {
        // check that exactly two sides are canale
        int numCanale = 0;
        if(top)
            numCanale ++;
        if(right)
            numCanale ++;
        if(bottom)
            numCanale ++;
        if(left)
            numCanale ++;
        
        if(numCanale != 2) {
            throw new IllegalArgumentException("Expecting exactly two sides of the piece to be canale, but got " + numCanale);
        }
        
        this.canaleTop = top;
        this.canaleRight = right;
        this.canaleBottom = bottom;
        this.canaleLeft = left;
    }
    
    /**
     * Add a piece as neighboring on the top of this piece.
     * @param neighbor
     * @return this
     * @throws IllegalArgumentException when the pieces do not fit together
     * 
     */
    public Piece setTopNeighbor(Piece neighbor)
    {
        // neightbor.bottom must match this.top
        if(neighbor.isCanaleBottom() != this.isCanaleTop()) {
            throw new IllegalArgumentException("pieces do not fit together");
        }
        
        this.top = neighbor;
        return this;
    }
    
    /**
     * Get the piece neighboring on the top side.
     * 
     * @return Piece 
     */
    public Piece getTopNeighbor()
    {
        return this.top;
    }
    
    /**
     * Add a piece as neighboring on the right of this piece.
     * @param neighbor
     * @return this
     * @throws IllegalArgumentException when the pieces do not fit together
     * 
     */
    public Piece setRightNeighbor(Piece neighbor)
    {
        // neightbor.left must match this.right
        if(neighbor.isCanaleLeft() != this.isCanaleRight()) {
            throw new IllegalArgumentException("pieces do not fit together");
        }
        
        this.right = neighbor;
        return this;
    }
    
    /**
     * Get the piece neighboring on the right side.
     * 
     * @return Piece 
     */
    public Piece getRightNeighbor()
    {
        return this.right;
    }
    
    /**
     * Add a piece as neighboring on the bottom of this piece.
     * @param neighbor
     * @return this
     * @throws IllegalArgumentException when the pieces do not fit together
     * 
     */
    public Piece setBottomNeighbor(Piece neighbor)
    {
        // neightbor.left must match this.right
        if(neighbor.isCanaleTop() != this.isCanaleBottom()) {
            throw new IllegalArgumentException("pieces do not fit together");
        }
        
        this.bottom = neighbor;
        return this;
    }
    
    /**
     * Get the piece neighboring on the bottom side.
     * 
     * @return Piece 
     */
    public Piece getBottomNeighbor()
    {
        return this.bottom;
    }
    
    /**
     * Add a piece as neighboring on the left of this piece.
     * @param neighbor
     * @return this
     * @throws IllegalArgumentException when the pieces do not fit together
     * 
     */
    public Piece setLeftNeighbor(Piece neighbor)
    {
        // neightbor.right must match this.left
        if(neighbor.isCanaleRight() != this.isCanaleLeft()) {
            throw new IllegalArgumentException("pieces do not fit together");
        }
        
        this.left = neighbor;
        return this;
    }
    
    /**
     * Get the piece neighboring on the left side.
     * 
     * @return Piece 
     */
    public Piece getLeftNeighbor()
    {
        return this.left;
    }

    public boolean isCanaleTop() {
        return this.canaleTop;
    }

    public boolean isCanaleRight() {
        return this.canaleRight;
    }

    public boolean isCanaleBottom() {
        return this.canaleBottom;
    }

    public boolean isCanaleLeft() {
        return this.canaleLeft;
    }
}
