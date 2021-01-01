package com.chess.core;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
	
	public Queen() {};

    public Queen(Color color, Cell initSq, String img_file, PieceType pieceType) {
        super(color, initSq, img_file,pieceType);
    }

	@Override
	public List<Location> findPossibleMoves(Location location, String color, Cell[][] board) {
		
		List<Location> possibleMoves = new ArrayList<>();
		
		Rook rook = new Rook();
		possibleMoves.addAll(rook.findPossibleMoves(location, color, board));
		
		Bishop bishop = new Bishop();
		possibleMoves.addAll(bishop.findPossibleMoves(location, color, board));
		
		return possibleMoves;
	}
    
}
