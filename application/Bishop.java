package application;

public class Bishop extends Pieces {

   Bishop(boolean color, int ID, int posX, int posY) {
      
      // Call the super class constructor (Pieces) (done by default?)
      super(color, ID, posX, posY);
      
   }
   
   // Unique moveMethod:
   public boolean moveMethod(int dy, int dx) {
   
      if (dy==dx) {
         // Let the move occur:
         // NOTE: this. is necessary?
         this.posY = this.posY + dy;
         this.posX = this.posX + dx;
         return true;
      } else {
         return false;
      }
      
   } // End of moveMethod (Queen).
               
} // End of Queen class.