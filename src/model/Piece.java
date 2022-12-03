package model;

public abstract class Piece { // Creating a new abstract class Piece to create all the pieces. Just a model.

    private EnumColor color; // Taking the choices from the EnumColor.
    private int line, column; // Setting Line and Columns from the board.
    private String image; // Setting the image from the piece.
    private boolean eliminated = false; // Checking if the piece still on the board.

    private boolean selected = false; // Checking if the piece is selected
    private Board board;
    public Piece(EnumColor color, int line, int column, String image){
        /*
        * This is a Constructor from the piece, everytime when we create a piece,
        * we NEED to set this information, Color, line, column and image.
        * */
        this.color = color;
        this.line = line;
        this.column = column;
        this.image = image;
    }

    public abstract boolean MoveValidator(int lineDestiny, int columnDestiny);
    /*
        When we move the piece we need to validate the movement, otherwise the people can just drop the
        piece whatever he wants.
    */


    /*Getters and Setters
      Why use this ?
        Getter - As the name says, we can get something, so we could to be able to get information or validate if the people can reach this information.
        Setter - As the name says, we can set something, so we could to be able to set information and we can validate or work on the information.
    */
    public EnumColor getColor() {
        return color;
    }

    public void setColor(EnumColor color) {
        this.color = color;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isEliminated() {
        return eliminated;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    public boolean isSelected() {
        System.out.println(selected);
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setBoard(Board board){
        this.board = board;
    }
    public Board getBoard(){
        return this.board;
    }
}
