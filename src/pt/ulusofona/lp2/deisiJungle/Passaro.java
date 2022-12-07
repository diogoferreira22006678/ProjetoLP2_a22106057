package pt.ulusofona.lp2.deisiJungle;

import kotlin.Pair;

public class Passaro extends Player {
    int energiaInicial = 70;
    int consumoEnergia = 4;
    int descanso = 50;
    Pair<Integer, Integer> velocidade = new Pair<>(5, 6);

    public Passaro(int id, String nome, String especie,int currentEnergy, int turno,int casaAtual,String especieTotal){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.currentEnergy = currentEnergy;
        this.turno = turno;
        this.casaAtual = casaAtual;
        this.especieTotal = especieTotal;
    }

    void moveCost(Passaro player){
        player.currentEnergy -= consumoEnergia;
    }

    void sleep(Passaro player){
        player.currentEnergy += descanso;
    }

    int[] getSpeed(){
        int[] speeds = new int[2];
        speeds[1] = velocidade.getFirst();
        speeds[2] = velocidade.getSecond();
        return speeds;
    }
}
