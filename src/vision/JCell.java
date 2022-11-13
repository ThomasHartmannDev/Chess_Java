package vision;

import javax.swing.*;

public class JCell extends JPanel {
    private JPiece jPiece;
    private int line, column;


    public JCell(int line, int column){
        this.line = line;
        this.column = column;
    }
}
