package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessBoard extends Pane {

	public ChessBoard(StatusBar newStatusBar) {
		statusBar = newStatusBar;
		statusBar.whitePlayerAlert.setText("Turn: White Player");
		statusBar.blackPlayerAlert.setText("");
      
		board = new int[boardWidth][boardHeight];
		pieces = new Piece[boardWidth][boardHeight];
		windows = new Window[boardWidth][boardHeight];
      
      background = new Rectangle();
		background.setFill(Color.WHITE);
		getChildren().add(background);

		// for loop to fill all arrays to default values
		for (int i = 0; i < 8; i++) {
			if(i%2 == 0 || i ==0){
				isBlack =false;
			}
			else 
				isBlack = true;
			for (int j = 0; j < 8; j++) {
				board[i][j] = EMPTY;
				if(isBlack){
					windows[i][j] = new Window(0);
					isBlack=false;
				}else{
					windows[i][j] = new Window(1); 
					isBlack = true; 
				}
				getChildren().add(windows[i][j]);
			}
		}

		// set first player to white
		current_player = PlayerWhite;
		initializePiece();
	}
		
	public void initializePiece()
	{
		/* Place pieces on the board 
      black peieces*/
		rook21 = new Rook(2, 0, 0); 
		knight21 = new Knight(2, 1, 0);
		bishop21 = new Bishop(2, 2, 0);
		queen2 = new Queen(2, 3, 0); 
		king2 = new King(2, 4, 0);
		bishop22 = new Bishop(2, 5, 0);
		knight22 = new Knight(2, 6, 0);
		rook22 = new Rook(2, 7, 0);
		pawn21 = new Pawn(2, 0, 1);
		pawn22 = new Pawn(2, 1, 1);
		pawn23 = new Pawn(2, 2, 1);
		pawn24 = new Pawn(2, 3, 1);
		pawn25 = new Pawn(2, 4, 1);
		pawn26 = new Pawn(2, 5, 1);
		pawn27 = new Pawn(2, 6, 1);
		pawn28 = new Pawn(2, 7, 1);
		
		//white pieces
		rook11 = new Rook(1, 0, 7); 
		knight11 = new Knight(1, 1, 7);
		bishop11 = new Bishop(1, 2, 7);
		queen1 = new Queen(1, 3, 7);
		king1 = new King(1, 4, 7);
		bishop12 = new Bishop(1, 5, 7);
		knight12 = new Knight(1, 6, 7);
		rook12 = new Rook(1, 7, 7);
		pawn11 = new Pawn(1, 0, 6);
		pawn12 = new Pawn(1, 1, 6);
		pawn13 = new Pawn(1, 2, 6);
		pawn14 = new Pawn(1, 3, 6);
		pawn15 = new Pawn(1, 4, 6);
		pawn16 = new Pawn(1, 5, 6);
		pawn17 = new Pawn(1, 6, 6);
		pawn18 = new Pawn(1, 7, 6);
		
		pieces[0][0] = rook21;
		pieces[1][0] = knight21;
		pieces[2][0] = bishop21;
		pieces[3][0] = queen2;
		pieces[4][0] = king2;
		pieces[5][0] = bishop22;
		pieces[6][0] = knight22;
		pieces[7][0] = rook22;
		
		pieces[0][1] = pawn21;
		pieces[1][1] = pawn22;
		pieces[2][1] = pawn23;
		pieces[3][1] = pawn24;
		pieces[4][1] = pawn25;
		pieces[5][1] = pawn26;
		pieces[6][1] = pawn27;
		pieces[7][1] = pawn28;
		
		for (int y = 2; y < 6; y++)
		{
			for (int x = 0; x < boardWidth; x++)
			{
				pieces[x][y] = null;
			}
		}
		
		pieces[0][6] = pawn11;
		pieces[1][6] = pawn12;
		pieces[2][6] = pawn13;
		pieces[3][6] = pawn14;
		pieces[4][6] = pawn15;
		pieces[5][6] = pawn16;
		pieces[6][6] = pawn17;
		pieces[7][6] = pawn18;

		pieces[0][7] = rook11;
		pieces[1][7] = knight11;
		pieces[2][7] = bishop11;
		pieces[3][7] = queen1;
		pieces[4][7] = king1;
		pieces[5][7] = bishop12;
		pieces[6][7] = knight12;
		pieces[7][7] = rook12;
		
		for (int y = 0; y < boardHeight; y++)
		{
			for (int x = 0; x < boardWidth; x++)
			{
				if (y == 0 || y == 1)
					board[x][y] = 2;
				else if (y == 6 || y == 7)
					board[x][y] = 1;
				else
					board[x][y] = 0;
			}
		}

		for(int i = 0; i < 8; i++){
			getChildren().addAll(pieces[i][0].getImage(), pieces[i][1].getImage(), pieces[i][6].getImage(), pieces[i][7].getImage());
		}
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);

		background.setWidth(width);
		background.setHeight(height);

		cell_width = width / 8.0;
		cell_height = height / 8.0;

		// restart the sizes and positions of all pieces and update the position of the windows
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] != 0) {
					pieces[i][j].relocate(i * cell_width, j * cell_height);
					pieces[i][j].resize(cell_width, cell_height);
				}
				windows[i][j].relocate(i * cell_width, j * cell_height);
				windows[i][j].resize(cell_width, cell_height);
			}
		}
	}
   
	public void restartGame() {
   	playerOneRook = 2;
		playerOneBishopLightSquare = 1;
		playerOneBishopDarkSquare = 1;
		playerOneKnight = 2;
		playerOneQueen = 1;
		playerOnePawn = 8;
		playerTwoRook = 2;
		playerTwoBishopLightSquare = 1;
		playerTwoBishopDarkSquare = 1;
		playerTwoKnight = 2;
		playerTwoQueen = 1;
		playerTwoPawn = 8;
   	unhighlightWindow();
		statusBar.whitePlayerAlert.setText("Turn: White Player");
		statusBar.blackPlayerAlert.setText("");
		statusBar.winner.setText("");
		checkmate = false;
		checkState = false;
		stalemate = false;
		selectedPiece = null;
		checkPieces.clear();
		saviorPieces.clear();
      
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = 0;
				if (pieces[i][j] != null)
					getChildren().remove(pieces[i][j].getImage());
				getChildren().remove(pieces[i][j]);
				pieces[i][j] = null;
			}
		}
		current_player = PlayerWhite;
		initializePiece();
		for(int i = 0; i < 8; i++){
			pieces[i][0].restartPiece();
			pieces[i][1].restartPiece();
			pieces[i][6].restartPiece();
			pieces[i][7].restartPiece();
		}

	}
	
	public void selectPiece(final double x, final double y){
		int indexX = (int) (x/ cell_width);
		int indexY = (int) (y/ cell_height);
		
		if (!checkmate && !stalemate)
		{
			if (windows[indexX][indexY].isHighlighted())
			{
				movePiece(x, y);
				unhighlightWindow();
				selectedPiece = null;
			}
			else
			{
				//condition if the king is in check
				if(board[indexX][indexY] == current_player){
					unhighlightWindow();
					pieces[indexX][indexY].SelectPiece(this);
					selectedPiece = pieces[indexX][indexY];
				}
			}
		}
	}
	
	public void movePiece(final double x, final double y){
		int indexX = (int) (x/ cell_width);
		int indexY = (int) (y/ cell_height);
		
		// check for legal moves
		selectedPiece.MovePiece(this, indexX, indexY);
		selectedPiece.setFirstTime(false);
		// change the player
		if (current_player == PlayerWhite)
		{
			current_player = PlayerBlack;
			statusBar.whitePlayerAlert.setText("");
			checkState = false;
			for(Iterator<Piece> piece = saviorPieces.iterator(); piece.hasNext(); ) {
			    Piece item = piece.next();
			    item.Save = false;
			}
			if (gameLogic.isCheck(this, king2.xPos, king2.yPos, current_player, true))
			{
				checkPieces.clear();
				saviorPieces.clear();
				checkState = true;
				gameLogic.findAllCheckPieces(this, king2.xPos, king2.yPos, current_player);
				if (gameLogic.isCheckmate(this, king2.xPos, king2.yPos, current_player))
				{
					checkmate = true;
					statusBar.blackPlayerAlert.setText("Black king checkmate");
					statusBar.winner.setText("White player won !");
				}
				else
					statusBar.blackPlayerAlert.setText("Black king check");
			}
			else if (gameLogic.isStalemate(this, king2, current_player))
				statusBar.winner.setText("Stalemate !");
			else
				statusBar.blackPlayerAlert.setText("Turn: Black Player");
		}
		else
		{
			current_player = PlayerWhite;
			statusBar.blackPlayerAlert.setText("");
			checkState = false;
			for(Iterator<Piece> piece = saviorPieces.iterator(); piece.hasNext(); ) {
			    Piece item = piece.next();
			    item.Save = false;
			}
			if (gameLogic.isCheck(this, king1.xPos, king1.yPos, current_player, true))
			{
				checkPieces.clear();
				saviorPieces.clear();
				checkState = true;
				gameLogic.findAllCheckPieces(this, king1.xPos, king1.yPos, current_player);
				if (gameLogic.isCheckmate(this, king1.xPos, king1.yPos, current_player))
				{
					checkmate = true;
					statusBar.whitePlayerAlert.setText("White king checkmate");
					statusBar.winner.setText("Black player won !");
				}
				else
					statusBar.whitePlayerAlert.setText("White king check");
			}
			else if (gameLogic.isStalemate(this, king1, current_player))
				statusBar.winner.setText("Stalemate !");
			else
				statusBar.whitePlayerAlert.setText("Turn: White Player");
		}
	}
	
	public void createPromotePiece(Piece piece)
	{
		Piece promotedPiece;
		        
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Promote piece");
		alert.setHeaderText("Promote the pawn into another piece");
		alert.setContentText("Choose one of pieces");

		ButtonType buttonRook = new ButtonType("Rook");
		ButtonType buttonKnight = new ButtonType("Knight");
		ButtonType buttonBishop = new ButtonType("Bishop");
		ButtonType buttonQueen = new ButtonType("Queen");

		alert.getButtonTypes().setAll(buttonRook, buttonKnight, buttonBishop, buttonQueen);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonRook){
			promotedPiece = new Rook(piece.type, piece.xPos, piece.yPos);
			getChildren().remove(piece.getImage());
			getChildren().add(promotedPiece.getImage());
			pieces[piece.xPos][piece.yPos] = promotedPiece;
			if (piece.type == 1)
				playerOneRook++;
			else
				playerTwoRook++;
		}
		else if (result.get() == buttonKnight) {
			promotedPiece = new Knight(piece.type, piece.xPos, piece.yPos);
			getChildren().remove(piece.getImage());
			getChildren().add(promotedPiece.getImage());
			pieces[piece.xPos][piece.yPos] = promotedPiece;
			if (piece.type == 1)
				playerOneKnight++;
			else
				playerTwoKnight++;
		}
		else if (result.get() == buttonBishop) {
			promotedPiece = new Bishop(piece.type, piece.xPos, piece.yPos);
			getChildren().remove(piece.getImage());
			getChildren().add(promotedPiece.getImage());
			pieces[piece.xPos][piece.yPos] = promotedPiece;
			if (piece.type == 1)
			{
				if ((piece.xPos + piece.yPos) % 2 != 0)
					playerOneBishopDarkSquare++;
				else
					playerOneBishopLightSquare++;
			}
			else
			{
				if ((piece.xPos + piece.yPos) % 2 == 0)
					playerTwoBishopLightSquare++;
				else
					playerTwoBishopDarkSquare++;
			}
		}
		else if (result.get() == buttonQueen) {
			promotedPiece = new Queen(piece.type, piece.xPos, piece.yPos);
			getChildren().remove(piece.getImage());
			getChildren().add(promotedPiece.getImage());
			pieces[piece.xPos][piece.yPos] = promotedPiece;
			if (piece.type == 1)
				playerOneQueen++;
			else
				playerTwoQueen++;
		}
	}
	
	public void colorSquare(int x, int y, boolean selectedPiece) {
		if (selectedPiece)
			windows[x][y].highlightWindow(Color.RED);
		else
			windows[x][y].highlightWindow(Color.ORANGE);			
	}
	
	public void unhighlightWindow()
	{
		for (int y = 0; y < boardHeight; y++)
		{
			for (int x = 0; x < boardWidth; x++)
			{
				if (windows[x][y].getRectangle().getStroke() != null)
					windows[x][y].unhighlight();
			}
		}
	}
	
	
	public Piece getKing(int type)
	{
		if (type == 1)
			return (king1);
		return (king2);
	}

	public int getBoardHeight()
	{
		return (this.boardHeight);
	}
	
	public int getBoardWidth()
	{
		return (this.boardWidth);
	}
	
	public int getBoardPosition(int x, int y)
	{
		return (this.board[x][y]);
	}
	
	public void setBoard(int x, int y, int type)
	{
		this.board[x][y] = type;
	}
	
	public Piece getPiece(int x, int y)
	{
		return (pieces[x][y]);
	}
	
	public void setPiece(int x, int y, Piece piece)
	{
		this.pieces[x][y] = piece;
	}
	
	public StatusBar getStatusBar()
	{
		return (statusBar);
	}
	
   // private fields
	private int boardWidth = 8;
	private int boardHeight = 8;
	private int[][] board;

	private Piece[][] pieces;
	private Window[][] windows;

	private Rook rook21; 
	private Knight knight21;
	private Bishop bishop21;
	private Queen queen2; 
	private King king2; 
	private Bishop bishop22;
	private Knight knight22;
	private Rook rook22;
	private Pawn pawn21;
	private Pawn pawn22;
	private Pawn pawn23;
	private Pawn pawn24;
	private Pawn pawn25;
	private Pawn pawn26;
	private Pawn pawn27;
	private Pawn pawn28;
	
	private Rook rook11; 
	private Knight knight11;
	private Bishop bishop11;
	private Queen queen1; 
	private King king1; 
	private Bishop bishop12;
	private Knight knight12;
	private Rook rook12;
	private Pawn pawn11;
	private Pawn pawn12;
	private Pawn pawn13;
	private Pawn pawn14;
	private Pawn pawn15;
	private Pawn pawn16;
	private Pawn pawn17;
	private Pawn pawn18;
		
	private Piece selectedPiece = null;

	private StatusBar statusBar = null;
	
	// GameLogic variables
	private GameLogic gameLogic = new GameLogic();
	public List<Piece> checkPieces = new ArrayList<Piece>();
	public List<Piece> saviorPieces = new ArrayList<Piece>();
	public int	playerOneRook = 2;
	public int	playerOneBishopLightSquare = 1;
	public int	playerOneBishopDarkSquare = 1;
	public int	playerOneKnight = 2;
	public int	playerOneQueen = 1;
	public int	playerOnePawn = 8;
	public int	playerTwoRook = 2;
	public int	playerTwoBishopLightSquare = 1;
	public int	playerTwoBishopDarkSquare = 1;
	public int	playerTwoKnight = 2;
	public int	playerTwoQueen = 1;
	public int	playerTwoPawn = 8;
	private Alert alert;
		
	private Rectangle background;
	private double cell_width;
	private double cell_height;
	private int current_player;
	private boolean isBlack = false; 
	public boolean checkmate = false;
	public boolean checkState = false;
	public boolean stalemate = false;
	
	private final int EMPTY = 0;
	private final int PlayerWhite = 1;
	private final int PlayerBlack = 2;
	
}
