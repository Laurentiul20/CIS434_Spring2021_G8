package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CustomControl extends Control {
	private ChessBoard chessBoard;
	private StatusBar statusBar; 
	private int statusBarSize = 100;	
	
	public CustomControl(){
		setSkin(new CustomControlSkin(this));
		
		statusBar = new StatusBar();
		chessBoard = new ChessBoard(statusBar);
		getChildren().addAll(statusBar, chessBoard);
		
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				chessBoard.selectPiece(event.getX(), event.getY() - (statusBarSize / 2));
			}
		});
		
		statusBar.getrestartButton().setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				chessBoard.restartGame();
			}
		});	
	}
	
	public void resize(double width, double height){
		super.resize(width, height - statusBarSize);
		chessBoard.setTranslateY(statusBarSize / 2);
		chessBoard.resize(width, height - statusBarSize);
		statusBar.resize(width, statusBarSize);
		statusBar.setTranslateY(-(statusBarSize / 2));
	}
}
