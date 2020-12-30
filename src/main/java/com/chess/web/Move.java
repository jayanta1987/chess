package com.chess.web;

import java.util.List;

import com.chess.core.Color;
import com.chess.core.Location;
import com.chess.core.PieceType;
import com.chess.web.util.ApplicationConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Move {
	private String piecetype;
		
	private Location currentLocation;
	
	private Location destinationLocation;
	
	private List<Location> possibleMoves;
	
	private boolean moveAllowed;

	private String imageName;
	private String color;

	public String getImageName() {
		if(Color.BLACK.name().equals(color)) {
			if (PieceType.QUEEN.name().equals(piecetype)) {
				return ApplicationConstants.RESOURCES_BQUEEN_PNG;
			}else if (PieceType.BISHOP.name().equals(this.piecetype)) {
				return ApplicationConstants.RESOURCES_BBISHOP_PNG;
			}else if (PieceType.KING.name().equals(this.piecetype)) {
				return ApplicationConstants.RESOURCES_BKING_PNG;
			}else if (PieceType.ROOK.name().equals(this.piecetype)) {
				return ApplicationConstants.RESOURCES_BROOK_PNG;
			}else if (PieceType.KNIGHT.name().equals(this.piecetype)) {
				return ApplicationConstants.RESOURCES_BKNIGHT_PNG;
			}
			return ApplicationConstants.RESOURCES_BPAWN_PNG;
		}else {
			if (PieceType.QUEEN.name().equals(piecetype)) {
				return ApplicationConstants.RESOURCES_WQUEEN_PNG;
			}else if (PieceType.BISHOP.name().equals(this.piecetype)) {
				return ApplicationConstants.RESOURCES_WBISHOP_PNG;
			}else if (PieceType.KING.name().equals(this.piecetype)) {
				return ApplicationConstants.RESOURCES_WKING_PNG;
			}else if (PieceType.ROOK.name().equals(this.piecetype)) {
				return ApplicationConstants.RESOURCES_WROOK_PNG;
			}else if (PieceType.KNIGHT.name().equals(this.piecetype)) {
				return ApplicationConstants.RESOURCES_WKNIGHT_PNG;
			}
			return ApplicationConstants.RESOURCES_WPAWN_PNG;
		}
		
	}

	public String getPiecetype() {
		return piecetype;
	}

	public void setPiecetype(String piecetype) {
		this.piecetype = piecetype;
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

	
	

	
}