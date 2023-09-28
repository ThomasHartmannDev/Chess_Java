package model;

public class Queen extends Piece{

    public Queen(EnumColor color, int line, int column) {
        super(color, line, column, "/Users/hartm/Documents/GitHub/Chess_Java/src/figs/"+color+"QUEEN.png");
    }
    public Queen(EnumColor color, int line, int column, String image) {
        super(color, line, column, image);
    }

    @Override
    public boolean MoveValidator(int lineDestiny, int columnDestiny) {
        int lineDifference = Math.abs(lineDestiny - getLine());
        int columnDifference = Math.abs(columnDestiny - getColumn());

        // A Rainha combina os movimentos da Torre (vertical e horizontal) e do Bispo (diagonal).
        if ((lineDifference == 0 && columnDifference > 0) || (lineDifference > 0 && columnDifference == 0)) {
            return true; // Movimento na vertical ou na horizontal
        } else if (lineDifference == columnDifference) {
            return true; // Movimento na diagonal
        }

        return false; // Movimento inválido
    }
}
