package com.chess.web.util;

import com.chess.core.Bishop;
import com.chess.core.Cell;
import com.chess.core.Color;
import com.chess.core.King;
import com.chess.core.Knight;
import com.chess.core.Location;
import com.chess.core.Pawn;
import com.chess.core.Piece;
import com.chess.core.PieceType;
import com.chess.core.Queen;
import com.chess.core.Rook;

public class ApplicationUtil {

	public static void initializeCellColor(Cell[][] board, int i, int j) {
		Cell cell = new Cell();
		cell.setXNum(i);
		cell.setYNum(j);

		if (Math.abs(i - j) % 2 == 0) {
			cell.setCssClass("light");
			cell.setColor(Color.WHITE);
		} else {
			cell.setCssClass("dark");
			cell.setColor(Color.BLACK);
		}

		board[i][j] = cell;
	}

	public static boolean validatePossibleMove(Location location, String pieceColor,
			Cell[][] board) {

		if (location.getxNum() < 0 || location.getxNum() > 7 || location.getyNum() < 0 || location.getyNum() > 7) {
			return false;
		}
		if (null != board[location.getxNum()][location.getyNum()].getOccupyingPiece() && pieceColor
				.equals(board[location.getxNum()][location.getyNum()].getOccupyingPiece().getColor().toString())) {
			return false;
		}
	 return true;

	}

	public static void initializePieces(Cell[][] board, int i, int j) {

		Cell cell = board[i][j];

		initiateBlackPieces(cell, i, j);
		initiateWhitePieces(cell, i, j);
	}

	private static void initiateWhitePieces(Cell cell, int i, int j) {
		if (ApplicationConstants.WHITE_START_POSITION - 1 == i) {
			cell.setOccupyingPiece(
					new Pawn(Color.WHITE, cell, ApplicationUtil.getPieceImageName(Color.WHITE, PieceType.PAWN), PieceType.PAWN));
		} else if (ApplicationConstants.WHITE_START_POSITION == i) {
			
			Piece piece = null;
			if (j == 0 || j == 7) {
				piece = new Rook(Color.WHITE, cell, ApplicationConstants.RESOURCES_WROOK_PNG, PieceType.ROOK);
			} else if (j == 1 || j == 6) {
				piece = new Knight(Color.WHITE, cell, ApplicationConstants.RESOURCES_WKNIGHT_PNG, PieceType.KNIGHT);
			} else if (j == 2 || j == 5) {
				piece = new Bishop(Color.WHITE, cell, ApplicationConstants.RESOURCES_WBISHOP_PNG, PieceType.BISHOP);
			} else if (j == 3) {
				piece = new Queen(Color.WHITE, cell, ApplicationConstants.RESOURCES_WQUEEN_PNG, PieceType.QUEEN);
			} else if (j == 4) {
				piece = new King(Color.WHITE, cell, ApplicationConstants.RESOURCES_WKING_PNG, PieceType.KING);
			}

			cell.setOccupyingPiece(piece);
		}

	}

	private static void initiateBlackPieces(Cell cell, int i, int j) {

		if (ApplicationConstants.BLACK_START_POSITION + 1 == i) {
			cell.setOccupyingPiece(
					new Pawn(Color.BLACK, cell, ApplicationConstants.RESOURCES_BPAWN_PNG, PieceType.PAWN));
		} else if (ApplicationConstants.BLACK_START_POSITION == i) {
			Piece piece = null;
			if (j == 0 || j == 7) {
				piece = new Rook(Color.BLACK, cell, ApplicationConstants.RESOURCES_BROOK_PNG, PieceType.ROOK);
			} else if (j == 1 || j == 6) {
				piece = new Knight(Color.BLACK, cell, ApplicationConstants.RESOURCES_BKNIGHT_PNG, PieceType.KNIGHT);
			} else if (j == 2 || j == 5) {
				piece = new Bishop(Color.BLACK, cell, ApplicationConstants.RESOURCES_BBISHOP_PNG, PieceType.BISHOP);
			} else if (j == 3) {
				piece = new Queen(Color.BLACK, cell, ApplicationConstants.RESOURCES_BQUEEN_PNG, PieceType.QUEEN);
			} else if (j == 4) {
				piece = new King(Color.BLACK, cell, ApplicationConstants.RESOURCES_BKING_PNG, PieceType.KING);
			}
			cell.setOccupyingPiece(piece);
		}

	}
	
	
	public static String getPieceImageName(Color color, PieceType pieceType) {
		
		return ApplicationConstants.PIECE_IMAGE_MAP.get(pieceType.name()+"_"+color.name());
	}

}
