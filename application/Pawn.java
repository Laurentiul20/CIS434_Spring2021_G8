package application;

public class Pawn extends Pieces {

   Pawn(boolean color, int ID, int posX, int posY) {
      
      // Call the super class constructor (Pieces) (done by default?)
      super(color, ID, posX, posY);
      
   }
      
   
   
   // Unique moveMethod:
   public boolean moveMethod(int dy, int dx) {
   
      if (dy == 1 && dx == 0) {
         // Let the move occur:
         this.posY++;
         return true;
      } else {
         return false;
      }
      
   } // End of moveMethod (Pawn).
               
} // End of Pawn class.