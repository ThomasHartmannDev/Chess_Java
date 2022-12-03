package model;

public class Board {

    private Piece[][] pieces;
    //We are settings piece as the board, cuz are using the Polymorphism, so we can put every piece inside.
    private Piece selectedPiece = null; // We need to check which piece are selected.
    private EnumColor turn = EnumColor.WHITE; // Setting the first turn is always from the white side!

    public static final int TimeToPlay = 10000; // Timer the player have to play your turn!

    public Board(){
        this.pieces = new Piece[8][8]; // Creating the Array from board.
        //Setting White Pieces Positions.
        Rook whiteRook1 = new Rook(EnumColor.WHITE, 0,0);
        Knight whiteKnight1 = new Knight(EnumColor.WHITE, 0,1);
        Bishop whiteBishop1 = new Bishop(EnumColor.WHITE, 0,2);
        Queen whiteQueen = new Queen(EnumColor.WHITE,0,3);
        King whiteKing = new King(EnumColor.WHITE, 0, 4);
        Bishop whiteBishop2 = new Bishop(EnumColor.WHITE, 0,5);
        Knight whiteKnight2 = new Knight(EnumColor.WHITE, 0,6);
        Rook whiteRook2 = new Rook(EnumColor.WHITE, 0,7);


        Rook blackRook1 = new Rook(EnumColor.BLACK, 7,0);
        Knight blackKnight1 = new Knight(EnumColor.BLACK, 7, 1);
        Bishop blackBishop1 = new Bishop(EnumColor.BLACK, 7,2);
        Queen blackQueen = new Queen(EnumColor.BLACK,7,3);
        King blackKing = new King(EnumColor.BLACK, 7, 4);
        Bishop blackBishop2 = new Bishop(EnumColor.BLACK, 7,5);
        Knight blackKnight2 = new Knight(EnumColor.BLACK, 7,6);
        Rook blackRook2 = new Rook(EnumColor.BLACK, 7,7);
        //White Pieces
        this.addPiece(whiteRook1);
        this.addPiece(whiteKnight1);
        this.addPiece(whiteBishop1);
        this.addPiece(whiteQueen);
        this.addPiece(whiteKing);
        this.addPiece(whiteBishop2);
        this.addPiece(whiteKnight2);
        this.addPiece(whiteRook2);

        //Black Pieces
        this.addPiece(blackRook1);
        this.addPiece(blackKnight1);
        this.addPiece(blackBishop1);
        this.addPiece(blackQueen);
        this.addPiece(blackKing);
        this.addPiece(blackBishop2);
        this.addPiece(blackKnight2);
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

    }
    public void selectPiece(Piece piece){
        if(piece.isSelected()){ // If the piece is selected, we make it false.
            System.out.println("Piece: "+ piece.isSelected());
            piece.setSelected(false);
            this.selectedPiece = null;
        } else {
            piece.setSelected(true); // if piece was not selected, we make is true, he marks the piece
            System.out.println("Piece: "+ piece.isSelected());
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

    public void playTurn(int line, int column) {
        Piece piece = this.getPiece(line,column);
        if(this.selectedPiece == null){
            if(piece != null && piece.getColor().equals(this.turn)){
                // Checkando se existe uma peça na Celula e se a peça selecionada corresponde a cor da vez.
                this.selectPiece(piece);
                System.out.println("Selected");
            }
        } else {
            if(this.selectedPiece == piece){
                this.selectPiece(piece);
                System.out.println("unselected");
            }
        }


    }
}
