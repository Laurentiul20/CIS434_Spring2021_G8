/* 
* Last Updated: April 2, 2021 
* By: Evan Sadler
* 
* This is the class list for the chess pieces.
* There is a UML diagram on our github page which this follows.
*/

package application;

public class Pieces {
   
   
   boolean isAlive;
   boolean color;
   // 0 for white, 1 for black
   int ID;
  
   // ID is dependent on the initial position of the piece. 
   // It uses the same 2x2 array system. For example, the first 
   
   int row; 
   int col;
   // Current position (x,y). 
   
   public Pieces(boolean color, int ID, int row, int col) {
      // Public constructor
      boolean isAlive = true;
      // All pieces are initially alive.
      // Rest are input parameters (may be able to compute initial pos. from ID instead?):
      color = this.color;
      ID = this.ID;
      row=this.row;
      col=this.col; 
   }
   
   // NOTE: The generic moveMethod may be unnecessary or even harmful. Consider removing. 
   // NOTE: May need to be marked "abstract" actually?
   
   public boolean moveMethod(int dX, int dY) { 
      // Input parameters: Change in x (dx) and change in y (dy)
      // Returns a boolean if the attempted dx,dy is acceptable based on the piece.
      // By default:
      return false;
   }
   
} // End of pieces.

// ACTUAL PIECE CLASSES:


      
     
      
      
      
      
      
   