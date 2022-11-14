package vision;

import model.Board;

import javax.swing.*;

public class JChess extends JFrame {
    public JChess(){
        setTitle("Chess Game");
        //Passing the board mold information to the
        // JBoard to create it visually.
        this.add(new JBoard(new Board()));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack(); // Atualiza a tela e faz com que ela exista.
        this.setVisible(true);
    }

    public static void main(String args[]){
        new JChess();
    }
}
