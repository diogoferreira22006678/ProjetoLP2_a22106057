package pt.ulusofona.lp2.deisiJungle;

 public class Player {

     int id;
     String nome;
     String especie;
     int currentEnergy;
     int turno;
     int casaAtual;
     String especieTotal;

    public Player(int id, String nome, String especie){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
    }

    public Player(int id, String nome, String especie,int currentEnergy, int turno,int casaAtual,String especieTotal){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.currentEnergy = currentEnergy;
        this.turno = turno;
        this.casaAtual = casaAtual;
        this.especieTotal = especieTotal;
    }


     public Player() {

     }
 }
