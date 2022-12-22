package pt.ulusofona.lp2.deisiJungle;

public class Weed extends Food{

    String toolTip = "Erva : +- 20 energia";

    public Weed(String id, int position, String imageName, String name) {
        super(id, position, imageName, name);
    }

    @Override
    public String getToolTip(int turn) {
        return this.toolTip;
    }

    @Override
    public Player eatFood(Player player, int turn, int nrSquare) {

        if(player.specie.getTypeOfFood() == 1 || player.specie.getTypeOfFood() == 3){
            if(player.getCurrentEnergy() + 20 > player.specie.getEnergyCap()){
                player.setCurrentEnergy(player.specie.getEnergyCap());
            }else {
                player.setCurrentEnergy(player.getCurrentEnergy() + 20);
            }
            player.setFoodCount(player.getFoodCount() + 1);
        }

        if(player.specie.getTypeOfFood() == 2){
            if(player.getCurrentEnergy() - 20 < 0){
                player.setCurrentEnergy(player.specie.getEnergyCap());
            }else {
                player.setCurrentEnergy(player.getCurrentEnergy() - 20);
            }
            player.setFoodCount(player.getFoodCount() + 1);
        }

        return player;
    }
}
