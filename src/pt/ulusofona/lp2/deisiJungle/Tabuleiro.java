package pt.ulusofona.lp2.deisiJungle;

import java.util.ArrayList;
import java.util.HashMap;

public class Tabuleiro {

    Celula[] arrayCelulas;
    int tamanho;
    int energiaInicial;

    Celula[] celula = new Celula[tamanho];

    public Tabuleiro(){}

    public Tabuleiro(Celula[] arrayCelulas, int tamanho, int energiaInicial){
        this.arrayCelulas = arrayCelulas;
        this.tamanho = tamanho;
        this.energiaInicial = energiaInicial;
    }

     Tabuleiro criarTabuleiro(int tamanho, int energiaInicial){

        Celula[] jungle = new Celula[tamanho];

        for(int i = 0; i < jungle.length; i++){
            jungle[i] = new Celula(new ArrayList<>());
        }

        Tabuleiro tabuleiro = new Tabuleiro(jungle,tamanho,energiaInicial);
        return tabuleiro;
    }

}
