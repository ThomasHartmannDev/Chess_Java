package vision;
import model.Board;

import javax.swing.*;

public class JBoard extends JPanel {
    private Board board; // Taking the board from the Model.

    public JBoard(Board board){
        this.board = board;
    }

}
