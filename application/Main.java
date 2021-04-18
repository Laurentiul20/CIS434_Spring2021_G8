package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
       primaryStage.setTitle("Chess Game");
       primaryStage.getIcons().add(new Image("https://img.icons8.com/dusk/452/chess.png"));
           GridPane root = new GridPane();
           final int size = 8 ;
           for (int row = 0; row < size; row++) {
               for (int col = 0; col < size; col ++) {
                   StackPane square = new StackPane();
                   String color ;
                   if ((row + col) % 2 == 0) {
                       color = "white";
                   } else {
                       color = "saddlebrown";
                   }
                   if (row==1){
                   ImageView pawn = new ImageView(new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_pdt60.png"));
                   pawn.setFitHeight(40);
                   pawn.setFitWidth(50);
                   square.getChildren().addAll(pawn);
                   }
                   if (row==0 && (col==0||col==7)){
                   ImageView rook = new ImageView(new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_rdt60.png"));
                   rook.setFitHeight(40);
                   rook.setFitWidth(50);
                   square.getChildren().addAll(rook);
                   }
                   if (row==0 && (col==1||col==6)){
                   ImageView knight = new ImageView(new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_ndt60.png"));
                   knight.setFitHeight(40);
                   knight.setFitWidth(50);
                   square.getChildren().addAll(knight);
                   }
                   if (row==0 && (col==2||col==5)){
                   ImageView bishop = new ImageView(new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_bdt60.png"));
                   bishop.setFitHeight(40);
                   bishop.setFitWidth(50);
                   square.getChildren().addAll(bishop);
                   }
                   if (row==0 && col==3){
                   ImageView queen = new ImageView(new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_qdt60.png"));
                   queen.setFitHeight(40);
                   queen.setFitWidth(50);
                   square.getChildren().addAll(queen);
                   }
                   if (row==0 && col==4){
                   ImageView king = new ImageView(new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_kdt60.png"));
                   king.setFitHeight(40);
                   king.setFitWidth(50);
                   square.getChildren().addAll(king);
                   }
                   if (row==6){
                   ImageView wpawn = new ImageView(new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_plt60.png"));
                   wpawn.setFitHeight(40);
                   wpawn.setFitWidth(50);
                   square.getChildren().addAll(wpawn);
                   }
                   if (row==7 && (col==0||col==7)){
                   ImageView wrook = new ImageView(new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_rlt60.png"));
                   wrook.setFitHeight(40);
                   wrook.setFitWidth(50);
                   square.getChildren().addAll(wrook);
                   }
                   if (row==7 && (col==1||col==6)){
                   ImageView wknight = new ImageView(new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_nlt60.png"));
                   wknight.setFitHeight(40);
                   wknight.setFitWidth(50);
                   square.getChildren().addAll(wknight);
                   }
                   if (row==7 && (col==2||col==5)){
                   ImageView wbishop = new ImageView(new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_blt60.png"));
                   wbishop.setFitHeight(40);
                   wbishop.setFitWidth(50);
                   square.getChildren().addAll(wbishop);
                   }
                   if (row==7 && col==3){
                   ImageView wqueen = new ImageView(new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_qlt60.png"));
                   wqueen.setFitHeight(40);
                   wqueen.setFitWidth(50);
                   square.getChildren().addAll(wqueen);
                   }
                   if (row==7 && col==4){
                   ImageView wking = new ImageView(new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_klt60.png"));
                   wking.setFitHeight(40);
                   wking.setFitWidth(50);
                   square.getChildren().addAll(wking);
                   }
    
                   square.setStyle("-fx-background-color: "+color+";");
                   root.add(square, col, row);
               }
           }
        for (int i = 0; i < size; i++) {
            root.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            root.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }
        primaryStage.setScene(new Scene(root, 600, 800));
        primaryStage.show();
    }
    
   public static void setBoard(Pieces currentBoard[][]) {
      // This is the class which creates the objects to go with each piece. 
      // The public (?) array currentBoard is an array of Pieces.
      // It represents the current state of the board using common chess
      
      
      // Create the white and black pawns (for loop)
      
      for (int i = 0; i < 8; i++) {
      
         // Pawn constructor for reference: Pawn(boolean color, int ID, int row, int col) 
         // NOTE: ROW NUMBER THEN COLUMN NUMBER. (Y,X) NOT (X,Y).
         // SEE LAYOUT IMAGE FOR INDEXING GUIDE.
         
         // Black pawns: 
         currentBoard[1][i] = new Pawn(false, (10+i), 1, i);
         
         // White pawns:
         currentBoard[6][i] = new Pawn(true, (60+i), 6, i);
         
            
      } // End of for pawn loop.
      
      // Create the white Rooks:
      currentBoard[7][0] = new Rook(true, 70, 7, 0);
      currentBoard[7][7] = new Rook(true, 77, 7, 7);
      
      
      // Create the black Rooks:
      currentBoard[0][0] = new Rook(false, 00, 0, 0);
      currentBoard[0][7] = new Rook(false, 07, 0, 7);
        
      // Create the white Knights:
      currentBoard[7][1] = new Knight(true, 71, 7, 1);
      currentBoard[7][6] = new Knight(true, 76, 7, 6);   
      
      // Create the black Knights: 
      currentBoard[0][1] = new Knight(false, 01, 0, 1);
      currentBoard[0][6] = new Knight(false, 06, 0, 6); 
      
      // Create the white Bishops:
      currentBoard[7][2] = new Bishop(true, 72, 7, 2);
      currentBoard[7][5] = new Bishop(true, 75, 7, 5); 
      
      // Create the black Bishops:
      currentBoard[0][2] = new Bishop(false, 02, 0, 2);
      currentBoard[0][5] = new Bishop(false, 05, 0, 5); 
      
      // Create the white King/Queen:
      currentBoard[7][3] = new Queen(true, 73, 7, 3);
      currentBoard[7][4] = new King(true, 74, 7, 4);
      
      // Create the black King/Queen:
      currentBoard[0][3] = new Queen(false, 03, 0, 3);
      currentBoard[0][4] = new King(false, 04, 0, 4);
      
            // TEST COMMAND LINE PRINT OF BOARD:
        
      for (int i = 0; i < 8; i++) {
         System.out.println("");
         for (int j = 0; j < 8; j++) {
            if (i == 0 || i==1 || i==6 || i==7) {
              System.out.print(currentBoard[i][j].ID);
            }
         }
      }
      
      
      
   } // End of setBoard.

   public static void main(String[] args) {
   
      Pieces currentBoard[][] = new Pieces[8][8];
        
      // Evan's testing:
      King testKing = new King(true, 105, 5, 1);
             
      setBoard(currentBoard);
        
      // END OF TESTING STUFF
        
      launch(args);
        

    }
}