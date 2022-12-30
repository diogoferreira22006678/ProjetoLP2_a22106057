package pt.ulusofona.lp2.deisiJungle.food;

import pt.ulusofona.lp2.deisiJungle.Player;

import java.util.Random;

public class MagicMushrooms extends Food {
    Random rand = new Random();
    int nRandom = rand.nextInt(41) + 10;
    String toolTip = "Cogumelo Magico : +-"+ nRandom +"% energia";

    public MagicMushrooms(String id, int position, String imageName, String name) {
        super(id, position, imageName, name);
        this.nRandom = nRandom;
    }

    @Override
    public int getQuantity(){
        return 0;
    }

    @Override
    public int getRandomNumber(){
        return this.nRandom;
    }

    @Override
    public String getToolTip(int turn) {
        return this.toolTip;
    }

    @Override
    public Player eatFood(Player player, int turn, int nrSquare) {
        double result = nRandom;
        if(player.getSpecie().getTypeOfFood() == 1 || player.getSpecie().getTypeOfFood() == 2 || player.getSpecie().getTypeOfFood() == 3){
            if(turn % 2 == 0){
                if(player.getCurrentEnergy() * (1 + (result / 100)) > 200){
                    player.setCurrentEnergy(200);
                }else{
                    player.setCurrentEnergy((int)(player.getCurrentEnergy() * (1 + (result / 100))));
                }
                player.setFoodCount(player.getFoodCount() + 1);
            }else{
                player.setCurrentEnergy((int)(player.getCurrentEnergy() * (1 - (result / 100))) + 1);

                player.setFoodCount(player.getFoodCount() + 1);
            }
        }
        return player;
    }

    @Override
    public void setnRandom(int nRandom){this.nRandom = nRandom;}
}
