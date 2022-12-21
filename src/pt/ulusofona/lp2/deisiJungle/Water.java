package pt.ulusofona.lp2.deisiJungle;

public class Water extends Food{
    public Water(String id, int position) {
        super(id, position);
    }

    @Override
    public void eatFood(Player player, int turn, int nrSquare) {

        if(player.TypeOfFood == 1 || player.TypeOfFood == 2){
            player.setCurrentEnergy(player.getCurrentEnergy() + 15);
        }

        if(player.TypeOfFood == 3){
            player.setCurrentEnergy((int) (player.getCurrentEnergy() * 1.2));
        }
    }
}
