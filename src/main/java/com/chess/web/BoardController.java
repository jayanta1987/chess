package com.chess.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chess.core.Cell;
import com.chess.core.Location;
import com.chess.web.services.BoardService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {
	
	private BoardService boardService;

	private Cell[][] board;
	
	@PostMapping(value ="/checkmoves",  produces = "application/json")
	@ResponseBody
	public Move checkMoves(@RequestBody Move move) {
		
		List<Location> possibleMoves = boardService.findPossibleMoves(move.getCurrentLocation(), move.getPiecetype(),move.getColor());
		move.setPossibleMoves(possibleMoves);
		
	    return move;
	}

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		board = boardService.initializeCell(board);
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