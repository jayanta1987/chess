package com.chess.core;

import java.util.ArrayList;
import java.util.List;

import com.chess.web.util.ApplicationUtil;

public class Bishop extends Piece {

	public Bishop() {
	};

	public Bishop(Color color, Cell initSq, String img_file, PieceType pieceType) {
		super(color, initSq, img_file, pieceType);
	}

	@Override
	public List<Location> findPossibleMoves(Location location, String color, Cell[][] board) {
		List<Location> possibleMoves = new ArrayList<>();

		int xNum = location.getxNum();
		int yNum = location.getyNum();

		// LU
		while (xNum >= 0 && yNum >= 0) {
			xNum--;
			yNum--;

			if (!ApplicationUtil.validateLinearSearchLocationAndAddPossibleMove(color, board, possibleMoves, xNum,
					yNum)) {
				break;
			}

		}
		
		xNum = location.getxNum();
		yNum = location.getyNum();

		// RU
		while (xNum >= 0 && yNum <= 7) {
			xNum--;
			yNum++;

			if (!ApplicationUtil.validateLinearSearchLocationAndAddPossibleMove(color, board, possibleMoves, xNum,
					yNum)) {
				break;
			}

		}
		
		xNum = location.getxNum();
		yNum = location.getyNum();

		// LD
		while (xNum <= 7 && yNum >= 0) {
			xNum++;
			yNum--;

			if (!ApplicationUtil.validateLinearSearchLocationAndAddPossibleMove(color, board, possibleMoves, xNum,
					yNum)) {
				break;
			}

		}
		
		xNum = location.getxNum();
		yNum = location.getyNum();

		// RD
		while (xNum <= 7 && yNum <= 7) {
			xNum++;
			yNum++;

			if (!ApplicationUtil.validateLinearSearchLocationAndAddPossibleMove(color, board, possibleMoves, xNum,
					yNum)) {
				break;
			}

		}

		return possibleMoves;
	}

}
