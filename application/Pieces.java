/* 
* Last Updated: April 2, 2021 
* By: Evan Sadler
* 
* This is the class list for the chess pieces.
* There is a UML diagram on our github page which this follows.
*/

package application;

public abstract class Pieces {
   
   
   boolean isAlive;
   boolean color;
   // False for white, true for black
   int ID;
  
   // ID is dependent on the initial position of the piece. 
   // It uses the same 2x2 array system. For example, the first 
   
   int row; 
   int col;
   // Current position (x,y). 
   
   public Pieces(boolean init_Color, int init_ID, int init_Row, int init_Col) {
      // Public constructor
      boolean isAlive = true;
      // All pieces are initially alive.
      // Rest are input parameters (may be able to compute initial pos. from ID instead?):
      
      // DEBUG COMMENTED OUT:
      color = init_Color;
      ID = init_ID;
      row = init_Row;
      col = init_Col; 

   }
   
   abstract boolean moveMethod(int dX, int dY);
      // Input parameters: Change in x (dx) and change in y (dy)
      // Returns a boolean if the attempted dx,dy is acceptable based on the piece.
      // BY DEFAULT, return false.
      
   abstract int getID();
      // Returns the ID of the piece.
     
  
   
} // End of pieces.

// ACTUAL PIECE CLASSES:


      
     
      
      
      
      
      
   