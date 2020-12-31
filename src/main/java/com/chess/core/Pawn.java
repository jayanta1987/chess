package com.chess.core;

import java.util.List;

public class Pawn extends Piece {
	
	public Pawn() {};
	
    private boolean wasMoved;
    
    public Pawn(Color color, Cell initSq, String img_file, PieceType pieceType) {
        super(color, initSq, img_file,pieceType);
    }

	@Override
	public List<Location> findPossibleMoves(Location location, String color, Cell[][] board) {
		// TODO Auto-generated method stub
		return null;
	}
}
