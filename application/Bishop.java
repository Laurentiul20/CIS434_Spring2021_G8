package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bishop extends Piece{

	private Image image;

	public Bishop(int type, int xPos, int yPos) {
		super(type, xPos, yPos);
		name = "Bishop";
		if(type==1){
			image = new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_blt60.png");
			imageView.setImage(image);
			imageView.fitHeightProperty();
			imageView.fitWidthProperty();
	      imageView.setPreserveRatio(true);
		}
		else{
			image = new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_bdt60.png");
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
		int y = this.yPos + 1;
		chessBoard.colorSquare(this.xPos, this.yPos, true);
		if (chessBoard.checkState && !this.Save)
			return;
		if (gameLogic.horizontalProtection(chessBoard, this.xPos, this.yPos, this.type) || gameLogic.verticalProtection(chessBoard, this.xPos, this.yPos, this.type))
			return;
		if (!gameLogic.slashDiagonalProtection(chessBoard, this.xPos, this.yPos, this.type))
		{
			for(int x = this.xPos + 1; x < chessBoard.getBoardWidth() && y < chessBoard.getBoardHeight(); x++, y++)
			{
				if (chessBoard.getBoardPosition(x, y) == 0)
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, x, y, this.type))
							chessBoard.colorSquare(x, y, false);
					}
					else
						chessBoard.colorSquare(x, y, false);
				}
				else if (chessBoard.getBoardPosition(x, y) == this.type)
					break;
				else
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, x, y, this.type))
							chessBoard.colorSquare(x, y, false);
					}
					else
						chessBoard.colorSquare(x, y, false);
					break;
				}
			}
			y = this.yPos - 1;
			for(int x = this.xPos - 1; x >= 0 && y >= 0; x--, y--)
			{
				if (chessBoard.getBoardPosition(x, y) == 0)
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, x, y, this.type))
							chessBoard.colorSquare(x, y, false);
					}
					else
						chessBoard.colorSquare(x, y, false);
				}
				else if (chessBoard.getBoardPosition(x, y) == this.type)
					break;
				else
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, x, y, this.type))
							chessBoard.colorSquare(x, y, false);
					}
					else
						chessBoard.colorSquare(x, y, false);
					break;
				}
			}
		}
		if (!gameLogic.backslashDiagonalProtection(chessBoard, this.xPos, this.yPos, this.type))
		{
			y = this.yPos + 1;
			for (int x = this.xPos - 1; x >= 0 && y < chessBoard.getBoardHeight(); x--, y++)
			{
				if (chessBoard.getBoardPosition(x, y) == 0)
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, x, y, this.type))
							chessBoard.colorSquare(x, y, false);
					}
					else
						chessBoard.colorSquare(x, y, false);
				}
				else if (chessBoard.getBoardPosition(x, y) == this.type)
					break;
				else
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, x, y, this.type))
							chessBoard.colorSquare(x, y, false);
					}
					else
						chessBoard.colorSquare(x, y, false);
					break;
				}
			}
			y = this.yPos - 1;
			for (int x = this.xPos + 1; x < chessBoard.getBoardWidth() && y >= 0; x++, y--)
			{
				if (chessBoard.getBoardPosition(x, y) == 0)
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, x, y, this.type))
							chessBoard.colorSquare(x, y, false);
					}
					else
						chessBoard.colorSquare(x, y, false);
				}
				else if (chessBoard.getBoardPosition(x, y) == this.type)
					break;
				else
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, x, y, this.type))
							chessBoard.colorSquare(x, y, false);
					}
					else
						chessBoard.colorSquare(x, y, false);
					break;
				}
			}
		}
	}
}
