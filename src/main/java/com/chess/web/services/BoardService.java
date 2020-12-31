package com.chess.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chess.core.Cell;
import com.chess.core.Location;
import com.chess.core.PieceType;
import com.chess.web.util.ApplicationConstants;
import com.chess.web.util.ApplicationUtil;

@Service
public class BoardService {

	public Cell[][] initializeCell(Cell[][] board) {
		
		board = new Cell[ApplicationConstants.BOARD_SIZE][ApplicationConstants.BOARD_SIZE];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				ApplicationUtil.initializeCellColor(board, i, j);
				ApplicationUtil.initializePieces(board, i, j);
			}
		}
		
		return board;
	}
	
	public List<Location> findPossibleMoves(Location location, String pieceType, String color, Cell[][] board) {
		
		List<Location> possibleMoves = new ArrayList<>();
		if(PieceType.KNIGHT.name().equals(pieceType)) {
			findPossibleMovesForKnight(location, possibleMoves,color, board);
		}
		return possibleMoves;
	}

	private void findPossibleMovesForKnight(Location location, List<Location> possibleMoves, String color, Cell[][] board) {
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
		
	}

	

	
	
}
