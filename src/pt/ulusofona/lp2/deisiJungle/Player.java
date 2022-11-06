package pt.ulusofona.lp2.deisiJungle;

 class Player {

     int id;
     String nome;
     String especie;
     int currentEnergy;
     int turno;
     int casaAtual;

    public Player(int id, String nome, String especie){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
    }

    public Player(int id, String nome, String especie,int currentEnergy, int turno,int casaAtual){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.currentEnergy = currentEnergy;
        this.turno = turno;
        this.casaAtual = casaAtual;
    }


     public Player() {

     }
 }
