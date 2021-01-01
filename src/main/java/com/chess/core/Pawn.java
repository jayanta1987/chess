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

		//UP
		Location location1 = new Location(xNum-1, yNum);
		
		//Right Up
		Location location2 = new Location(xNum-1, yNum+1);
		
		//Left Up
		Location location3 = new Location(xNum-1, yNum-1);
		
		if(ApplicationUtil.validatePossibleMove(location1,  color, board) && !location1.isKillable()) { //Pawn can't move upside to kill opponent 
			possibleMoves.add(location1);
		}
		if(ApplicationUtil.validatePossibleMove(location2,  color, board) && location2.isKillable()) {
			possibleMoves.add(location2);
		}
		if(ApplicationUtil.validatePossibleMove(location3,  color, board) && location3.isKillable()) {
			possibleMoves.add(location3);
		}
		
		

		return possibleMoves;
	}
}
