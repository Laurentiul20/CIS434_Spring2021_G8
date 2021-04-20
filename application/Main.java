package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;


public class Main extends Application {
	//create layout
	private StackPane layout;	
   //controls mouse events
	private CustomControl control;
	@Override
	public void init() {
		layout = new StackPane(); 
		control = new CustomControl();
		layout.getChildren().add(control);
	}
	
	@Override
	public void start(Stage primaryStage) {
		// set the title, icon, scene, and stage
		primaryStage.setTitle("Chess game");
      primaryStage.getIcons().add(new Image("https://img.icons8.com/dusk/452/chess.png"));
		primaryStage.setScene(new Scene(layout, 700, 700));
		primaryStage.setMinWidth(400);
		primaryStage.setMinHeight(400);
		primaryStage.show();
	}
   
	public static void main(String[] args) {
			launch(args);
	}	
}
