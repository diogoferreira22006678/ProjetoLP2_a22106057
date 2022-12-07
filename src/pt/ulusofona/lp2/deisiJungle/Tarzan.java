package pt.ulusofona.lp2.deisiJungle;

import kotlin.Pair;

public class Tarzan extends Player {
    final int energiaInicial = 70;
    final int consumoEnergia = 2;
    final int descanso = 20;
    final Pair<Integer, Integer> velocidade = new Pair<>(1, 6);

    public Tarzan(int id, String nome, String especie,int currentEnergy, int turno,int casaAtual,String especieTotal){
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
