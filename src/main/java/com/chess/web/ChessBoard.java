package com.chess.web;

import com.chess.core.Cell;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ChessBoard {

	private Player player1;
	private Player player2;
	private Cell[][] board;
	
	private String msg;
	
	private Status status;

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
		
}
