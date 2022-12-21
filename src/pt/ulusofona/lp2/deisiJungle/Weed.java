package pt.ulusofona.lp2.deisiJungle;

public class Weed extends Food{

    public Weed(String id, int position, String imageName, String name) {
        super(id, position, imageName, name);
    }

    @Override
    public void eatFood(Player player, int turn, int nrSquare) {

        if(player.typeOfFood == 1 || player.typeOfFood == 3){
            player.setCurrentEnergy(player.getCurrentEnergy() + 20);
            player.setFoodCount(player.getFoodCount() + 1);
        }

        if(player.typeOfFood == 2){
            player.setCurrentEnergy(player.getCurrentEnergy() - 20);
            player.setFoodCount(player.getFoodCount() + 1);
        }

    }
}
