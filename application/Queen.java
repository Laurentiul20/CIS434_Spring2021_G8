package application;

public class Queen extends Pieces {

   Queen(boolean color, int ID, int row, int col) {
      
      // Call the super class constructor (Pieces) (done by default?)
      super(color, ID, row, col);
      
   }
   
   // Unique moveMethod:
   public boolean moveMethod(int dy, int dx) {
   
      if (dy==dx || dy==-dx || dy==0 || dx==0) {
         // Let the move occur:
         // NOTE: this. is necessary?
         this.row = this.row + dy;
         this.col = this.col + dx;
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