package model;

public class Knight extends Piece{
    public Knight(EnumColor color, int line, int column) {
        super(color, line, column, "/Users/hartm/Documents/GitHub/Chess_Java/src/figs/"+color+"KNIGHT.png");
    }
    public Knight(EnumColor color, int line, int column, String image) {
        super(color, line, column, image);
    }

    @Override
    public boolean MoveValidator(int lineDestiny, int columnDestiny) {
        int lineDifference = Math.abs(lineDestiny - getLine());
        int columnDifference = Math.abs(columnDestiny - getColumn());

        // O Cavalo se move em forma de "L" (duas casas em uma direção e uma em outra)
        // Portanto, a soma das diferenças deve ser igual a 3 (2 + 1) e não pode mover em linha reta (2 + 0).
        if ((lineDifference == 2 && columnDifference == 1) || (lineDifference == 1 && columnDifference == 2)) {
            return true;
        }

        return false;
    }
}
