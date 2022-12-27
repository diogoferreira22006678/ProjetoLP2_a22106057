package pt.ulusofona.lp2.deisiJungle.food;

import pt.ulusofona.lp2.deisiJungle.Player;

public class Meat extends Food {

    String toolTip = "Carne : + 50 energia : ";

    public Meat(String id, int position, String imageName, String name) {
        super(id, position, imageName, name);
    }

    @Override
    public int getQuantity(){
        return 0;
    }

    @Override
    public void setnRandom(int nRandom){}

    @Override
    public int getRandomNumber(){
        return 0;
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

        if (player.getSpecie().getTypeOfFood() == 1) {
            return player;
        }

        if(turn <= 12) {
            if (player.getSpecie().getTypeOfFood() == 2 || player.getSpecie().getTypeOfFood() == 3) {
                if(player.getCurrentEnergy() + 50 > 200){
                    player.setCurrentEnergy(200);
                }else {
                    player.setCurrentEnergy(player.getCurrentEnergy() + 50);
                }
                player.setFoodCount(player.getFoodCount() + 1);
            }
        }else{
            if (player.getSpecie().getTypeOfFood() == 2 || player.getSpecie().getTypeOfFood() == 3) {
                player.setCurrentEnergy((int) (player.getCurrentEnergy() * 0.5));
                player.setFoodCount(player.getFoodCount() + 1);
            }

        }
        return player;
    }
}
