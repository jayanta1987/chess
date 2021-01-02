package com.chess.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	private GameWindow gameWindow;

	@GetMapping("/session")
	@ResponseBody
	public String uid(HttpSession session) {
		return session.getId();
	}

	@PostMapping(value = "/checkmoves", produces = "application/json")
	@ResponseBody
	public Move checkMoves(@RequestBody Move move, HttpSession session) {

		Piece piece = ApplicationUtil.getPieceObject(move);
		
		ChessBoard chessBoard = gameWindow.resumeGame(session.getId());
		
		List<Location> possibleMoves = boardService.findPossibleMoves(move.getCurrentLocation(), piece, chessBoard.getBoard());
		move.setPossibleMoves(possibleMoves);

		return move;
	}

	@PostMapping(value = "/moveHere", produces = "application/json")
	@ResponseBody
	public Move moveHere(@RequestBody Move move, HttpSession session) {

		ChessBoard chessBoard = gameWindow.resumeGame(session.getId());
		Cell[][] board = null;
		if(null!=chessBoard) {
			board = chessBoard.getBoard();
		}

		if (null != board) {

			Location destLoc = move.getDestinationLocation();

			if (ApplicationUtil.validatePossibleMove(destLoc, move.getColor(), board)) {
				board[move.getDestinationLocation().getxNum()][move.getDestinationLocation().getyNum()]
						.setOccupyingPiece(new Knight(Color.valueOf(move.getColor()),
								board[move.getDestinationLocation().getxNum()][move.getDestinationLocation().getyNum()],
								ApplicationUtil.getPieceImageName(Color.valueOf(move.getColor()),
										PieceType.valueOf(move.getPieceType())),
								PieceType.valueOf(move.getPieceType())));

				board[move.getCurrentLocation().getxNum()][move.getCurrentLocation().getyNum()].setOccupyingPiece(null);
			}
		}
		return move;
	}

	@RequestMapping("/")
	public ModelAndView index(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		ChessBoard chessBoard = gameWindow.resumeGame(session.getId());
		
		String displayMsg = null;
		Cell[][] board = null;
		if(null!=chessBoard) {
			
			Player you = gameWindow.findPlayerBySessionId(session.getId());
			Player opponent = gameWindow.findOpponentPlayer(session.getId());		
					
			String player1Msg = "You = "+you.getSessionId()+"_"+you.getColor().name();
			String player2Msg = "Opponent = "+opponent.getSessionId()+"_"+opponent.getColor().name();
			
			displayMsg = player1Msg+" "+player2Msg;
			
			board = chessBoard.getBoard();
		}
		modelAndView.setViewName("index");
		if (null == board) {
			String sessionId1 = session.getId();
			String sessionId2 = gameWindow.findOpponentAvailableUsers(session);
			
			if(null==sessionId2) {
				displayMsg = "Waiting For Opponent !!!";
			}else {
				chessBoard = gameWindow.startNewGame(sessionId1, sessionId2);
				board = boardService.initializeCell(chessBoard.getBoard());
				displayMsg = "Chess Board created by You ("+sessionId1+") with Opponent ("+sessionId2+")";
				
				
			}
			
			
		}
		modelAndView.addObject("board", board);
		modelAndView.addObject("chessBoard", chessBoard);
		modelAndView.addObject("displayMsg", displayMsg);
		
		return modelAndView;
	}

	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String resetGame() {

		//board = null;
		return "redirect:/";
	}
}