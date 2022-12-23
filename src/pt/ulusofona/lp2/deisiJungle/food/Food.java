package pt.ulusofona.lp2.deisiJungle.food;

import pt.ulusofona.lp2.deisiJungle.Player;

abstract public class Food{

    private String id;
    private int position;
    private String imageName;
    private String name;
    private String toolTip;

    public Food(String id, int position, String imageName, String name){
        this.id = id;
        this.position = position;
        this.imageName = imageName;
        this.name = name;
    }

    public Food(){}

    abstract public String getToolTip(int turn);

    abstract public Player eatFood(Player player, int turn, int nrSquare);

    public String getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public String getImageName() {
        return imageName;
    }

    public String getName() {
        return name;
    }
}
