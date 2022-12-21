package pt.ulusofona.lp2.deisiJungle;

abstract public class Food{

    private String id;
    private int position;

    public Food(String id, int position){
        this.id = id;
        this.position = position;
    }

    abstract public void eatFood(Player player, int turn, int nrSquare);
}
