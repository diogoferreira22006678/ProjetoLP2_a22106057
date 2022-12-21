package pt.ulusofona.lp2.deisiJungle;

public class Bananas extends Food{

    int quantity = 3;
    String toolTip = "Bananas : " + quantity + " : + 40 energia";

    public Bananas(String id, int position, String imageName,int quantity, String name) {
        super(id, position, imageName, name);
        this.quantity = quantity;
    }

    @Override
    public String getToolTip(int turn) {
        return this.toolTip;
    }

    @Override
    public Player eatFood(Player player, int turn, int nrSquare) {
        if (quantity > 0) {
            if (nrSquare != 0) {
                if (player.typeOfFood == 1 || player.typeOfFood == 2 || player.typeOfFood == 3) {
                    if(player.getCurrentEnergy() + 40 > player.specie.getEnergyCap()){
                        player.setCurrentEnergy(player.specie.getEnergyCap());
                    }else {
                        player.setCurrentEnergy(player.getCurrentEnergy() + 40);
                    }
                    player.setFoodCount(player.getFoodCount() + 1);
                    quantity--;
                } else {
                    if (player.typeOfFood == 1 || player.typeOfFood == 2 || player.typeOfFood == 3) {
                        if(player.getCurrentEnergy() - 40 < 0){
                            player.setCurrentEnergy(0);
                        }else {
                            player.setCurrentEnergy(player.getCurrentEnergy() - 40);
                        }
                        player.setFoodCount(player.getFoodCount() + 1);
                        quantity--;
                    }
                }
            }
        }
        return player;
    }
}
