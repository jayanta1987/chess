package com.chess.core;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cell  {
    
    private Piece occupyingPiece;
    private Color color;
    
    private int xNum;
    private int yNum;
    
    private String value;
    private String cssClass;
    
   
}
