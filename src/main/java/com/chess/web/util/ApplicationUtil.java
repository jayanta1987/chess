package com.chess.web.util;

import java.util.List;

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
import com.chess.web.Move;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApplicationUtil {

	public static Piece getPieceObject(Move move) {
		Piece piece = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			if (PieceType.KNIGHT.name().equals(move.getPieceType())) {
				piece = objectMapper.readValue(move.getPiece(), Knight.class);
			} else if (PieceType.ROOK.name().equals(move.getPieceType())) {
				piece = objectMapper.readValue(move.getPiece(), Rook.class);
			} else if (PieceType.BISHOP.name().equals(move.getPieceType())) {
				piece = objectMapper.readValue(move.getPiece(), Bishop.class);
			} else if (PieceType.QUEEN.name().equals(move.getPieceType())) {
				piece = objectMapper.readValue(move.getPiece(), Queen.class);
			} else if (PieceType.PAWN.name().equals(move.getPieceType())) {
				piece = objectMapper.readValue(move.getPiece(), Pawn.class);
			} else if (PieceType.KING.name().equals(move.getPieceType())) {
				piece = objectMapper.readValue(move.getPiece(), King.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return piece;
	}

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

	public static boolean validatePossibleMove(Location location, String pieceColor, Cell[][] board) {

		if (location.getxNum() < 0 || location.getxNum() > 7 || location.getyNum() < 0 || location.getyNum() > 7) {
			return false;
		}
		if (null != board[location.getxNum()][location.getyNum()].getOccupyingPiece()) {
			if (pieceColor
					.equals(board[location.getxNum()][location.getyNum()].getOccupyingPiece().getColor().toString())) {
				return false;
			}else {
				location.setKillable(true);
			}

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
			cell.setOccupyingPiece(new Pawn(Color.WHITE, cell,
					ApplicationUtil.getPieceImageName(Color.WHITE, PieceType.PAWN), PieceType.PAWN));
		} else if (ApplicationConstants.WHITE_START_POSITION == i) {

			Piece piece = null;
			if (j == 0 || j == 7) {
				piece = new Rook(Color.WHITE, cell, ApplicationUtil.getPieceImageName(Color.WHITE, PieceType.ROOK),
						PieceType.ROOK);
			} else if (j == 1 || j == 6) {
				piece = new Knight(Color.WHITE, cell, ApplicationUtil.getPieceImageName(Color.WHITE, PieceType.KNIGHT),
						PieceType.KNIGHT);
			} else if (j == 2 || j == 5) {
				piece = new Bishop(Color.WHITE, cell, ApplicationUtil.getPieceImageName(Color.WHITE, PieceType.BISHOP),
						PieceType.BISHOP);
			} else if (j == 3) {
				piece = new Queen(Color.WHITE, cell, ApplicationUtil.getPieceImageName(Color.WHITE, PieceType.QUEEN),
						PieceType.QUEEN);
			} else if (j == 4) {
				piece = new King(Color.WHITE, cell, ApplicationUtil.getPieceImageName(Color.WHITE, PieceType.KING),
						PieceType.KING);
			}

			cell.setOccupyingPiece(piece);
		}

	}

	private static void initiateBlackPieces(Cell cell, int i, int j) {

		if (ApplicationConstants.BLACK_START_POSITION + 1 == i) {
			cell.setOccupyingPiece(new Pawn(Color.BLACK, cell,
					ApplicationUtil.getPieceImageName(Color.BLACK, PieceType.PAWN), PieceType.PAWN));
		} else if (ApplicationConstants.BLACK_START_POSITION == i) {
			Piece piece = null;
			if (j == 0 || j == 7) {
				piece = new Rook(Color.BLACK, cell, ApplicationUtil.getPieceImageName(Color.BLACK, PieceType.ROOK),
						PieceType.ROOK);
			} else if (j == 1 || j == 6) {
				piece = new Knight(Color.BLACK, cell, ApplicationUtil.getPieceImageName(Color.BLACK, PieceType.KNIGHT),
						PieceType.KNIGHT);
			} else if (j == 2 || j == 5) {
				piece = new Bishop(Color.BLACK, cell, ApplicationUtil.getPieceImageName(Color.BLACK, PieceType.BISHOP),
						PieceType.BISHOP);
			} else if (j == 3) {
				piece = new Queen(Color.BLACK, cell, ApplicationUtil.getPieceImageName(Color.BLACK, PieceType.QUEEN),
						PieceType.QUEEN);
			} else if (j == 4) {
				piece = new King(Color.BLACK, cell, ApplicationUtil.getPieceImageName(Color.BLACK, PieceType.KING),
						PieceType.KING);
			}
			cell.setOccupyingPiece(piece);
		}

	}

	public static String getPieceImageName(Color color, PieceType pieceType) {

		return ApplicationConstants.PIECE_IMAGE_MAP.get(pieceType.name() + "_" + color.name());
	}

	public static boolean validateLinearSearchLocationAndAddPossibleMove(String color, Cell[][] board,
			List<Location> possibleMoves, int xNum, int yNum) {
		Location loc = new Location(xNum, yNum);
		if (ApplicationUtil.validatePossibleMove(loc, color, board)) {
			possibleMoves.add(loc);
			if (null != board[loc.getxNum()][loc.getyNum()].getOccupyingPiece()) {
				return false;
			}
		} else {
			return false;
		}

		return true;
	}

}
