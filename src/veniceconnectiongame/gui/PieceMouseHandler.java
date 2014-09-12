
package veniceconnectiongame.gui;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author towangfoo
 */
public class PieceMouseHandler implements EventHandler<MouseEvent> 
{
    private double origSceneX;
    
    private double origSceneY;
    
    private double origTranslateX;
    
    private double origTranslateY;
    
    private final Piece piece;
    
    public PieceMouseHandler(Piece piece)
    {
        this.piece = piece;
    }

    @Override
    public void handle(MouseEvent t) 
    {
        Node node = piece.getRootNode();
        if(MouseEvent.MOUSE_PRESSED.getName().equals(t.getEventType().getName())) {
            if(t.getButton() == MouseButton.PRIMARY) {
                // left double click - flip sides
                if(t.getClickCount() == 2) {
                    piece.flip();
                } 
                else {
                    // left click - start dragging
                    origSceneX = t.getSceneX();
                    origSceneY = t.getSceneY();
                    origTranslateX = node.getTranslateX();
                    origTranslateY = node.getTranslateY();
                }
            }
            else if(t.getButton() == MouseButton.SECONDARY) {
                // right click - rotate
                node.setRotate(node.getRotate() + 90);
            }
        }
        else if(MouseEvent.MOUSE_DRAGGED.getName().equals(t.getEventType().getName())) {
            double offsetX = t.getSceneX() - origSceneX;
            double offsetY = t.getSceneY() - origSceneY;
            double newTranslateX = origTranslateX + offsetX;
            double newTranslateY = origTranslateY + offsetY;
            
            node.setTranslateX(newTranslateX);
            node.setTranslateY(newTranslateY);
        }
        else if(MouseEvent.MOUSE_RELEASED.getName().equals(t.getEventType().getName())) {
            node.setLayoutX(node.getLayoutX() + node.getTranslateX());
            node.setLayoutY(node.getLayoutY() + node.getTranslateY());
            node.setTranslateX(0);
            node.setTranslateY(0);
        }
        
        t.consume();
    }
}
