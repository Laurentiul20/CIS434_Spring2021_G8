package application;

public class Pawn extends Pieces {

   Pawn(boolean color, int ID, int row, int col) {
      
      // Call the super class constructor (Pieces) (done by default?)
      super(color, ID, row, col);
      
   }
      
   
   
   // Unique moveMethod:
   public boolean moveMethod(int dy, int dx) {
   
      if (dy == 1 && dx == 0) {
         // Let the move occur:
         this.row++;
         return true;
      } else {
         return false;
      }
      
   } // End of moveMethod (Pawn).
   
   // Get method for the ID (I think you need this?):
   // DOESN'T WORK NEEDS FIXING 
   public int getID() {
   
      return ID;
   }
               
} // End of Pawn class.