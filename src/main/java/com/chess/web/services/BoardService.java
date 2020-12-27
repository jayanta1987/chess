package com.chess.web.services;

import org.springframework.stereotype.Service;

import com.chess.core.Cell;
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

	
	
}
