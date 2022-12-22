package pt.ulusofona.lp2.deisiJungle.Food;

import pt.ulusofona.lp2.deisiJungle.Food.Food;
import pt.ulusofona.lp2.deisiJungle.Player;

public class Meat extends Food {

    String toolTip = "Carne : + 50 energia : ";

    public Meat(String id, int position, String imageName, String name) {
        super(id, position, imageName, name);
    }

    @Override
    public String getToolTip(int turn) {
        if(turn <= 12) {
            return this.toolTip + turn + " jogadas";
        }else{
            return "Carne toxica";
        }
    }

    @Override
    public Player eatFood(Player player, int turn, int nrSquare) {

        if (player.specie.getTypeOfFood() == 1) {
            return player;
        }

        if(turn <= 12) {
            if (player.specie.getTypeOfFood() == 2 || player.specie.getTypeOfFood() == 3) {
                if(player.getCurrentEnergy() + 50 > 200){
                    player.setCurrentEnergy(200);
                }else {
                    player.setCurrentEnergy(player.getCurrentEnergy() + 50);
                }
                player.setFoodCount(player.getFoodCount() + 1);
            }
        }else{
            if (player.specie.getTypeOfFood() == 2 || player.specie.getTypeOfFood() == 3) {
                player.setCurrentEnergy((int) (player.getCurrentEnergy() * 0.5));
                player.setFoodCount(player.getFoodCount() + 1);
            }

        }
        return player;
    }
}
