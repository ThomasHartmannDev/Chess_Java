package model;

public class Pawn extends Piece{

    public Pawn(EnumColor color, int line, int column) {
        super(color, line, column, "/Users/hartm/Documents/GitHub/Chess_Java/src/figs/"+color+"PAWN.png");
    }
    public Pawn(EnumColor color, int line, int collumn, String image){
        // Calling the constructor from the Father class (Pieces) and giving this information.
        super(color, line ,collumn ,image);
    }

    @Override // Override = we will Rewrite this method.
    public boolean MoveValidator(int lineDestiny, int columnDestiny) {
        // Verificar se a peça está sendo movida na mesma coluna
        if (columnDestiny == getColumn()) {
            // Peão branco move para frente (linha crescente)
            if (getColor().equals(EnumColor.WHITE)) {
                // Verificar se o movimento é de uma casa para frente
                if (lineDestiny == getLine() + 1 && getBoard().getPiece(lineDestiny, columnDestiny) == null) {
                    return true;
                }
                // Verificar se é o primeiro movimento e pode mover duas casas para frente
                if (getLine() == 1 && lineDestiny == getLine() + 2 && getBoard().getPiece(getLine() + 1, columnDestiny) == null) {
                    return true;
                }
            }
            // Peão preto move para trás (linha decrescente)
            else if (getColor().equals(EnumColor.BLACK)) {
                // Verificar se o movimento é de uma casa para frente
                if (lineDestiny == getLine() - 1 && getBoard().getPiece(lineDestiny, columnDestiny) == null) {
                    return true;
                }
                // Verificar se é o primeiro movimento e pode mover duas casas para frente
                if (getLine() == 6 && lineDestiny == getLine() - 2 && getBoard().getPiece(getLine() - 1, columnDestiny) == null) {
                    return true;
                }
            }
        }
        // Verificar se a peça está realizando uma captura diagonal
        else if (Math.abs(columnDestiny - getColumn()) == 1) {
            // Peão branco captura diagonalmente para frente (linha crescente)
            if (getColor().equals(EnumColor.WHITE) && lineDestiny == getLine() + 1 && getBoard().getPiece(lineDestiny, columnDestiny) != null) {
                return true;
            }
            // Peão preto captura diagonalmente para trás (linha decrescente)
            else if (getColor().equals(EnumColor.BLACK) && lineDestiny == getLine() - 1 && getBoard().getPiece(lineDestiny, columnDestiny) != null) {
                return true;
            }
        }

        // Se nenhuma das condições acima for satisfeita, o movimento é inválido
        return false;
    }



}
