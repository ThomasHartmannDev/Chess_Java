package model;

public class Board {

    private Piece[][] pieces;
    //We are settings piece as the board, cuz are using the Polymorphism, so we can put every piece inside.
    private Piece selectedPiece = null; // We need to check which piece are selected.
    private EnumColor turn = EnumColor.WHITE; // Setting the first turn is always from the white side!

    public static final int TimeToPlay = 10000; // Timer the player have to play your turn!

    public Board(){
        this.pieces = new Piece[8][8]; // Creating the Array from board.
        Rook whiteRook1 = new Rook(EnumColor.WHITE, 0,0);
        Rook whiteRook2 = new Rook(EnumColor.WHITE, 0,7);

        Rook blackRook1 = new Rook(EnumColor.BLACK, 7,7);
        Rook blackRook2 = new Rook(EnumColor.BLACK, 7,0);

        this.addPiece(whiteRook1);
        this.addPiece(whiteRook2);
        this.addPiece(blackRook1);
        this.addPiece(blackRook2);

    }
    public Piece getPiece(int line, int column){ // Getting from the coordinates, which piece are there.
        return this.pieces[line][column];
    }
    public void addPiece(Piece piece){
        this.pieces[piece.getLine()][piece.getColumn()] = piece;
        /*
        * When we create a piece, we need to set the first Coodinate,
        * so are taking it and setting on the board
        * */
        piece.setBoard(this);// Sending the board to the piece. just to make sure is the same board!
        return;
    }
    public void selectPiece(Piece piece){
        if(piece.isSelected()){ // If the piece is selected, we make it false.
            piece.setSelected(false);
            this.selectedPiece = null;
        } else {
            piece.setSelected(true); // if piece was not selected, we make is true, he marks the piece
            this.selectedPiece = piece; // and the board.
        }
    }

    public void movePiece(Piece piece, int newLine, int newColumn){

    }

    public void changeTurn(){ // Just changing the color turn.
        if(this.turn.equals(EnumColor.WHITE)){
            this.turn = EnumColor.BLACK;
        } else {
            this.turn = EnumColor.WHITE;
        }
        /*
        * We don't use == because it will use the place on the memory, and it will be never equal,
        * so we need to make sure the value are equals.
        * we have 2 objects to equal, we need to equal the value and not the place on the memory.
        * */
    }

}
