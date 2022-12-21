package pt.ulusofona.lp2.deisiJungle;

public class Bananas extends Food{

    int quantity;

    public Bananas(String id, int position, int quantity) {
        super(id, position);
        this.quantity = quantity;
    }

    @Override
    public void eatFood(Player player, int turn, int nrSquare) {
        if (quantity > 0) {
            if (nrSquare != 0) {
                if (player.TypeOfFood == 1 || player.TypeOfFood == 2 || player.TypeOfFood == 3) {
                    player.setCurrentEnergy(player.getCurrentEnergy() + 40);
                    quantity--;
                } else {
                    if (player.TypeOfFood == 1 || player.TypeOfFood == 2 || player.TypeOfFood == 3) {
                        player.setCurrentEnergy(player.getCurrentEnergy() - 40);
                        quantity--;
                    }
                }
            }
        }
    }
}
