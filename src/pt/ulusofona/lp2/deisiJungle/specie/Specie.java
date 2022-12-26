package pt.ulusofona.lp2.deisiJungle.specie;

import pt.ulusofona.lp2.deisiJungle.Player;

abstract public class Specie {

    private int typeOfFood;
    private int energyPerCell;
    private int energyCap;
    private int ateBanana;

    public Specie() {}

    public abstract int getEnergyPerCell();

    public abstract int getEnergyCap();

    public abstract int getTypeOfFood();

    public abstract int getRecoveryEnergy();

    public abstract void setMaxSpeed(int speed);

    public abstract void setMinSpeed(int speed);

    public abstract int getMaxVelocity();

    public abstract int getMinVelocity();

    public abstract void eat(Player player);

    public abstract Player sleep(Player player);

    public abstract void move(Player player);

    public abstract int getAteBanana();

    public abstract void setAteBanana(int ateBanana);
}
