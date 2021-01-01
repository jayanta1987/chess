package com.chess.core;

import java.util.ArrayList;
import java.util.List;

import com.chess.web.util.ApplicationUtil;

public class Pawn extends Piece {

	public Pawn() {
	};

	private boolean wasMoved;

	public Pawn(Color color, Cell initSq, String img_file, PieceType pieceType) {
		super(color, initSq, img_file, pieceType);
	}

	@Override
	public List<Location> findPossibleMoves(Location location, String color, Cell[][] board) {

		List<Location> possibleMoves = new ArrayList<>();

		int xNum = location.getxNum();
		int yNum = location.getyNum();

		Location location1 = new Location(xNum-1, yNum);
		Location location2 = new Location(xNum-1, yNum+1);
		
			

		return possibleMoves;
	}
}
