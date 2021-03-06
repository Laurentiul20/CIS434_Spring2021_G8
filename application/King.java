package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class King extends Piece{

	private Image image;
	
	public King(int type, int xPos, int yPos) {
		super(type, xPos, yPos);
		name = "King";	
		if(type==1){
			image = new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_klt60.png");
			imageView.setImage(image);
			imageView.fitHeightProperty();
			imageView.fitWidthProperty();
	      imageView.setPreserveRatio(true);
		}
		else{
			image = new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_kdt60.png");
			imageView.setImage(image);
			imageView.fitHeightProperty();
			imageView.fitWidthProperty();
	      imageView.setPreserveRatio(true);
		}
	}
	
	@Override
	public ImageView getImage() {
		return (imageView);
	}
	
	@Override
	public void SelectPiece(ChessBoard chessBoard) {
		int x = this.xPos;
		int y = this.yPos;
		chessBoard.colorSquare(this.xPos, this.yPos, true);
		for (y = this.yPos - 1; y <= this.yPos + 1; y++)
		{
			for (x = this.xPos - 1; x <= this.xPos + 1; x++)
			{
				if(y >= 0 && y < chessBoard.getBoardHeight() && x >= 0 && x < chessBoard.getBoardWidth() && chessBoard.getBoardPosition(x, y) != this.type)
				{
					if (!chessBoard.checkState)
						this.canCastle(chessBoard);
					if (!gameLogic.isCheck(chessBoard, x, y, this.type, true))
						chessBoard.colorSquare(x, y, false);
				}
			}
		}
		
	}
	
	
	public int canCastle(ChessBoard chessBoard){
		int canCastle =0;
		//Black shortCastle
		if(type==2 && this.isFirstTime && chessBoard.getBoardPosition(5, 0) == 0 && chessBoard.getBoardPosition(6, 0) == 0 && chessBoard.getPiece(7, 0) != null && chessBoard.getPiece(7, 0).isFirstTime){
			canCastle = 1;
			chessBoard.colorSquare(7, 0, false);
		}
		//longCastle
		if(type==2 && this.isFirstTime && chessBoard.getBoardPosition(1, 0) == 0 && chessBoard.getBoardPosition(2, 0) == 0 && chessBoard.getBoardPosition(3, 0) == 0 && chessBoard.getPiece(0, 0) != null && chessBoard.getPiece(0, 0).isFirstTime){
			canCastle = 2;
			chessBoard.colorSquare(0, 0, false);
		}
		// White shortCastle 
		if(type==1 && this.isFirstTime && chessBoard.getBoardPosition(5, 7) == 0 && chessBoard.getBoardPosition(6, 7) == 0 && chessBoard.getPiece(7, 7) != null && chessBoard.getPiece(7, 7).isFirstTime){
			canCastle = 3;
			chessBoard.colorSquare(7, 7, false);
		}
		//longCastle
		if(type==1 && this.isFirstTime && chessBoard.getBoardPosition(1, 7) == 0 && chessBoard.getBoardPosition(2, 7) == 0 && chessBoard.getBoardPosition(3, 7) == 0 && chessBoard.getPiece(0, 7) != null && chessBoard.getPiece(0, 7).isFirstTime){
			canCastle = 4;
			chessBoard.colorSquare(0, 7, false);
		}
		return canCastle; 
	}
}
