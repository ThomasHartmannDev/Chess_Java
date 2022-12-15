package vision;

import controller.ControlTime;

import model.Board;
import model.EnumColor;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JChess extends JFrame {

    private static JLabel lbTurn;

    private static JLabel lbTimeWhite;
    private static JLabel lbTimeBlack;
    private Board board;
    private JBoard jBoard;
    private JButton btRestartGame;
    private JButton btEndGame;
    private JButton btDraw;

    public static final JPanel pnKillPiece = new JPanel();
    private ControlTime controlTime;

    public JChess(){

        setTitle("Chess Game");
        //Passing the board mold information to the
        // JBoard to create it visually.
        this.setLayout(new BorderLayout());
        this.board = new Board();
        this.jBoard = new JBoard(board);
        this.add(jBoard, BorderLayout.CENTER);

        //Adiciona Label para mostrar de quem é a vez.
        JPanel pnTop = new JPanel();
        lbTurn = new JLabel("Turn: WHITE");
        pnTop.add(lbTurn);
        this.add(pnTop, BorderLayout.NORTH);

        JPanel pnSideW = new JPanel();
        pnSideW.setLayout(new GridLayout(5,1));
        btRestartGame = new JButton("Restart Game");
        btRestartGame.addActionListener(new ActionListener() {
            // Create the action
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });

        pnKillPiece.setLayout(new FlowLayout());
        //this.add(pnKillPiece, BorderLayout.EAST);

        btEndGame = new JButton("End Game");
        btDraw = new JButton("Draw");
        pnSideW.add(btRestartGame);
        pnSideW.add(btEndGame);
        pnSideW.add(btDraw);

        this.add(pnSideW, BorderLayout.WEST);

        JPanel pnSideE = new JPanel();
        pnSideE.setLayout(new GridLayout(2,1));
        lbTimeWhite = new JLabel("White Time: 0");
        lbTimeBlack = new JLabel("White Time: 0");
        pnSideE.add(lbTimeWhite, BorderLayout.PAGE_START);

        //pnSideE.add(pnKillPiece, BorderLayout.EAST);

        pnSideE.add(lbTimeBlack, BorderLayout.PAGE_END);

        this.add(pnSideE, BorderLayout.EAST);





        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        controlTime = new ControlTime(jBoard);
        Thread threadTime = new Thread(controlTime);
        threadTime.start();

        this.pack(); // Atualiza a tela e faz com que ela exista.
        this.setVisible(true);
    }

    private void restartGame() {
        this.board = new Board(); // Create a new board
        this.controlTime = new ControlTime(this.jBoard);
        this.jBoard.setBoard(board); // Set the new pointer to the board.
        this.jBoard.drawBoard();

    }

    public static void setTurn(EnumColor colorTurn){
        lbTurn.setText("TURN: " + colorTurn);
    }

    public static void setTimeWhiteLb(String timeWhite){
        lbTimeWhite.setText("White Time: \n" + timeWhite);
    }
    public static void setTimeBlackLb(String timeBlack){
        lbTimeBlack.setText("Black Time: \n" + timeBlack);
    }
    public static void main(String args[]){
        new JChess();
    }
}
