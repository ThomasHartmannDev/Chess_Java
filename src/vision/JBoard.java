package vision;
import model.Board;
import model.Piece;

import javax.swing.*;
import java.awt.*;

public class JBoard extends JPanel {
    private Board board; // Taking the board from the Model.

    public JBoard(Board board){
        this.board = board;
        this.DrawBoard();
    }

    public void DrawBoard(){
        this.removeAll();// Removing everything to make sure that will create on a clean page.
        this.setLayout(new GridLayout(8,8));// Creating a 8x8 Grid
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                JCell jCell;
                Piece piece = this.board.getPiece(i,j);
                if (piece == null){
                    jCell = new JCell(i,j);
                } else {
                    jCell = new JCell(new JPiece(piece));
                }
                if((i + j) % 2 == 0){
                    //Creating the Black and white backgroud color.
                    jCell.setBackground(Color.white);
                } else {
                    jCell.setBackground(Color.darkGray);
                }
                this.add(jCell);
            }
        }
        this.revalidate();
    }
}
