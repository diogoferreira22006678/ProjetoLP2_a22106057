package pt.ulusofona.lp2.deisiJungle;
import pt.ulusofona.lp2.deisiJungle.food.Food;

import java.io.Serializable;
import java.util.ArrayList;



public class Cell implements Serializable {

    ArrayList<Player> cellInformationPlayer;
    Food cellInformationFood;

    public Cell(ArrayList<Player> CellInformationPlayer) {
        this.cellInformationPlayer = CellInformationPlayer;
    }

    Cell[] addInformationFood(Food food,Cell[] arrayCell, int nrSquare){

        arrayCell[nrSquare - 1].cellInformationFood = food;

        return arrayCell;
    }

    Cell[] addInformation(Player player,Cell[] arrayCell, int nrSquare){

        arrayCell[nrSquare - 1].cellInformationPlayer.add(player);

        return arrayCell;
    }

    Cell[] removeInformation(int idPlayer, Cell[] arrayCell, int nrSquare) {

        ArrayList<Player> playersInCell = arrayCell[nrSquare - 1].cellInformationPlayer;


        for (int i = 0; i < playersInCell.size();i++ ){

            if(playersInCell.get(i).getId() == idPlayer){
                arrayCell[nrSquare - 1].cellInformationPlayer.remove(i);
            }

        }

        return arrayCell;
    }

    int[] getPlayersIdCell(Cell[] arrayCell, int nrSquare){

        int[] idPlayers;

        if(nrSquare < 1 || nrSquare > arrayCell.length){
            return new int[0];
        }
        ArrayList<Player> playersInCell = arrayCell[nrSquare - 1].cellInformationPlayer;

        if(playersInCell.size() == 0){
            return new int[0];
        }

        idPlayers = new int[playersInCell.size()];

        for (int i = 0; i < playersInCell.size();i++ ){

            idPlayers[i] = playersInCell.get(i).getId();

        }
        return idPlayers;
    }
}
