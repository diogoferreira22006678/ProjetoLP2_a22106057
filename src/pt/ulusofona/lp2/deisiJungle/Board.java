package pt.ulusofona.lp2.deisiJungle;

import java.util.ArrayList;


public class Board {

    Cell[] arrayCells;
    int length;

    public Board(){}

    public Board(Cell[] arrayCells, int length){
        this.arrayCells = arrayCells;
        this.length = length;
    }

    Board createBoard(int tamanho){

        Cell[] jungle = new Cell[tamanho];

        for(int i = 0; i < jungle.length; i++){
            jungle[i] = new Cell(new ArrayList<>());
        }

        Board tabuleiro = new Board(jungle,tamanho);
        return tabuleiro;
    }

}
