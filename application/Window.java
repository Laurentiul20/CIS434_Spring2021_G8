package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.transform.Translate;

public class Window extends Group{

		public Window(int i) {
			pos = new Translate();
			rectangle = new Rectangle();
			rectangle.getTransforms().add(pos);
			if(i==0)
			rectangle.setFill(Color.SADDLEBROWN);
			else
			rectangle.setFill(Color.WHITE);
			getChildren().add(rectangle);
		}

		@Override
		public void resize(double width, double height) {
			super.resize(width, height);
			rectangle.setHeight(height);
			rectangle.setWidth(width);
		}

		@Override
		public void relocate(double x, double y) {
			super.relocate(x, y);
			pos.setX(x);
			pos.setY(y);
		}
		
		public void highlightWindow(Color color) {
			rectangle.setStrokeType(StrokeType.INSIDE);
			rectangle.setStrokeWidth(4);
			rectangle.setStroke(color);
			if (color == Color.ORANGE)
				isHighlighted = true;
		}

		public void unhighlight() {
			rectangle.setStroke(null);
			isHighlighted = false;
		}
		
		public boolean isHighlighted() {
			return (isHighlighted);
		}
		
		public Rectangle getRectangle() {
			return (rectangle);
		}
		private Rectangle rectangle;
		private Translate pos;
		private boolean isHighlighted = false;
}
