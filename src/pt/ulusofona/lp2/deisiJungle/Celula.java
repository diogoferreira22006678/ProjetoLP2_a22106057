package pt.ulusofona.lp2.deisiJungle;
import java.util.ArrayList;
import java.util.HashMap;


public class Celula {

   HashMap<Integer,ArrayList<Player>> informacaoCelula;


    public Celula(){}

    public Celula(HashMap<Integer,ArrayList<Player>> informacaoCelula){

        this.informacaoCelula = informacaoCelula;

    }

    static public void adicionarInformacao(int nrSquare, Player player){
        GameManager.jungle.arrayCelulas[nrSquare - 1].informacaoCelula.get(nrSquare).add(player);
    }

    static public void removerInformacao(int nrSquare, int idPlayer){

        ArrayList<Player> playersNaCelula = GameManager.jungle.arrayCelulas[nrSquare - 1].
                informacaoCelula.get(nrSquare);
       for (int i = 0; i < playersNaCelula.size(); i++){
           if(playersNaCelula.get(i).id == idPlayer){
               GameManager.jungle.arrayCelulas[nrSquare - 1].
                       informacaoCelula.get(nrSquare).remove(i);
           }
       }
    }
}
