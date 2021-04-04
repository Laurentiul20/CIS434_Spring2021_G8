package application;

public class King extends Pieces {

   King(boolean color, int ID, int posX, int posY) {
   
      // Call the super class constructor (Pieces) (done by default?)
      super(color, ID, posX, posY);
   }
      
   
   
   // Unique moveMethod:
   public boolean moveMethod(int dy, int dx) {
   
      if ((dy != 0 && dx !=0) && (dy < 2 && dx < 2) && (dy > -2 && dx > -2)) {
         // Let the move occur:
         this.posY = this.posY + dy;
         this.posX = this.posX + dx;
         return true;
      } else {
         return false;
      }
      
   } // End of moveMethod (King).
               
} // End of King class.