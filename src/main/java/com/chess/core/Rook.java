package com.chess.core;

import java.util.ArrayList;
import java.util.List;

import com.chess.web.util.ApplicationUtil;

public class Rook extends Piece {
	
	public Rook() {};

    public Rook(Color color, Cell initSq, String img_file, PieceType pieceType) {
        super(color, initSq, img_file,pieceType);
    }

	@Override
	public List<Location> findPossibleMoves(Location location, String color, Cell[][] board) {
		List<Location> possibleMoves = new ArrayList<>();
    	
		int xNum = location.getxNum();
		int yNum = location.getyNum();
		
		//UP
		while(xNum>=0) {
			xNum --;
			if(!ApplicationUtil.validateLinearSearchLocationAndAddPossibleMove(color, board, possibleMoves, xNum, yNum)){
				break;
			}
			
		}
		
		xNum = location.getxNum();
		yNum = location.getyNum();
		//DOWN
		while(xNum<=7) {
			xNum ++;
			if(!ApplicationUtil.validateLinearSearchLocationAndAddPossibleMove(color, board, possibleMoves, xNum, yNum)){
				break;
			}
			
		}
		
		xNum = location.getxNum();
		yNum = location.getyNum();
		//Left
		while(yNum>=0) {
			yNum --;
			if(!ApplicationUtil.validateLinearSearchLocationAndAddPossibleMove(color, board, possibleMoves, xNum, yNum)){
				break;
			}
			
		}
		
		xNum = location.getxNum();
		yNum = location.getyNum();
		//Right
		while(yNum<=7) {
			yNum ++;
			if(!ApplicationUtil.validateLinearSearchLocationAndAddPossibleMove(color, board, possibleMoves, xNum, yNum)){
				break;
			}
			
		}
		
		
		
		return possibleMoves;
	}

	
}
