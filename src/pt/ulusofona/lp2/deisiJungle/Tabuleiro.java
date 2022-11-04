package pt.ulusofona.lp2.deisiJungle;

public class Tabuleiro {

    Celula[] arrayCelulas;
    int tamanho;
    int energiaInicial;

    public Tabuleiro(){}

    public Tabuleiro(Celula[] arrayCelulas, int tamanho, int energiaInicial){
        this.arrayCelulas = arrayCelulas;
        this.tamanho = tamanho;
        this.energiaInicial = energiaInicial;
    }

     void criarTabuleiro(int tamanho, int energiaInicial, Celula[] jungle){
        Tabuleiro tabuleiro = new Tabuleiro(jungle,tamanho,energiaInicial);
    }

}
