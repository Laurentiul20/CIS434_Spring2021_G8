package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen extends Piece {
	
	private Image image;
	
	public Queen(int type, int xPos, int yPos) {
		super(type, xPos, yPos);
		name = "Queen";
		if(type==1){
			image = new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_qlt60.png");
			imageView.setImage(image);
			imageView.fitHeightProperty();
			imageView.fitWidthProperty();
	      imageView.setPreserveRatio(true);
		}else{
			image = new Image("https://raw.githubusercontent.com/Laurentiul20/CIS434_Spring2021_G8/main/application/Chess%20Pieces%20Images/Chess_qdt60.png");
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
		chessBoard.colorSquare(this.xPos, this.yPos, true);
		int y = this.yPos + 1;
		if (chessBoard.checkState && !this.Save)
			return;
		if (!gameLogic.slashDiagonalProtection(chessBoard, this.xPos, this.yPos, this.type) && !gameLogic.verticalProtection(chessBoard, this.xPos, this.yPos, this.type) && !gameLogic.horizontalProtection(chessBoard, this.xPos, this.yPos, this.type))
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
		if (!gameLogic.backslashDiagonalProtection(chessBoard, this.xPos, this.yPos, this.type) && !gameLogic.verticalProtection(chessBoard, this.xPos, this.yPos, this.type) && !gameLogic.horizontalProtection(chessBoard, this.xPos, this.yPos, this.type))
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
		if (!gameLogic.horizontalProtection(chessBoard, this.xPos, this.yPos, this.type) && !gameLogic.slashDiagonalProtection(chessBoard, this.xPos, this.yPos, this.type) && !gameLogic.backslashDiagonalProtection(chessBoard, this.xPos, this.yPos, this.type))
		{
			for (y = this.yPos - 1; y >= 0; y--)
			{
				if (chessBoard.getBoardPosition(this.xPos, y) == 0)
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, this.xPos, y, this.type))
							chessBoard.colorSquare(this.xPos, y, false);
					}
					else
						chessBoard.colorSquare(this.xPos, y, false);
				}
				else if (chessBoard.getBoardPosition(this.xPos, y) == this.type)
					break;
				else
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, this.xPos, y, this.type))
							chessBoard.colorSquare(this.xPos, y, false);
					}
					else
						chessBoard.colorSquare(this.xPos, y, false);
					break;
				}
			}
			for (y = this.yPos + 1; y < chessBoard.getBoardHeight(); y++)
			{
				if (chessBoard.getBoardPosition(this.xPos, y) == 0)
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, this.xPos, y, this.type))
							chessBoard.colorSquare(this.xPos, y, false);
					}
					else
						chessBoard.colorSquare(this.xPos, y, false);
				}
				else if (chessBoard.getBoardPosition(this.xPos, y) == this.type)
					break;
				else
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, this.xPos, y, this.type))
							chessBoard.colorSquare(this.xPos, y, false);
					}
					else
						chessBoard.colorSquare(this.xPos, y, false);
					break;
				}
			}
		}
		if (!gameLogic.verticalProtection(chessBoard, this.xPos, this.yPos, this.type) && !gameLogic.slashDiagonalProtection(chessBoard, this.xPos, this.yPos, this.type) && !gameLogic.backslashDiagonalProtection(chessBoard, this.xPos, this.yPos, this.type))
		{
			for (int x = this.xPos - 1; x >= 0; x--)
			{
				if (chessBoard.getBoardPosition(x, this.yPos) == 0)
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, x, this.yPos, this.type))
							chessBoard.colorSquare(x, this.yPos, false);
					}
					else
						chessBoard.colorSquare(x, this.yPos, false);
				}
				else if (chessBoard.getBoardPosition(x, this.yPos) == this.type)
					break;
				else
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, x, this.yPos, this.type))
							chessBoard.colorSquare(x, this.yPos, false);
					}
					else
						chessBoard.colorSquare(x, this.yPos, false);
					break;
				}
			}
			for (int x = this.xPos + 1; x < chessBoard.getBoardWidth(); x++)
			{
				if (chessBoard.getBoardPosition(x, this.yPos) == 0)
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, x, this.yPos, this.type))
							chessBoard.colorSquare(x, this.yPos, false);
					}
					else
						chessBoard.colorSquare(x, this.yPos, false);
				}
				else if (chessBoard.getBoardPosition(x, this.yPos) == this.type)
					break;
				else
				{
					if (chessBoard.checkState)
					{
						if (gameLogic.isThisProtecting(chessBoard, x, this.yPos, this.type))
							chessBoard.colorSquare(x, this.yPos, false);
					}
					else
						chessBoard.colorSquare(x, this.yPos, false);
					break;
				}
			}
		}
	}
}
