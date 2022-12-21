package pt.ulusofona.lp2.deisiJungle;

public class Lion extends Specie {

    private int typeOfFood = 2;
    int maxVelocity = 6;
    int minVelocity = 4;
    private int energyPerCell = 2;
    private int recoveryEnergy = 10;
    private int energyCap = 80;

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
    public void sleep(Player player) {
        player.setCurrentEnergy(player.getCurrentEnergy() + recoveryEnergy);
    }

    @Override
    public void move(Player player) {

    }

    public int getEnergyCap() {
        return energyCap;
    }
}
