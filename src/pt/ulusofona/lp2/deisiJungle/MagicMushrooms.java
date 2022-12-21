package pt.ulusofona.lp2.deisiJungle;

public class MagicMushrooms extends Food{

    int nRandom;

    public MagicMushrooms(String id, int position, int nRandom) {
        super(id, position);
        this.nRandom = nRandom;
    }

    @Override
    public void eatFood(Player player, int turn, int nrSquare) {
        if(player.TypeOfFood == 1 || player.TypeOfFood == 2 || player.TypeOfFood == 3){
            if(turn % 2 == 0){
                player.setCurrentEnergy((player.getCurrentEnergy() * (1 + (nRandom / 100))));
            }else{
                player.setCurrentEnergy((player.getCurrentEnergy() * (1 - (nRandom / 100))));
            }
        }
    }
}
