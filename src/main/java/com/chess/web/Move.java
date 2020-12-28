package com.chess.web;

import com.chess.core.Color;
import com.chess.core.PieceType;
import com.chess.web.util.ApplicationConstants;

public class Move {
	String piecetype;
	String xNum;
	String yNum;

	String imageName;
	String color;

	public String getPiecetype() {
		return piecetype;
	}

	public void setPiecetype(String piecetype) {
		this.piecetype = piecetype;
	}

	public String getxNum() {
		return xNum;
	}

	public void setxNum(String xNum) {
		this.xNum = xNum;
	}

	public String getyNum() {
		return yNum;
	}

	public void setyNum(String yNum) {
		this.yNum = yNum;
	}

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

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
}