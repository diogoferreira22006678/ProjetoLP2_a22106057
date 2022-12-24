package pt.ulusofona.lp2.deisiJungle.specie;

import pt.ulusofona.lp2.deisiJungle.Player;

public class Bird extends Specie {

    private int typeOfFood = 3;
    int maxVelocity = 6;
    int minVelocity = 5;
    private int energyPerCell = 4;
    private int recoveryEnergy = 50;
    private int energyCap = 70;
    private int ateBanana = 0;

    public Bird() {
    }

    @Override
    public int getRecoveryEnergy(){
        return recoveryEnergy;
    }

    @Override
    public int getEnergyPerCell(){
        return energyPerCell;
    }

    @Override
    public int getTypeOfFood() {
        return typeOfFood;
    }

    @Override
    public int getMaxVelocity(){
        return maxVelocity;
    }

    @Override
    public int getMinVelocity(){
        return minVelocity;
    }

    @Override
    public void eat(Player player) {

    }

    @Override
    public Player sleep(Player player) {
        if(player.getCurrentEnergy() + recoveryEnergy > 200){
            player.setCurrentEnergy(200);
        }else {
            player.setCurrentEnergy(player.getCurrentEnergy() + recoveryEnergy);
        }
        return player;
    }

    @Override
    public void move(Player player) {

    }

    @Override
    public int getAteBanana() {
        return this.ateBanana;
    }

    @Override
    public void setAteBanana(int ateBanana) {
        this.ateBanana = ateBanana;
    }

    public int getEnergyCap() {
        return energyCap;
    }
}
