package pt.ulusofona.lp2.deisiJungle;

public class Meat extends Food{

    String toolTip = "Carne : + 50 energia : ";

    public Meat(String id, int position, String imageName, String name) {
        super(id, position, imageName, name);
    }

    @Override
    public String getToolTip(int turn) {
        return this.toolTip + turn + " jogadas";
    }

    @Override
    public Player eatFood(Player player, int turn, int nrSquare) {
        if(turn <= 12) {
            if (player.specie.getTypeOfFood() == 2 || player.specie.getTypeOfFood() == 3) {
                if(player.getCurrentEnergy() + 50 > player.specie.getEnergyCap()){
                    player.setCurrentEnergy(player.specie.getEnergyCap());
                }else {
                    player.setCurrentEnergy(player.getCurrentEnergy() + 50);
                }
                player.setFoodCount(player.getFoodCount() + 1);
            }

            if (player.specie.getTypeOfFood() == 1) {

            }
        }else{
            if (player.specie.getTypeOfFood() == 2 || player.specie.getTypeOfFood() == 3) {
                player.setCurrentEnergy((int) (player.getCurrentEnergy() * 0.5));
                player.setFoodCount(player.getFoodCount() + 1);
            }

            if (player.specie.getTypeOfFood() == 1) {

            }
        }
        return player;
    }
}
