package model;

public class Bishop extends Piece{
    public Bishop(EnumColor color, int line, int column) {
        super(color, line, column, "/Users/thomashartmann/Desktop/Example/Chess_Java/src/figs/"+color+"BISHOP.png");
    }
    public Bishop(EnumColor color, int line, int collumn, String image){
        // Calling the constructor from the Father class (Pieces) and giving this information.
        super(color, line ,collumn ,image);
    }

    @Override
    public boolean MoveValidator(int lineDestiny, int columnDestiny) {

        return true;
    }
}
