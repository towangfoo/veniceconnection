
package veniceconnectiongame.gui;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author towangfoo
 */
public class Piece 
{
    private static final int SIZE = 100;
    
    private final StackPane guiRoot;
    
    private final Node sideArc;
    private final Node sideStrait;
    
    private boolean showArcSide = true;

    public Piece(int index)
    {
        guiRoot = new StackPane();
        guiRoot.setMaxSize(SIZE, SIZE);
        guiRoot.setLayoutX(250);
        guiRoot.setLayoutY(250);
        
        // add mouse command handler
        PieceMouseHandler mouseHandler = new PieceMouseHandler(this);
        guiRoot.setOnMousePressed(mouseHandler);
        guiRoot.setOnMouseDragged(mouseHandler);
        guiRoot.setOnMouseReleased(mouseHandler);
        
        Rectangle rect = new Rectangle(SIZE, SIZE);
        rect.setFill(Color.LIGHTGREY);
        rect.setStroke(Color.DARKGREY);
        
        Node shapeArc = this.getCanaleArc();
        Node shapeStrait = this.getCanaleStrait();
        
        sideArc = shapeArc;
        sideStrait = shapeStrait;
        
        // by default - show the arc side
        if(showArcSide)
            showArcSide();
        else
            showStraitSide();
        
        // add the index number in top-left corner
        Text indexLabel = new Text("" + index +".");
        indexLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 10));
        indexLabel.setTranslateX(-1 * (SIZE / 2) + 10);
        indexLabel.setTranslateY(-1 * (SIZE / 2) + 10);
        
        
        guiRoot.getChildren().addAll(rect, shapeArc, shapeStrait, indexLabel);
    }
    
    public Node getRootNode()
    {
        return this.guiRoot;
    }
    
    public void flip()
    {
        if(showArcSide)
            showStraitSide();
        else showArcSide();
        
        showArcSide = !showArcSide;
    }
    
    private void showArcSide()
    {
        sideArc.setVisible(true);
        sideStrait.setVisible(false);
    }
    
    private void showStraitSide()
    {
        sideArc.setVisible(false);
        sideStrait.setVisible(true);
    }
    
    protected final Node getCanaleArc()
    {
        Canvas shapeArc = new Canvas(SIZE, SIZE);
        
        GraphicsContext gc = shapeArc.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(15);
        
        // draw river arc:
        // bottom to center
        gc.strokeLine(SIZE / 2, SIZE, SIZE / 2, SIZE / 2);
        // center to right
        gc.strokeLine(SIZE / 2, SIZE / 2, SIZE, SIZE / 2);
        
        return shapeArc;
    }
    
    protected final Node getCanaleStrait()
    {
        Canvas shapeArc = new Canvas(SIZE, SIZE);
        
        GraphicsContext gc = shapeArc.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(15);
        
        // top to bottom
        gc.strokeLine(SIZE / 2, 0, SIZE / 2, SIZE);
        
        return shapeArc;
    }
    
}
