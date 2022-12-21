package pt.ulusofona.lp2.deisiJungle;

public class MagicMushrooms extends Food{

    int nRandom;

    public MagicMushrooms(String id, int position, int nRandom, String imageName, String name) {
        super(id, position, imageName, name);
        this.nRandom = nRandom;
    }

    @Override
    public void eatFood(Player player, int turn, int nrSquare) {
        if(player.typeOfFood == 1 || player.typeOfFood == 2 || player.typeOfFood == 3){
            if(turn % 2 == 0){
                player.setCurrentEnergy((player.getCurrentEnergy() * (1 + (nRandom / 100))));
            }else{
                player.setCurrentEnergy((player.getCurrentEnergy() * (1 - (nRandom / 100))));
            }
        }
    }
}
