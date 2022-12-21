package pt.ulusofona.lp2.deisiJungle;

import java.util.Random;

public class MagicMushrooms extends Food{
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
        if(player.typeOfFood == 1 || player.typeOfFood == 2 || player.typeOfFood == 3){
            if(turn % 2 == 0){
                if(player.getCurrentEnergy() * (1 + (nRandom / 100)) > player.specie.getEnergyCap()){
                    player.setCurrentEnergy(player.specie.getEnergyCap());
                }else{
                    player.setCurrentEnergy((player.getCurrentEnergy() * (1 + (nRandom / 100))));
                }
                player.setFoodCount(player.getFoodCount() + 1);
            }else{
                if(player.getCurrentEnergy() * (1 - (nRandom / 100)) < 0){
                    player.setCurrentEnergy(0);
                }else {
                    player.setCurrentEnergy((player.getCurrentEnergy() * (1 - (nRandom / 100))));
                }
                player.setFoodCount(player.getFoodCount() + 1);
            }
        }
        return player;
    }
}
