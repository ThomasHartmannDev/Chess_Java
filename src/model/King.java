package model;

public class King extends Piece{
    public King(EnumColor color, int line, int column) {
        super(color, line, column, "/Users/thomashartmann/Desktop/Example/Chess_Java/src/figs/"+color+"KING.png");
    }
    public King(EnumColor color, int line, int column, String image) {
        super(color, line, column, image);
    }

    @Override
    public boolean MoveValidator(int lineDestiny, int columnDestiny) {
        return true;
    }
}
