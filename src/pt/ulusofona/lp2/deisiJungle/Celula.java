package pt.ulusofona.lp2.deisiJungle;
import java.util.ArrayList;
import java.util.HashMap;


public class Celula {



    ArrayList<Player> informacaoCelula;

    public Celula(ArrayList<Player> informacaoCelula){

        this.informacaoCelula = informacaoCelula;

    }

     Celula[] adicionarInformacao(Player player,Celula[] arrayCelula, int nrSquare){

        if(arrayCelula == null){
            ArrayList arrayPlayers = new ArrayList();
            arrayPlayers.add(player);
            arrayCelula[nrSquare - 1].informacaoCelula = arrayPlayers;
            return arrayCelula;
        }

            arrayCelula[nrSquare - 1].informacaoCelula.add(player);

        return arrayCelula;
    }

     Celula[] removerInformacao(int idPlayer, Celula[] arrayCelula, int nrSquare) {

             ArrayList<Player> playersNaCelula = arrayCelula[nrSquare - 1].informacaoCelula;
             for (int i = 0; i < playersNaCelula.size();i++ ){
                 if(playersNaCelula.get(i).id == idPlayer){
                     playersNaCelula.remove(i);
                 }
             }

         return arrayCelula;
    }

    int[] getPlayersIdCelula(Celula[] arrayCelula, int nrSquare){

        int[] idPlayers;

        if(nrSquare < 1 || nrSquare > arrayCelula.length){
            return new int[0];
        }



            ArrayList<Player> playersNaCelula = arrayCelula[nrSquare - 1].informacaoCelula;

            if(playersNaCelula.size() == 0){
                return new int[0];
            }

            idPlayers = new int[playersNaCelula.size()];

            for (int i = 0; i < playersNaCelula.size();i++ ){

                idPlayers[i] = playersNaCelula.get(i).id;

            }
            return idPlayers;

    }
}
