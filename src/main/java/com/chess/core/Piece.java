package com.chess.core;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Piece {
	private Color color;
	private Cell currentSquare;
	private String imgName;
	private PieceType pieceType;

	public Piece(Color color, Cell initSq, String imageName, PieceType pieceType) {
		this.color = color;
		this.currentSquare = initSq;
		this.imgName = imageName;
		this.pieceType = pieceType;
	}
	public Piece() {};

	public abstract List<Location> findPossibleMoves(Location location, String color, Cell[][] board);
	
}