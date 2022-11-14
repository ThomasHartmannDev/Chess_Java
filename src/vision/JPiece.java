package vision;

import model.Piece;

import javax.swing.*;

public class JPiece extends JLabel {
    private Piece piece;

    public JPiece(Piece piece){
        this.piece = piece;
        //this.setText("PIECE");
        this.setIcon(new ImageIcon(piece.getImage()));
    }

    public Piece getPiece(){
        return this.piece;
    }
}
