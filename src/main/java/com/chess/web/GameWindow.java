package com.chess.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.chess.core.Cell;
import com.chess.core.Color;
import com.chess.web.util.ApplicationConstants;

@Service
public class GameWindow {

	private static Map<String, ChessBoard> runningBoardMap = new HashMap<>();

	private static Map<String, Player> playerMap = new HashMap<>();

	private static List<String> availableUsers = new ArrayList<>();

	public ChessBoard resumeGame(String sessionId) {

		ChessBoard chessboard = null;

		if (checkPlayerExists(sessionId)) {

			Player you = playerMap.get(sessionId);
			Player opponent = findOpponentPlayer(sessionId);
			chessboard = getGameBoard(you, opponent);
		}

		return chessboard;
	}

	public String findOpponentAvailableUsers(HttpSession session) {

		String opponentSessionID = null;
		if (!availableUsers.isEmpty() && availableUsers.size() > 0) {
			opponentSessionID = availableUsers.get(0);
			availableUsers.remove(0);
		}
		
		String currentSessionId = session.getId();

		if (!availableUsers.contains(currentSessionId)) {
			availableUsers.add(currentSessionId);
		}
		
		return opponentSessionID;

	}
	
	public Player findPlayerBySessionId(String sessionId) {
		return playerMap.get(sessionId);
	}

	public ChessBoard startNewGame(String yourSessionId, String opponentSessionId) {

		Player player1 = createPlayer(yourSessionId, Color.WHITE);
		Player player2 = createPlayer(opponentSessionId, Color.BLACK);

		playerMap.put(yourSessionId, player1);
		playerMap.put(opponentSessionId, player2);

		deleteInactiveBoard(player1, player2);
		Cell[][] board = new Cell[ApplicationConstants.BOARD_SIZE][ApplicationConstants.BOARD_SIZE];
		ChessBoard chessboard = new ChessBoard(player1, player2, board, null, Status.ACTIVE);

		String gameId = yourSessionId + "_" + opponentSessionId;

		runningBoardMap.put(gameId, chessboard);

		return chessboard;
	}

	private boolean checkPlayerExists(String sessionId) {
		return playerMap.containsKey(sessionId);
	}

	public Player findOpponentPlayer(String sessionId) {

		String gameId = findPartialActivePlayerKey(sessionId);

		String[] sessionIds = gameId.split("_");

		if (sessionIds.length == 2) {
			if (sessionIds[0].equals(sessionId)) {
				return playerMap.get(sessionIds[1]);
			} else {
				return playerMap.get(sessionIds[0]);
			}
		}

		return null;
	}

	private Player createPlayer(String sessionId, Color color) {
		return new Player(sessionId, color);
	}

	private ChessBoard getGameBoard(Player player1, Player player2) {

		ChessBoard chessboard = null;
		String gameId = player1.getSessionId() + "_" + player2.getSessionId();
		String gameIdInverse = player2.getSessionId() + "_" + player1.getSessionId();

		if (runningBoardMap.containsKey(gameId)) {
			chessboard = runningBoardMap.get(gameId);
		} else if (runningBoardMap.containsKey(gameIdInverse)) {
			chessboard = runningBoardMap.get(gameIdInverse);
		}

		return chessboard;
	}

	public Status getGameStatus(Player player1, Player player2) {

		if (null != player1.getSessionId() && null != player2.getSessionId()) {
			ChessBoard chessboard = getGameBoard(player1, player2);
			return chessboard.getStatus();

		}

		deleteInactiveBoard(player1, player2);
		return Status.INACTIVE;
	}

	private void deleteInactiveBoard(Player player1, Player player2) {

		String sessionId1 = player1.getSessionId();
		String sessionId2 = player2.getSessionId();
		String key = null;

		if (null != sessionId1) {
			key = findPartialActivePlayerKey(sessionId1);
		} else if (null != sessionId2) {
			key = findPartialActivePlayerKey(sessionId2);
		}
		if (null != key)
			runningBoardMap.remove(key);

	}

	private String findPartialActivePlayerKey(String sessionId) {
		for (Map.Entry<String, ChessBoard> entry : runningBoardMap.entrySet()) {
			if (entry.getKey().contains(sessionId)) {
				return entry.getKey();
			}
		}
		return null;
	}

}
