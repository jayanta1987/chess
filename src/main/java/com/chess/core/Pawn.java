package com.chess.core;

public class Pawn extends Piece {
    private boolean wasMoved;
    
    public Pawn(Color color, Cell initSq, String img_file) {
        super(color, initSq, img_file);
    }
    
    
}
