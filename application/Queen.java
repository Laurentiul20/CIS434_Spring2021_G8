package application;

public class Queen extends Pieces {

   Queen(boolean color, int ID, int posX, int posY) {
      
      // Call the super class constructor (Pieces) (done by default?)
      super(color, ID, posX, posY);
      
   }
   
   // Unique moveMethod:
   public boolean moveMethod(int dy, int dx) {
   
      if (dy==dx || dy==-dx || dy==0 || dx==0) {
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