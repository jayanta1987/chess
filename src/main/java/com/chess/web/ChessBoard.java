package com.chess.web;

import com.chess.core.Cell;
import com.chess.core.Color;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ChessBoard {

	private Player player1;
	private Player player2;
	private Cell[][] board;
	
	private Color currentTurn;
	
	private String msg;
	
	private Status status;

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setCurrentTurn(Color currentTurn) {
		this.currentTurn = currentTurn;
	}
		
	
	
}
