package pt.ulusofona.lp2.deisiJungle;

public class Leao extends Player {
    int energiaInicial = 80;
    int consumoEnergia = 2;
    int descanso = 10;
    int[] velocidade = new int[2];

    public Leao(int id, String nome, String especie,int currentEnergy, int turno,int casaAtual,String especieTotal){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.currentEnergy = currentEnergy;
        this.turno = turno;
        this.casaAtual = casaAtual;
        this.especieTotal = especieTotal;
        this.velocidade[0] = 4;
        this.velocidade[1] = 1;
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
