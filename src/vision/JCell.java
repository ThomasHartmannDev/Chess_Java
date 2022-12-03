package vision;

import javax.swing.*;
import java.awt.*;

public class JCell extends JPanel {
    private JPiece jPiece;
    private int line, column;


    public JCell(int line, int column){
        this.line = line;
        this.column = column;
    }
    public JCell(JPiece jPiece){
        this.jPiece = jPiece;
        // Info. from where is the Cell.
        this.line = jPiece.getPiece().getLine();
        this.column = jPiece.getPiece().getColumn();
        this.add(jPiece);
        if(jPiece.getPiece()!= null){
            if(jPiece.getPiece().isSelected()){
                this.setBorder(BorderFactory.createLineBorder(Color.RED,5));
            }
            // Creating the Line Boarder when the piece is selected.
        }
    }

    public int getLine(){
        return this.line;
    }

    public int getColumn(){
        return this.column;
    }
}
