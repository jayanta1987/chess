package com.chess.core;

public class Location {
	
	private int xNum;
	private int yNum;
	
	private boolean killable;
		
	public Location(int xNum, int yNum) {
		this.xNum = xNum;
		this.yNum = yNum;
	}

	public boolean isKillable() {
		return killable;
	}

	public void setKillable(boolean killable) {
		this.killable = killable;
	}

	public int getxNum() {
		return xNum;
	}

	public int getyNum() {
		return yNum;
	}
	
	
	
	
}
