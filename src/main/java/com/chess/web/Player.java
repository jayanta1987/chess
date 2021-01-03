package com.chess.web;

import com.chess.core.Color;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
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
