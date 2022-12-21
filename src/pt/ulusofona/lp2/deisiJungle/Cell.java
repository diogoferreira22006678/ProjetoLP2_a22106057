package pt.ulusofona.lp2.deisiJungle;
import java.util.ArrayList;



public class Cell {

    ArrayList<Player> CellInformationPlayer;
    ArrayList<Food> CellInformationFood;

    public Cell(ArrayList<Player> CellInformationPlayer, ArrayList<Food> CellInformationFood){

        this.CellInformationPlayer = CellInformationPlayer;
        this.CellInformationFood = CellInformationFood;

    }

    Cell[] addInformation(Player player,Cell[] arrayCell, int nrSquare){

        arrayCell[nrSquare - 1].CellInformationPlayer.add(player);

        return arrayCell;
    }

    Cell[] removeInformation(int idPlayer, Cell[] arrayCell, int nrSquare) {

        ArrayList<Player> playersInCell = arrayCell[nrSquare - 1].CellInformationPlayer;

        for (int i = 0; i < playersInCell.size();i++ ){

            if(playersInCell.get(i).getId() == idPlayer){
                playersInCell.remove(i);
            }

        }

        return arrayCell;
    }

    int[] getPlayersIdCell(Cell[] arrayCell, int nrSquare){

        int[] idPlayers;

        if(nrSquare < 1 || nrSquare > arrayCell.length){
            return new int[0];
        }
        ArrayList<Player> playersInCell = arrayCell[nrSquare - 1].CellInformationPlayer;

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
