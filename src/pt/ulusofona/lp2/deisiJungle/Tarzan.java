package pt.ulusofona.lp2.deisiJungle;

public class Tarzan extends Player {
    final int energiaInicial = 70;
    final int consumoEnergia = 2;
    final int descanso = 20;
    int[] velocidade = new int[2];

    public Tarzan(int id, String nome, String especie,int currentEnergy, int turno,int casaAtual,String especieTotal){
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
