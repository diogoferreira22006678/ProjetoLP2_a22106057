package pt.ulusofona.lp2.deisiJungle.Food;

import pt.ulusofona.lp2.deisiJungle.Food.Food;
import pt.ulusofona.lp2.deisiJungle.Player;

import java.util.Random;

public class MagicMushrooms extends Food {
    Random rand = new Random();
    int nRandom = rand.nextInt(50) + 1;
    String toolTip = "Cogumelo Magico: +- "+ nRandom +"% energia";

    public MagicMushrooms(String id, int position, String imageName, int nRandom, String name) {
        super(id, position, imageName, name);
        this.nRandom = nRandom;
    }

    @Override
    public String getToolTip(int turn) {
        return this.toolTip;
    }

    @Override
    public Player eatFood(Player player, int turn, int nrSquare) {
        if(player.specie.getTypeOfFood() == 1 || player.specie.getTypeOfFood() == 2 || player.specie.getTypeOfFood() == 3){
            if(turn % 2 == 0){
                if(player.getCurrentEnergy() * (1 + (nRandom / 100)) > 200){
                    player.setCurrentEnergy(200);
                }else{
                    player.setCurrentEnergy((player.getCurrentEnergy() * (1 + (nRandom / 100))));
                }
                player.setFoodCount(player.getFoodCount() + 1);
            }else{
                player.setCurrentEnergy((player.getCurrentEnergy() * (1 - (nRandom / 100))));

                player.setFoodCount(player.getFoodCount() + 1);
            }
        }
        return player;
    }
}
