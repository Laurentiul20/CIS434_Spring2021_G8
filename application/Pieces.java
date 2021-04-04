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
   // To ensure uniqueness, the following system is used:
   
   // Black row 2: 801, 802, 803, ... , 808
   // Black row 1: 701, 702, 703, ... , 708
   // Blank rows
   // White row 1: 201, 202, 203, ... , 208 
   // White row 1: 101, 102, 103, ... , 108 
   
   int posX; 
   int posY;
   // Current position (x,y). 
   
   public Pieces(boolean color, int ID, int posX, int posY) {
      // Public constructor
      boolean isAlive = true;
      // All pieces are initially alive.
      // Rest are input parameters (may be able to compute initial pos. from ID instead?):
      color = this.color;
      ID = this.ID;
      posX=this.posX;
      posY=this.posY;
   }
   
   // NOTE: The generic moveMethod may be unnecessary or even harmful. Consider removing.
   
   public boolean moveMethod(int dX, int dY) { 
      // Input parameters: Change in x (dx) and change in y (dy)
      // Returns a boolean if the attempted dx,dy is acceptable based on the piece.
      // By default:
      return false;
   }
   
} // End of pieces.

// ACTUAL PIECE CLASSES:


      
     
      
      
      
      
      
   