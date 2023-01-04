package pt.ulusofona.lp2.deisiJungle;

import pt.ulusofona.lp2.deisiJungle.specie.Specie;

import java.util.ArrayList;
import java.util.List;

public class Player {
    // instance variables
    private int id;
    private String name;
    private String species;
    private String idSpecie;
    private int currentEnergy;
    private int turn;
    private int currentHouse;
    private String totalSpecies;
    private int distanceTravelled;
    private int foodCount;
    Specie specie;
    ArrayList<String> foodNamesList = new ArrayList();

    // constructor to initialize player with given values
    public Player(int id, String name, String species,
                  int currentEnergy, int turn, int currentHouse,
                  String totalSpecies, int distanceTravelled,
                  int foodCount) {

        this.id = id;
        this.name = name;
        this.species = species;
        this.currentEnergy = currentEnergy;
        this.turn = turn;
        this.currentHouse = currentHouse;
        this.totalSpecies = totalSpecies;
        this.distanceTravelled = distanceTravelled;
        this.foodCount = foodCount;
    }

    public Player() {}

    public Player(int id, String name, String species, int currentEnergy) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.currentEnergy = currentEnergy;
    }

    public Player move(int nrSquares, Player player){

        player.distanceTravelled += Math.abs(nrSquares);
        player.currentEnergy -= Math.abs(nrSquares * player.specie.getEnergyPerCell());
        player.setCurrentHouse(player.getCurrentHouse() + nrSquares);

        return player;
    }

    // getters and setters for each instance variable

    public ArrayList<String> getFoodNames(){return foodNamesList;}

    public void addFoodName(String name){
            this.foodNamesList.add(name);
    }

    public String getidSpecie(){
        return idSpecie;
    }

    public void setidSpecie(String idSpecie){
        this.idSpecie = idSpecie;
    }

    public Specie getSpecie(){
        return specie;
    }

    public void setSpecie(Specie specie){
        this.specie = specie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getCurrentHouse() {
        return currentHouse;
    }

    public void setCurrentHouse(int currentHouse) {
        this.currentHouse = currentHouse;
    }

    public String getTotalSpecies() {
        return totalSpecies;
    }

    public void setTotalSpecies(String totalSpecies) {
        this.totalSpecies = totalSpecies;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }
}