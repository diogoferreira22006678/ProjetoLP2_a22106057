package pt.ulusofona.lp2.deisiJungle;

public class Turtle extends Specie {

    private int typeOfFood = 3;
    int maxVelocity = 3;
    int minVelocity = 1;
    private int energyPerCell = 1;
    private int recoveryEnergy = 5;
    private int energyCap = 150;

    public Turtle() {

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
        player.setCurrentEnergy(player.getCurrentEnergy() + recoveryEnergy);
        return player;
    }

    @Override
    public void move(Player player) {

    }

    public int getEnergyCap() {
        return energyCap;
    }
}
