package com.chess.core;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Piece {
    private final Color color;
    private Cell currentSquare;
    private String imgName;
    private PieceType pieceType;
    
    public Piece(Color color, Cell initSq, String imageName, PieceType pieceType) {
        this.color = color;
        this.currentSquare = initSq;
        this.imgName = imageName;   
        this.pieceType = pieceType;
    }
    
  
}