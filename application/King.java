package application;

public class King extends Pieces {

   King(boolean color, int ID, int row, int col) {
   
      // Call the super class constructor (Pieces) (done by default?)
      super(color, ID, row, col);
      
      // CONSTRUCTOR TEST:
      System.out.println(this.getID());
   }
      
   
   
   // Unique moveMethod:
   public boolean moveMethod(int dy, int dx) {
   
      if ((dy != 0 && dx !=0) && (dy < 2 && dx < 2) && (dy > -2 && dx > -2)) {
         // Let the move occur:
         this.col = this.col + dx;
         this.row = this.row + dy;
         return true;
      } else {
         return false;
      }
      
   } // End of moveMethod (King).
   
   // Get method for the ID (I think you need this?): 
   public int getID() {
   
      return ID;
   }
               
} // End of King class.