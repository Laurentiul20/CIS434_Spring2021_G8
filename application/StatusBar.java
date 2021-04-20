package application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;

public class StatusBar extends HBox{

	private Button restartButton;
	public Label whitePlayerAlert;
	public Label blackPlayerAlert;
	public Label whitePlayerAlert2;
	public Label blackPlayerAlert2;
	public Label winner;
	private GridPane statusBarGp;
   
	public StatusBar(){
		statusBarGp = new GridPane();
		restartButton = new Button("restart");
		whitePlayerAlert = new Label("");
		blackPlayerAlert = new Label("");
		whitePlayerAlert2 = new Label("");
		blackPlayerAlert2 = new Label("");
		winner = new Label("");

		ColumnConstraints column = new ColumnConstraints();
		column.setPercentWidth(30);
		statusBarGp.getColumnConstraints().add(column);
		column = new ColumnConstraints();
		column.setPercentWidth(30);
		statusBarGp.getColumnConstraints().add(column);
		column = new ColumnConstraints();
		column.setPercentWidth(30);
		statusBarGp.getColumnConstraints().add(column);
		statusBarGp.setPrefSize(2000, 100);
		statusBarGp.getRowConstraints().add(new RowConstraints(70/2));
		statusBarGp.getRowConstraints().add(new RowConstraints(70/2));
		statusBarGp.addRow(0, whitePlayerAlert, restartButton, blackPlayerAlert);
		statusBarGp.addRow(1, whitePlayerAlert2, winner, blackPlayerAlert2);
		for (Node n: statusBarGp.getChildren()) {
			GridPane.setHalignment(n, HPos.CENTER);
			GridPane.setValignment(n, VPos.CENTER);
			if (n instanceof Label) {
				n.setStyle("-fx-font-size: 10pt; -fx-font-weight: bold; -fx-opacity: 1.0;");
			}
		}
		statusBarGp.setVgap(10);
		statusBarGp.setHgap(10);
		statusBarGp.setPadding(new Insets(10, 10, 10, 10));
		
		statusBarGp.setStyle("-fx-background-color: lightgreen; -fx-effect: innershadow(gaussian, rgba(0,0,0,0.5), 80, 0.5, 0, 10);");
		statusBarGp.setSnapToPixel(false);		
		getChildren().add(statusBarGp);
	}
	
	public void resize(double width, double height){
		super.resize(width, height); 
		setWidth(width);
		setHeight(height);
	}

	public Button getrestartButton() {
		return restartButton;
	}

	public void setrestartButton(Button restartButton) {
		this.restartButton = restartButton;
	}	
}
