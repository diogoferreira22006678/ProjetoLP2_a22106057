package pt.ulusofona.lp2.deisiJungle;

public class Meat extends Food{

    public Meat(String id, int position, String imageName, String name) {
        super(id, position, imageName, name);
    }

    @Override
    public void eatFood(Player player, int turn, int nrSquare) {
        if(turn <= 12) {
            if (player.typeOfFood == 2 || player.typeOfFood == 3) {
                player.setCurrentEnergy(player.getCurrentEnergy() + 50);
            }

            if (player.typeOfFood == 1) {

            }
        }else{
            if (player.typeOfFood == 2 || player.typeOfFood == 3) {
                player.setCurrentEnergy((int) (player.getCurrentEnergy() * 0.5));
            }

            if (player.typeOfFood == 1) {

            }
        }
    }
}
