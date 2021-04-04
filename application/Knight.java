package application;

import java.lang.Math;

public class Knight extends Pieces {

   Knight(boolean color, int ID, int posX, int posY) {
      
      // Call the super class constructor (Pieces) (done by default?)
      super(color, ID, posX, posY);
      
   }
   
   // Unique moveMethod:
   public boolean moveMethod(int dy, int dx) {
   
      // NOTE: Remove abs val for better performance?
      if ((Math.abs(dy)==2 && Math.abs(dx)==1) || (Math.abs(dy)==1 && Math.abs(dx)==2)) {
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