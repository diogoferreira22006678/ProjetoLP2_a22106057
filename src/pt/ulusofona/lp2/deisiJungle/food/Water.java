package pt.ulusofona.lp2.deisiJungle.food;

import pt.ulusofona.lp2.deisiJungle.Player;

public class Water extends Food {

    String toolTip = "Agua : + 15U|20% energia";

    public Water(String id, int position, String imageName, String name) {
        super(id, position, imageName, name);
    }

    @Override
    public String getToolTip(int turn) {
        return this.toolTip;
    }

    @Override
    public Player eatFood(Player player, int turn, int nrSquare) {

        if(player.specie.getTypeOfFood() == 1 || player.specie.getTypeOfFood() == 2){
            if(player.getCurrentEnergy() + 15 > 200){
                player.setCurrentEnergy(200);
            }else {
                player.setCurrentEnergy(player.getCurrentEnergy() + 15);
            }
            player.setFoodCount(player.getFoodCount() + 1);
        }

        if(player.specie.getTypeOfFood() == 3){
            if(player.getCurrentEnergy() * 1.2 > 200){
                player.setCurrentEnergy(200);
            }else {
                player.setCurrentEnergy((int) (player.getCurrentEnergy() * 1.2));
            }
            player.setFoodCount(player.getFoodCount() + 1);
        }
        return player;
    }
}