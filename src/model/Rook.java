package model;

public class Rook extends Piece{

    public Rook(EnumColor color, int line, int column, String image) {
        super(color, line, column, image);
    }

    @Override
    public boolean MoveValidator(int lineDestiny, int columnDestiny) {
        return true;
    }
}
