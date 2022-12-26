package pt.ulusofona.lp2.deisiJungle.specie;

import pt.ulusofona.lp2.deisiJungle.Player;

public class Lion extends Specie {

    private int typeOfFood = 2;
    int maxVelocity ;
    int minVelocity ;
    private int energyPerCell = 2;
    private int recoveryEnergy = 10;
    private int ateBanana = 0;

    public Lion() {
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
    public void setMaxSpeed(int speed){
        this.maxVelocity = speed;
    }

    @Override
    public void setMinSpeed(int speed){
        this.minVelocity = speed;
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
    public Player sleep(Player player) {
        if(player.getCurrentEnergy() + recoveryEnergy > 200){
            player.setCurrentEnergy(200);
        }else {
            player.setCurrentEnergy(player.getCurrentEnergy() + recoveryEnergy);
        }
        return player;
    }

    @Override
    public int getAteBanana() {
        return this.ateBanana;
    }

    @Override
    public void setAteBanana(int ateBanana) {
        this.ateBanana = ateBanana;
    }
}
