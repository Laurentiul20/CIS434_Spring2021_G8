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

    public static void main(String[] args) {
        launch(args);
        // Evan's testing:
        King testKing = new King(true, 105, 5, 1);
    }
}