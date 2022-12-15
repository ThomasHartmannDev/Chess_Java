package vision;
import model.Board;
import model.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JBoard extends JPanel implements MouseListener {
    private Board board; // Taking the board from the Model.

    public JBoard(Board board){
        this.board = board;
        this.drawBoard();
    }

    public void drawBoard(){
        JChess.pnKillPiece.removeAll();
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
                jCell.addMouseListener(this); // "this" represent this class, "JBoard"
            }
        }
        for(Piece removedPiece : this.board.getPieceOutGame()){
            JChess.pnKillPiece.add(new JPiece(removedPiece));

        }
        this.revalidate();
    }

    @Override
    public void mouseClicked(MouseEvent e) { // Event to catch click.
        JCell jCell = (JCell) e.getSource(); // Get the clicked component.
        //Using (JCell) to pass the object in to JCell.
        this.board.playTurn(jCell.getLine(),jCell.getColumn());
        this.drawBoard();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public Board getBoard(){
        return this.board;
    }

    public void setBoard(Board board){
        this.board = board;
    }
}
