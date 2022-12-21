package pt.ulusofona.lp2.deisiJungle;

public class Weed extends Food{

    public Weed(String id, int position) {
        super(id, position);
    }

    @Override
    public void eatFood(Player player, int turn, int nrSquare) {

        if(player.TypeOfFood == 1 || player.TypeOfFood == 3){
            player.setCurrentEnergy(player.getCurrentEnergy() + 20);
        }

        if(player.TypeOfFood == 2){
            player.setCurrentEnergy(player.getCurrentEnergy() - 20);
        }

    }
}
