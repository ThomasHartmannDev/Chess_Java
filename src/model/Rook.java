package model;

public class Rook extends Piece{

    //Construtor mais simplificado para não ficarmos sempre passando a imagem.
    public Rook(EnumColor color, int line, int column) {
        super(color, line, column, "/Users/thomashartmann/Desktop/Example/Chess_Java/src/figs/"+color+"ROOK.png");
    }
    public Rook(EnumColor color, int line, int column, String image) {
        super(color, line, column, image);
    }

    @Override
    public boolean MoveValidator(int lineDestiny, int columnDestiny) {
        return true;
    }
}
