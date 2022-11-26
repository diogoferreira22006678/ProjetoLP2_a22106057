package pt.ulusofona.lp2.deisiJungle;

import java.util.ArrayList;


public class Tabuleiro {

    Celula[] arrayCelulas;
    int tamanho;

    Celula[] celula = new Celula[tamanho];

    public Tabuleiro(){}

    public Tabuleiro(Celula[] arrayCelulas, int tamanho){
        this.arrayCelulas = arrayCelulas;
        this.tamanho = tamanho;
    }

     Tabuleiro criarTabuleiro(int tamanho){

        Celula[] jungle = new Celula[tamanho];

        for(int i = 0; i < jungle.length; i++){
            jungle[i] = new Celula(new ArrayList<>());
        }

        Tabuleiro tabuleiro = new Tabuleiro(jungle,tamanho);
        return tabuleiro;
    }

}
