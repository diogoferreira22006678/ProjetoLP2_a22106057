package pt.ulusofona.lp2.deisiJungle.food;

import pt.ulusofona.lp2.deisiJungle.Player;

import java.util.ArrayList;

public class Bananas extends Food {

    int quantity;
    String toolTip = "Bananas : ";
    ArrayList<Player> playersAte = new ArrayList<>();

    public Bananas(String id, int position, String imageName,int quantity, String name) {
        super(id, position, imageName, name);
        this.quantity = quantity;
    }

    @Override
    public void setnRandom(int nRandom){}

     @Override
     public int getQuantity(){
        return this.quantity;
    }

     @Override
     public int getRandomNumber(){
        return 0;
    }

    @Override
    public String getToolTip(int turn) {
        return this.toolTip + quantity + " : + 40 energia";
    }

    @Override
    public Player eatFood(Player player, int turn, int nrSquare) {

        if (quantity > 0) {
                if(player.getSpecie().getAteBanana() == 1){
                    if (player.getSpecie().getTypeOfFood() == 1 || player.getSpecie().getTypeOfFood() == 2 || player.getSpecie().getTypeOfFood() == 3) {
                        if(player.getCurrentEnergy() - 40 < 0){
                            player.setCurrentEnergy(0);
                        }else {
                            player.setCurrentEnergy(player.getCurrentEnergy() - 40);
                        }
                        player.setFoodCount(player.getFoodCount() + 1);
                        quantity--;
                    }
                    return player;
                }

                if (player.getSpecie().getTypeOfFood() == 1 || player.getSpecie().getTypeOfFood() == 2 || player.getSpecie().getTypeOfFood() == 3) {
                    if(player.getCurrentEnergy() + 40 > 200){
                        player.setCurrentEnergy(200);
                    }else {
                        player.setCurrentEnergy(player.getCurrentEnergy() + 40);
                    }
                    playersAte.add(player);
                    player.setFoodCount(player.getFoodCount() + 1);
                    quantity--;
                    player.getSpecie().setAteBanana(1);
                }
        }

        return player;
    }


}
