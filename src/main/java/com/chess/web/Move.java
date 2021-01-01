package com.chess.web;

import java.util.List;

import com.chess.core.Color;
import com.chess.core.Location;
import com.chess.core.PieceType;
import com.chess.web.util.ApplicationUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Move {
	private String pieceType;
	
	private String piece;
		
	private Location currentLocation;
	
	private Location destinationLocation;
	
	private List<Location> possibleMoves;
	
	private boolean moveAllowed;

	private String imageName;
	private String color;

	public String getImageName() {
		if(Color.BLACK.name().equals(color)) {
			return ApplicationUtil.getPieceImageName(Color.BLACK, PieceType.valueOf(pieceType));
			
		}else {
			return ApplicationUtil.getPieceImageName(Color.WHITE, PieceType.valueOf(pieceType));
		}
		
	}

	public String getPieceType() {
		return pieceType;
	}



	public void setPieceType(String pieceType) {
		this.pieceType = pieceType;
	}



	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public List<Location> getPossibleMoves() {
		return possibleMoves;
	}

	public void setPossibleMoves(List<Location> possibleMoves) {
		this.possibleMoves = possibleMoves;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Location getDestinationLocation() {
		return destinationLocation;
	}

	public void setDestinationLocation(Location destinationLocation) {
		this.destinationLocation = destinationLocation;
	}

	public boolean isMoveAllowed() {
		return moveAllowed;
	}

	public void setMoveAllowed(boolean moveAllowed) {
		this.moveAllowed = moveAllowed;
	}

	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	
	
	

	
}