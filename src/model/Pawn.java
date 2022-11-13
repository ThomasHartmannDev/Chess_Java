package model;

public class Pawn extends Piece{

    public Pawn(EnumColor color, int line, int collumn, String image){
        // Calling the constructor from the Father class (Pieces) and giving this information.
        super(color, line ,collumn ,image);
    }

    @Override // Override = we will Rewrite this method.
    public boolean MoveValidator(int lineDestiny, int columnDestiny) {

        return true;
    }

}
