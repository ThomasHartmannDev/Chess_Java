package vision;

import model.Board;
import model.EnumColor;

import javax.swing.*;

import java.awt.*;

public class JChess extends JFrame {

    private static JLabel lbTurn;
    private Board board;

    private JButton btRestartGame;
    private JButton btEndGame;
    private JButton btDraw;

    public JChess(){
        setTitle("Chess Game");
        //Passing the board mold information to the
        // JBoard to create it visually.
        this.setLayout(new BorderLayout());
        this.board = new Board();
        this.add(new JBoard(board), BorderLayout.CENTER);

        //Adiciona Label para mostrar de quem é a vez.
        JPanel pnTop = new JPanel();
        lbTurn = new JLabel("Turn: WHITE");
        pnTop.add(lbTurn);
        this.add(pnTop, BorderLayout.NORTH);

        JPanel pnSide = new JPanel();
        pnSide.setLayout(new GridLayout(5,1));
        btRestartGame = new JButton("Restart Game");
        btEndGame = new JButton("End Game");
        btDraw = new JButton("Draw");
        pnSide.add(btRestartGame);
        pnSide.add(btEndGame);
        pnSide.add(btDraw);

        this.add(pnSide, BorderLayout.WEST);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); // Atualiza a tela e faz com que ela exista.
        this.setVisible(true);
    }

    public static void setTurn(EnumColor colorTurn){
        lbTurn.setText("TURN: " + colorTurn);
    }
    public static void main(String args[]){
        new JChess();
    }
}
