package pt.ulusofona.lp2.deisiJungle;
import java.util.ArrayList;
import java.util.HashMap;


public class Celula {



    HashMap<Integer,ArrayList<Player>> informacaoCelula;

    public Celula(HashMap<Integer,ArrayList<Player>> informacaoCelula){

        this.informacaoCelula = informacaoCelula;

    }

     Celula[] adicionarInformacao(Player player,Celula[] arrayCelula, int nrSquare){


        if(arrayCelula[nrSquare - 1].informacaoCelula.containsKey(nrSquare)){
            arrayCelula[nrSquare - 1].informacaoCelula.get(nrSquare).add(player);
            return arrayCelula;
        }

        ArrayList<Player> arrayPlayers = new ArrayList<>();
        arrayPlayers.add(player);

        arrayCelula[nrSquare - 1].informacaoCelula.put(nrSquare,arrayPlayers);

        return arrayCelula;
    }

     Celula[] removerInformacao(int idPlayer, Celula[] arrayCelula, int nrSquare) {

         if(arrayCelula[nrSquare - 1].informacaoCelula.containsKey(nrSquare)){
             ArrayList<Player> playersNaCelula = arrayCelula[nrSquare - 1].informacaoCelula.get(nrSquare);
             for (int i = 0; i < playersNaCelula.size();i++ ){
                 if(playersNaCelula.get(i).id == idPlayer){
                     playersNaCelula.remove(i);
                 }
             }
         }

         return arrayCelula;
    }

    int[] getPlayersIdCelula(Celula[] arrayCelula, int nrSquare){

        int[] idPlayers;

        if(arrayCelula[nrSquare] == null){
            return new int[0];
        }

        if(nrSquare < 1 || nrSquare > arrayCelula.length){
            return new int[0];
        }



        if(arrayCelula[nrSquare - 1].informacaoCelula.containsKey(nrSquare)){
            ArrayList<Player> playersNaCelula = arrayCelula[nrSquare - 1].informacaoCelula.get(nrSquare);

            if(playersNaCelula.size() == 0){
                return new int[0];
            }
            idPlayers = new int[playersNaCelula.size()];
            for (int i = 0; i < playersNaCelula.size();i++ ){

                idPlayers[i] = playersNaCelula.get(i).id;

            }
            return idPlayers;
        }

        return new int[0];

    }
}
