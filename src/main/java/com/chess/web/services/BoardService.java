package com.chess.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chess.core.Cell;
import com.chess.core.Location;
import com.chess.core.Piece;
import com.chess.web.util.ApplicationUtil;

@Service
public class BoardService {

	public Cell[][] initializeCell(Cell[][] board) {
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				ApplicationUtil.initializeCellColor(board, i, j);
				ApplicationUtil.initializePieces(board, i, j);
			}
		}
		
		return board;
	}
	
	public List<Location> findPossibleMoves(Location location, Piece piece, Cell[][] board) {
		
		List<Location> possibleMoves = piece.findPossibleMoves(location,piece.getColor().toString(), board);
		
		return possibleMoves;
	}



	

	
	
}
