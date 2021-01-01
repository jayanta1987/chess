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
		
		
		Location location0 = null;
		Location location1 = null;
		Location location2 = null;
		Location location3 = null;
		
		if(color.equals(Color.WHITE.name())) {
			//UP +1
			if(xNum==6) {
				location0 = new Location(xNum-2, yNum);
			}
			
			//UP
			location1 = new Location(xNum-1, yNum);
			
			//Right Up
			location2 = new Location(xNum-1, yNum+1);
			
			//Left Up
			location3 = new Location(xNum-1, yNum-1);
		}else {
			//UP +1
			if(xNum==1) {
				location0 = new Location(xNum+2, yNum);
			}
			
			//UP
			location1 = new Location(xNum+1, yNum);
			
			//Right Up
			location2 = new Location(xNum+1, yNum-1);
			
			//Left Up
			location3 = new Location(xNum+1, yNum+1);
		}
		if(null!=location0 && ApplicationUtil.validatePossibleMove(location0,  color, board) && !location0.isKillable()) { //Pawn can't move upside to kill opponent 
			possibleMoves.add(location0);
		}
		
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
