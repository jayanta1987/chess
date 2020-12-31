package com.chess.web.util;

import java.util.HashMap;
import java.util.Map;

public class ApplicationConstants {

    public static final String RESOURCES_WBISHOP_PNG = "wbishop.png";
	public static final String RESOURCES_BBISHOP_PNG = "bbishop.png";
	public static final String RESOURCES_WKNIGHT_PNG = "wknight.png";
	public static final String RESOURCES_BKNIGHT_PNG = "bknight.png";
	public static final String RESOURCES_WROOK_PNG = "wrook.png";
	public static final String RESOURCES_BROOK_PNG = "brook.png";
	public static final String RESOURCES_WKING_PNG = "wking.png";
	public static final String RESOURCES_BKING_PNG = "bking.png";
	public static final String RESOURCES_BQUEEN_PNG = "bqueen.png";
	public static final String RESOURCES_WQUEEN_PNG = "wqueen.png";
	public static final String RESOURCES_WPAWN_PNG = "wpawn.png";
	public static final String RESOURCES_BPAWN_PNG = "bpawn.png";
	
	
	public static final int BLACK_START_POSITION = 0;
	public static final int BOARD_SIZE = 8;
	public static final int WHITE_START_POSITION = BOARD_SIZE -1;
	
	
	public static final Map<String, String> PIECE_IMAGE_MAP = new HashMap<>() {{
	    put("BISHOP_WHITE", RESOURCES_WBISHOP_PNG);
	    put("BISHOP_BLACK", RESOURCES_BBISHOP_PNG);
	    
	    put("KNIGHT_WHITE", RESOURCES_WKNIGHT_PNG);
	    put("KNIGHT_BLACK", RESOURCES_BKNIGHT_PNG);
	    
	    put("ROOK_WHITE", RESOURCES_WROOK_PNG);
	    put("ROOK_BLACK", RESOURCES_BROOK_PNG);
	    
	    put("KING_WHITE", RESOURCES_WKING_PNG);
	    put("KING_BLACK", RESOURCES_BKING_PNG);
	    
	    put("QUEEN_WHITE", RESOURCES_WQUEEN_PNG);
	    put("QUEEN_BLACK", RESOURCES_BQUEEN_PNG);
	    
	    put("PAWN_WHITE", RESOURCES_WPAWN_PNG);
	    put("PAWN_BLACK", RESOURCES_BPAWN_PNG);
	   
	}};
}
