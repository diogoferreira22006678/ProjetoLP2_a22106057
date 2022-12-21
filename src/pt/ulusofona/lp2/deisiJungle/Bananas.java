package pt.ulusofona.lp2.deisiJungle;

public class Bananas extends Food{

    int quantity;

    public Bananas(String id, int position, String imageName,int quantity, String name) {
        super(id, position, imageName, name);
        this.quantity = quantity;
    }

    @Override
    public void eatFood(Player player, int turn, int nrSquare) {
        if (quantity > 0) {
            if (nrSquare != 0) {
                if (player.typeOfFood == 1 || player.typeOfFood == 2 || player.typeOfFood == 3) {
                    player.setCurrentEnergy(player.getCurrentEnergy() + 40);
                    player.setFoodCount(player.getFoodCount() + 1);
                    quantity--;
                } else {
                    if (player.typeOfFood == 1 || player.typeOfFood == 2 || player.typeOfFood == 3) {
                        player.setCurrentEnergy(player.getCurrentEnergy() - 40);
                        player.setFoodCount(player.getFoodCount() + 1);
                        quantity--;
                    }
                }
            }
        }
    }
}
