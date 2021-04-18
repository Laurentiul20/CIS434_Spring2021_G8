package application;

public class Bishop extends Pieces {

   Bishop(boolean color, int ID, int row, int col) {
      
      // Call the super class constructor (Pieces) (done by default?)
      super(color, ID, row, col);
      
   }
   
   // Unique moveMethod:
   public boolean moveMethod(int dy, int dx) {
   
      if (dy==dx) {
         // Let the move occur:
         // NOTE: this. is necessary?
         this.col = this.col + dx;
         this.row = this.row + dy;
         return true;
      } else {
         return false;
      }
      
   } // End of moveMethod (Queen).
   
   // Get method for the ID (I think you need this?): 
   public int getID() {
   
      return ID;
   }
   
               
} // End of Queen class.