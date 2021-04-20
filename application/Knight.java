package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Knight extends Piece{

	private Image image;
	
	public Knight(int type, int xPos, int yPos) {
		super(type, xPos, yPos);
		name = "Knight";
		if(type==1){
			image = new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_nlt60.png");
			imageView.setImage(image);
			imageView.fitHeightProperty();
			imageView.fitWidthProperty();
	      imageView.setPreserveRatio(true);
		}else{
			image = new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_ndt60.png");
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
		int x = 0;
		chessBoard.colorSquare(this.xPos, this.yPos, true);
		if (chessBoard.checkState && !this.Save)
			return;
		if (gameLogic.verticalProtection(chessBoard, this.xPos, this.yPos, this.type) || gameLogic.horizontalProtection(chessBoard, this.xPos, this.yPos, this.type) || 
			gameLogic.slashDiagonalProtection(chessBoard, this.xPos, this.yPos, this.type) || gameLogic.backslashDiagonalProtection(chessBoard, this.xPos, this.yPos, this.type))
			return;
		for (int y = -2; y <= 2; y++)
		{
			if (y != 0)
			{
				x = y % 2 == 0 ? 1 : 2;
				if (this.yPos + y >= 0 && this.yPos + y < chessBoard.getBoardHeight() && this.xPos - x >= 0 && this.xPos - x < chessBoard.getBoardWidth() && chessBoard.getBoardPosition(this.xPos - x, this.yPos + y) != this.type)
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, this.xPos - x, this.yPos + y, this.type))
							chessBoard.colorSquare(this.xPos - x, this.yPos + y, false);
					}
					else
						chessBoard.colorSquare(this.xPos - x, this.yPos + y, false);
				}
				if (this.yPos + y >= 0 && this.yPos + y < chessBoard.getBoardHeight() && this.xPos + x >= 0 && this.xPos + x < chessBoard.getBoardWidth() && chessBoard.getBoardPosition(this.xPos + x, this.yPos + y) != this.type)
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, this.xPos + x, this.yPos + y, this.type))
							chessBoard.colorSquare(this.xPos + x, this.yPos + y, false);
					}
					else
						chessBoard.colorSquare(this.xPos + x, this.yPos + y, false);
				}
			}
		}
	}	
}
