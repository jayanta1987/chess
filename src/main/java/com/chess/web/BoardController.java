package com.chess.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chess.core.Cell;
import com.chess.core.Color;
import com.chess.core.Knight;
import com.chess.core.Location;
import com.chess.core.PieceType;
import com.chess.web.services.BoardService;
import com.chess.web.util.ApplicationConstants;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {

	private BoardService boardService;

	private static Cell[][] board = null;

	@PostMapping(value = "/checkmoves", produces = "application/json")
	@ResponseBody
	public Move checkMoves(@RequestBody Move move) {

		List<Location> possibleMoves = boardService.findPossibleMoves(move.getCurrentLocation(), move.getPiecetype(),
				move.getColor(), board);
		move.setPossibleMoves(possibleMoves);

		return move;
	}

	@GetMapping(value = "/moveHere", produces = "application/json")
	public String moveHere(@RequestParam int xNum, @RequestParam int yNum, @RequestParam String pieceType,
			@RequestParam String color, @RequestParam int fromXNum, @RequestParam int fromYNum) {
		if (null != board) {
			boolean isMoveAllowed = true;
			if (null != board[xNum][yNum].getOccupyingPiece()
					&& color.equals(board[xNum][yNum].getOccupyingPiece().getColor().toString())) {

				isMoveAllowed = false;
			}

			if (isMoveAllowed) {
				board[xNum][yNum].setOccupyingPiece(new Knight(Color.WHITE, board[xNum][yNum],
						ApplicationConstants.RESOURCES_WKNIGHT_PNG, PieceType.KNIGHT));

				board[fromXNum][fromYNum].setOccupyingPiece(null);
			}
		}
		return "redirect:/";
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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Move user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user-data");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
}