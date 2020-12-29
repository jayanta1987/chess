package com.chess.core;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Location {
	
	private int xNum;
	private int yNum;
	
	public int getxNum() {
		return xNum;
	}
	public void setxNum(int xNum) {
		this.xNum = xNum;
	}
	public int getyNum() {
		return yNum;
	}
	public void setyNum(int yNum) {
		this.yNum = yNum;
	}

	
	
}
