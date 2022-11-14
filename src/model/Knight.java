package model;

public class Knight extends Piece{
    public Knight(EnumColor color, int line, int column) {
        super(color, line, column, "/Users/thomashartmann/Desktop/Example/Chess_Java/src/figs/"+color+"KNIGHT.png");
    }
    public Knight(EnumColor color, int line, int column, String image) {
        super(color, line, column, image);
    }

    @Override
    public boolean MoveValidator(int lineDestiny, int columnDestiny) {
        return true;
    }
}
