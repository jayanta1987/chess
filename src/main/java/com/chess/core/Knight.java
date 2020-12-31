package com.chess.core;

import java.util.ArrayList;
import java.util.List;

import com.chess.web.util.ApplicationUtil;

public class Knight extends Piece {
	
	 public Knight() {};

    public Knight(Color color, Cell initSq, String img_file, PieceType pieceType) {
        super(color, initSq, img_file,pieceType);
    }
   
   	
	@Override
	public List<Location> findPossibleMoves(Location location, String color, Cell[][] board) {
		
    	List<Location> possibleMoves = new ArrayList<>();
    	int xNum = location.getxNum();
		int yNum = location.getyNum();
		
		Location location1 = new Location(xNum-1, yNum+2);
		Location location2 = new Location(xNum-1, yNum-2);
		Location location3 = new Location(xNum+1, yNum+2);
		Location location4 = new Location(xNum+1, yNum-2);
		Location location5 = new Location(xNum+2, yNum-1);
		Location location6 = new Location(xNum+2, yNum+1);
		Location location7 = new Location(xNum-2, yNum-1);
		Location location8 = new Location(xNum-2, yNum+1);

		if(ApplicationUtil.validatePossibleMove(location1,  color, board)) {
			possibleMoves.add(location1);
		}
		if(ApplicationUtil.validatePossibleMove(location2,  color, board)) {
			possibleMoves.add(location2);
		}
		if(ApplicationUtil.validatePossibleMove(location3,  color, board)) {
			possibleMoves.add(location3);
		}
		if(ApplicationUtil.validatePossibleMove(location4,  color, board)) {
			possibleMoves.add(location4);
		}
		if(ApplicationUtil.validatePossibleMove(location5,  color, board)) {
			possibleMoves.add(location5);
		}
		if(ApplicationUtil.validatePossibleMove(location6,  color, board)) {
			possibleMoves.add(location6);
		}
		if(ApplicationUtil.validatePossibleMove(location7,  color, board)) {
			possibleMoves.add(location7);
		}
		if(ApplicationUtil.validatePossibleMove(location8,  color, board)) {
			possibleMoves.add(location8);
		}
		
		return possibleMoves;
	}

}
