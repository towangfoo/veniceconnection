
package veniceconnectiongame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author towangfoo
 */
public class GameGui extends Application
{
    
    /**
     * The game board, where the pieces are layed out
     */
    private Pane board;
    
    private Label lbl_NumPieces;
    
    /**
     * Count the number of pieces drawn
     */
    private int piecesDrawn;
    
    @Override
    public void start(Stage primaryStage) {
        prepareScene(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    protected void prepareScene(Stage primaryStage)
    {
        piecesDrawn = 0;
        
        // the area for pieces
        board = new Pane();
        
        // add double click listener to add a piece
        board.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if(t.getTarget().equals(board)) {
                    if(t.getButton().equals(MouseButton.PRIMARY)) {
                        if(t.getClickCount() == 2) {
                            renderPiece();
                        }
                    }
                }
            }
        
        });
        
        // the info area
        VBox info = new VBox();
        prepareInfoArea(info);
        
        // the root layout container
        BorderPane root = new BorderPane();
        root.setCenter(board);
        root.setRight(info);
        
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Venice Connection v0.1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void renderPiece() 
    {        
        veniceconnectiongame.gui.Piece piece = new veniceconnectiongame.gui.Piece(piecesDrawn);
        board.getChildren().add(piece.getRootNode());
        piecesDrawn ++;
        
        // update visual counter
        lbl_NumPieces.setText("Pieces: " + piecesDrawn);
    }
    
    private void prepareInfoArea(VBox container)
    {
        container.setPadding(new Insets(10));
        container.setSpacing(8);

        Text title = new Text("Info and Controls");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        container.getChildren().add(title);
        
        Button bt_addPiece = new Button("Add piece");
        bt_addPiece.setOnAction(new EventHandler<ActionEvent>()
        {    
            @Override
            public void handle(ActionEvent t)
            {
                renderPiece();
            }
        });
        container.getChildren().add(bt_addPiece);
        
        Label labelNumPieces = new Label("Pieces: " + piecesDrawn);
        labelNumPieces.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        container.getChildren().add(labelNumPieces);
        lbl_NumPieces = labelNumPieces;
        
        Button bt_commitTurn = new Button("Commit turn");
        bt_commitTurn.setOnAction(new EventHandler<ActionEvent>()
        {    
            @Override
            public void handle(ActionEvent t)
            {
                System.out.println("TODO: Validate and commit turn");
            }
        });
        container.getChildren().add(bt_commitTurn);
    }
}
