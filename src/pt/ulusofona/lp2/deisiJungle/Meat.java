package pt.ulusofona.lp2.deisiJungle;

public class Meat extends Food{

    public Meat(String id, int position) {
        super(id, position);
    }

    @Override
    public void eatFood(Player player, int turn, int nrSquare) {
        if(turn <= 12) {
            if (player.TypeOfFood == 2 || player.TypeOfFood == 3) {
                player.setCurrentEnergy(player.getCurrentEnergy() + 50);
            }

            if (player.TypeOfFood == 1) {

            }
        }else{
            if (player.TypeOfFood == 2 || player.TypeOfFood == 3) {
                player.setCurrentEnergy((int) (player.getCurrentEnergy() * 0.5));
            }

            if (player.TypeOfFood == 1) {

            }
        }
    }
}
