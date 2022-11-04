package pt.ulusofona.lp2.deisiJungle;

public class Player {

    int id;
    String nome;
    String especie;
    int currentEnergy;

    public Player(){}

    public Player(int id, String nome, String especie){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
    }

    public Player(int id, String nome, String especie,int currentEnergy){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.currentEnergy = currentEnergy;
    }

}
