package pt.ulusofona.lp2.deisiJungle;


public class Elefante extends Player {
    int energiaInicial = 180;
    int consumoEnergia = 4;
    int descanso = 10;
    int[] velocidade = new int[2];

    public Elefante(int id, String nome, String especie,int currentEnergy, int turno,int casaAtual,String especieTotal){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.currentEnergy = currentEnergy;
        this.turno = turno;
        this.casaAtual = casaAtual;
        this.especieTotal = especieTotal;
        this.velocidade[0] = 1;
        this.velocidade[1] = 6;
    }

    void moveCost(Passaro player){
        player.currentEnergy -= consumoEnergia;
    }

    void sleep(Passaro player){
        player.currentEnergy += descanso;
    }

    int[] getSpeed(){
        return velocidade;
    }
}
