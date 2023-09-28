package model;

public class King extends Piece{
    public King(EnumColor color, int line, int column) {
        super(color, line, column, "/Users/hartm/Documents/GitHub/Chess_Java/src/figs/"+color+"KING.png");
    }
    public King(EnumColor color, int line, int column, String image) {
        super(color, line, column, image);
    }

    @Override
    public boolean MoveValidator(int lineDestiny, int columnDestiny) {
        int lineDifference = Math.abs(lineDestiny - getLine());
        int columnDifference = Math.abs(columnDestiny - getColumn());

        // Verificar se o movimento é válido (uma casa em qualquer direção)
        if(lineDifference <= 1 && columnDifference <= 1) {
            return true;
        }

        return false; // Movimento inválido
    }
}

