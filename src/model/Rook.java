package model;

public class Rook extends Piece{

    //Construtor mais simplificado para não ficarmos sempre passando a imagem.
    public Rook(EnumColor color, int line, int column) {
        super(color, line, column, "/Users/hartm/Documents/GitHub/Chess_Java/src/figs/"+color+"ROOK.png");
    }
    public Rook(EnumColor color, int line, int column, String image) {
        super(color, line, column, image);
    }

    @Override
    public boolean MoveValidator(int lineDestiny, int columnDestiny) {
        int lineDifference = Math.abs(lineDestiny - getLine());
        int columnDifference = Math.abs(columnDestiny - getColumn());

        // A Torre se move na vertical ou na horizontal.
        if (lineDifference == 0 && columnDifference > 0) {
            return true; // Movimento na horizontal
        } else if (lineDifference > 0 && columnDifference == 0) {
            return true; // Movimento na vertical
        }

        return false; // Movimento inválido
    }
}
