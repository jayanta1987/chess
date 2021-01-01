package com.chess.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chess.core.Cell;
import com.chess.core.Color;
import com.chess.core.Knight;
import com.chess.core.Location;
import com.chess.core.Piece;
import com.chess.core.PieceType;
import com.chess.web.services.BoardService;
import com.chess.web.util.ApplicationUtil;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {

	private BoardService boardService;

	private static Cell[][] board = null;

	@PostMapping(value = "/checkmoves", produces = "application/json")
	@ResponseBody
	public Move checkMoves(@RequestBody Move move) {
		
		Piece piece = ApplicationUtil.getPieceObject(move); 

		List<Location> possibleMoves = boardService.findPossibleMoves(move.getCurrentLocation(), piece, board);
		move.setPossibleMoves(possibleMoves);

		return move;
	}

	@PostMapping(value = "/moveHere", produces = "application/json")
	@ResponseBody
	public Move moveHere(@RequestBody Move move) {
		
		Piece piece = ApplicationUtil.getPieceObject(move); 

		if (null != board) {
			
			Location destLoc = move.getDestinationLocation();
			
			if (ApplicationUtil.validatePossibleMove(destLoc,  move.getColor(), board)) {
				board[move.getDestinationLocation().getxNum()][move.getDestinationLocation().getyNum()].setOccupyingPiece(new Knight(Color.valueOf(move.getColor()), board[move.getDestinationLocation().getxNum()][move.getDestinationLocation().getyNum()],
						ApplicationUtil.getPieceImageName(Color.valueOf(move.getColor()), PieceType.valueOf(move.getPieceType())), PieceType.valueOf(move.getPieceType())));

				board[move.getCurrentLocation().getxNum()][move.getCurrentLocation().getyNum()].setOccupyingPiece(null);
			}
		}
		return move;
	}

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		if (null == board) {
			board = boardService.initializeCell(board);
		}
		modelAndView.addObject("board", board);

		return modelAndView;
	}
	
	
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String resetGame() {
		
		board = null;
		return "redirect:/";
	}
}