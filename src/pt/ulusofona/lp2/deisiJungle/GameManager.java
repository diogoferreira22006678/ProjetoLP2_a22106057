package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class GameManager {

    static public Tabuleiro jungle;
    public ArrayList<Player> playersNoJogo = new ArrayList<>();

    public GameManager(){

    }

    public String[][] getSpecies(){

        String[][] especiesList = new String[5][3];

        especiesList[0][0] = "E";
        especiesList[0][1] = "Elefante";
        especiesList[0][2] = "elephant.png";

        especiesList[1][0] = "L";
        especiesList[1][1] = "Leão";
        especiesList[1][2] = "lion.png";

        especiesList[2][0] = "P";
        especiesList[2][1] = "Pássaro";
        especiesList[2][2] = "bird.png";

        especiesList[3][0] = "Z";
        especiesList[3][1] = "Tarzan";
        especiesList[3][2] = "tarzan.png";

        especiesList[4][0] = "T";
        especiesList[4][1] = "Tartaruga";
        especiesList[4][2] = "turtle.png";

        return especiesList;
    }


    public boolean createInitialJungle(int jungleSize, int initialEnergy, String[][] playersInfo){

        ArrayList idJogadores = new ArrayList();
        String[][] especiesList = getSpecies();

        //validar energia inicial
        if(initialEnergy <= 0){
            return false;
        }

        for(int i = 0; i < playersInfo.length;i++){

            // validar o ID dos players
            if(idJogadores.contains(playersInfo[i][0])){
                return false;
            }

            idJogadores.add(playersInfo[i][0]);

            //validar Nº de Tarzans
            int procurarTarzan = 0;

            if (playersInfo[i][0] == "Z"){
                procurarTarzan++;
            }
            if(procurarTarzan > 1){
                return false;
            }


            // validar nome do player
            if(playersInfo[i] == null){
                return false;
            }

            //validar  indice da especie
            int valido = 0;

            for(int k = 0; k< especiesList.length; k++){
                if((playersInfo[i][2] == especiesList[k][0])){
                    valido = 1;
                    break;
                }
            }
            if(valido == 0){
                return false;
            }
        }

        // valida numero de players
        if(playersInfo.length < 2 || playersInfo.length > 4){
            return false;
        }

        // valida tamanho do tabuleiro
        if(jungleSize < 2 * playersInfo.length){
            return false;
        }

        jungle = Tabuleiro.criarTabuleiro(jungleSize, initialEnergy, new Celula[jungleSize]);
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < playersInfo.length; i++){
            Player player = new Player(Integer.parseInt(playersInfo[i][0]),playersInfo[i][1],playersInfo[i][2]);
            Player playerComEnergia = new Player(Integer.parseInt(playersInfo[i][0]),
                    playersInfo[i][1],playersInfo[i][2],initialEnergy);
            players.add(player);
            playersNoJogo.add(playerComEnergia);
        }

        HashMap<Integer,ArrayList<Player>> informacaoCelula = new HashMap<>();
        informacaoCelula.put(1, players);
        jungle.arrayCelulas[0] = new Celula(informacaoCelula);
        return true;
    }

    public int[] getPlayerIds(int squareNr){

        //validar o square e se ha informacao na celula
        if (squareNr <= 0 || squareNr > jungle.tamanho){
            return new int[0];
        }else if(jungle.arrayCelulas[squareNr] == null){
            return new int[0];
        }

        //criar array de ids
        ArrayList<Player> players = jungle.arrayCelulas[squareNr - 1].informacaoCelula.get(squareNr);
        int[] idPlayers = new int[players.size()];
        for (int i = 0; i < players.size(); i++){
            idPlayers[i] = players.get(i).id;
        }

        return idPlayers;
    }

    public String[] getSquareInfo(int squareNr){

        String[] informacao = new String[3];

        if(squareNr == jungle.tamanho){
            informacao[0] = "finish.png";
            informacao[1] = "Meta";
        }else{
            informacao[0] = "blank.png";
            informacao[1] = "Vazio";
        }

        ArrayList<Player> players = jungle.arrayCelulas[squareNr - 1].informacaoCelula.get(squareNr);

        if(players == null){
            informacao[2] = "";
            return informacao;
        }
        String stringPlayers = "";
        for (int i = 0; i < players.size(); i++) {

            if (players.size() - 1 == i) {
                stringPlayers += String.valueOf(players.get(i).id);
            } else {
                stringPlayers += players.get(i).id + ",";
            }
        }
        informacao[2] = stringPlayers;

        return informacao;
    }

    public String[] getPlayerInfo(int playerId){

        String[] playerInfo = new String[4];

        for (int i = 0; i < playersNoJogo.size();i++){
            if(playerId == playersNoJogo.get(i).id){
                Player playerRequisitado = playersNoJogo.get(i);
                playerInfo[0] = String.valueOf(playerRequisitado.id);
                playerInfo[1] = playerRequisitado.nome;
                playerInfo[2] = playerRequisitado.especie;
                playerInfo[3] = String.valueOf(playerRequisitado.currentEnergy);

                return playerInfo;
            }
        }
        return null;
    }

    public String[] getCurrentPlayerInfo(){
        return null;
    }

    public String[][] getPlayersInfo(){
        return null;
    }

    public boolean moveCurrentPlayer(int nrSquares, boolean bypassValidations){

        return true;
    }

    public String[] getWinnerInfo(){
        return null;
    }

    public ArrayList<String> getGameResults(){
        return null;
    }

    public JPanel getAuthorsPanel(){
        return null;
    }

    public String whoIsTaborda() {
        return "Futebol";
    }





}
