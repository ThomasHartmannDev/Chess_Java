package vision;

import model.Piece;

import javax.swing.*;

public class JPiece extends JLabel {
    private Piece piece;

    public JPiece(Piece piece){
        this.piece = piece;
    }

    public Piece getPiece(){
        return this.piece;
    }
}
