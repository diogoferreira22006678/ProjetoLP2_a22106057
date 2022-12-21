package pt.ulusofona.lp2.deisiJungle;

abstract public class Specie {

    private int TypeOfFood;
    private int energyPerCell;

    public Specie() {}

    public abstract int getEnergyPerCell();

    public abstract int getTypeOfFood();

    public abstract int getRecoveryEnergy();

    public abstract int getMaxVelocity();

    public abstract int getMinVelocity();

    public abstract void eat(Player player);

    public abstract void sleep(Player player);

    public abstract void move(Player player);
}
