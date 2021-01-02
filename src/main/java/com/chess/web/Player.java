package com.chess.web;

import com.chess.core.Color;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {

	private String sessionId;
	private Color color;
	
	
	public String getSessionId() {
		return sessionId;
	}
	public Color getColor() {
		return color;
	}
	
	
}
