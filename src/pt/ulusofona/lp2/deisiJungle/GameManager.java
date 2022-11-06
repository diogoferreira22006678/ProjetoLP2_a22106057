package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class GameManager {

    Tabuleiro jungle = new Tabuleiro();
    Player[] playersJogo;


    public GameManager(){}

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
            // esta linha se calhar null
            if(playersInfo[i][0] == null){
                return false; }
            boolean isNumeric =  playersInfo[i][0].matches("[+-]?\\d*(\\.\\d+)?");
            if(idJogadores.contains(playersInfo[i][0]) || !isNumeric){
                return false; }
            idJogadores.add(playersInfo[i][0]);
            //validar Nº de Tarzans
            int procurarTarzan = 0;
            if (playersInfo[i][0].equals("Z")){
                procurarTarzan++; }
            if(procurarTarzan > 1){
                return false; }
            // validar nome do player
            if(playersInfo[i] == null){
                return false; }
            //validar  indice da especie
            int valido = 0;
            for(int k = 0; k< especiesList.length; k++){
                if((playersInfo[i][2] == especiesList[k][0])){
                    valido = 1;
                    break; }
            }
            if(valido == 0){
                return false; }
        }
        // valida numero de players
        if(playersInfo.length < 2 || playersInfo.length > 4){
            return false; }
        // valida tamanho do tabuleiro
        if(jungleSize < 2 * playersInfo.length){
            return false; }
        jungle = jungle.criarTabuleiro(jungleSize,initialEnergy);
        playersJogo = new Player[playersInfo.length];
        int turno;
        for(int i = 0; i < playersInfo.length;i++) {
            if(i == 0){
                turno = 1;
            }else{
                turno = 0;
            }
            Player player = new Player(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                    playersInfo[i][2],initialEnergy,turno,1);
            playersJogo[i] = player;

            jungle.arrayCelulas[0].adicionarInformacao(player,jungle.arrayCelulas,1); }
        return true;
    }

    public int[] getPlayerIds(int squareNr){

        if(squareNr < 1 || squareNr > jungle.arrayCelulas.length){
            return new int[0];
        }

        int[] arrayids = jungle.arrayCelulas[squareNr - 1].getPlayersIdCelula(jungle.arrayCelulas, squareNr);

        return arrayids;
    }

    public String[] getSquareInfo(int squareNr){

        if(squareNr < 1 || squareNr > jungle.arrayCelulas.length){
            return null;
        }

        String[] informacao = new String[3];

        if(squareNr == jungle.tamanho){
            informacao[0] = "finish.png";
            informacao[1] = "Meta";
        }else {

            informacao[0] = "blank.png";
            informacao[1] = "Vazio";
        }
        String idPlayers = "";
        ArrayList<Player> players = jungle.arrayCelulas[squareNr - 1].informacaoCelula;

        if(players.size() == 0){
            informacao[2] = idPlayers;
            return informacao;
        }

        for (int i = 0; i < players.size(); i++){
            if(i == players.size() - 1){
                idPlayers += String.valueOf(players.get(i).id);
            }else{
            idPlayers += (players.get(i).id) + ",";
            }
        }

        informacao[2] = idPlayers;

        return informacao;
    }

    public String[] getPlayerInfo(int playerId){

        String[] playerInfo = new String[4];

        for(int i = 0; i < playersJogo.length; i++){

            if(playersJogo[i].id == playerId){

                playerInfo[0] = String.valueOf(playersJogo[i].id);
                playerInfo[1] = playersJogo[i].nome;
                playerInfo[2] = playersJogo[i].especie;
                playerInfo[3] = String.valueOf(playersJogo[i].currentEnergy);

                return playerInfo;
            }
        }

        return null;
    }

    public String[] getCurrentPlayerInfo(){

        String[] playerInfo = new String[4];

        for(int i = 0; i < playersJogo.length; i++){

            if(playersJogo[i].turno == 1){
                playerInfo[0] = String.valueOf(playersJogo[i].id);
                playerInfo[1] = playersJogo[i].nome;
                playerInfo[2] = playersJogo[i].especie;
                playerInfo[3] = String.valueOf(playersJogo[i].currentEnergy);

                return playerInfo;
            }
        }

        return null;
    }

    public String[][] getPlayersInfo(){

        String[][] playersInfo = new String[playersJogo.length][4];

        for(int i = 0; i < playersJogo.length; i++){

                playersInfo[i][0] = String.valueOf(playersJogo[i].id);
                playersInfo[i][1] = playersJogo[i].nome;
                playersInfo[i][2] = playersJogo[i].especie;
                playersInfo[i][3] = String.valueOf(playersJogo[i].currentEnergy);

        }

        return playersInfo;
    }

    public boolean moveCurrentPlayer(int nrSquares, boolean bypassValidations){

        for (int i = 0; i < playersJogo.length; i++){

            if(playersJogo[i].turno == 1){
                //Jogador certo

                // acertar o proximo jogador
                if(i + 1 == playersJogo.length){
                    playersJogo[0].turno = 1;
                }else{
                    playersJogo[i + 1].turno = 1;
                }
                playersJogo[i].turno = 0;

                if(playersJogo[i].currentEnergy == 0){
                    return false;
                }

                playersJogo[i].currentEnergy -= 2;

                if (!bypassValidations){
                    if(nrSquares < 1 || nrSquares > 6){
                        return false;
                    }
                }

                // jogada Atual


                jungle.arrayCelulas =jungle.arrayCelulas[playersJogo[i].casaAtual ].removerInformacao(playersJogo[i].id,
                        jungle.arrayCelulas, playersJogo[i].casaAtual );

                if(nrSquares + playersJogo.length >= jungle.tamanho ){
                    // ganhou
                    playersJogo[i].casaAtual = jungle.tamanho ;


                    jungle.arrayCelulas[jungle.tamanho - 1].informacaoCelula.add(playersJogo[i]);
                }else{
                    playersJogo[i].casaAtual += nrSquares;
                    jungle.arrayCelulas[playersJogo[i].casaAtual - 1].informacaoCelula.add(playersJogo[i]);
                }
                break;
            }
        }

        return true;
    }

    public String[] getWinnerInfo(){

        int noEnergy = 0;
        Player playerWinnerInfo = new Player();
        String[] playersInfo = new String[4];
        int maiorCasa = 0;

        for(int i = 0; i < playersJogo.length;i++){

            if(playersJogo[i].currentEnergy != 0){
                noEnergy += 1;
            }
            //ganhou porque chegou a meta
            if(playersJogo[i].casaAtual == jungle.tamanho){
                playersInfo[0] = String.valueOf(playersJogo[i].id);
                playersInfo[1] = playersJogo[i].nome;
                playersInfo[2] = playersJogo[i].especie;
                playersInfo[3] = String.valueOf(playersJogo[i].currentEnergy);


                return playersInfo;
            }

            if (maiorCasa <= playersJogo[i].casaAtual) {
                if(maiorCasa == playersJogo[i].casaAtual && maiorCasa != 0){

                    if(playersJogo[i].id < playersJogo[i - 1].id ){
                        playersInfo[0] = String.valueOf(playersJogo[i].id);
                        playersInfo[1] = playersJogo[i].nome;
                        playersInfo[2] = playersJogo[i].especie;
                        playersInfo[3] = String.valueOf(playersJogo[i].currentEnergy);

                    }else{
                        playersInfo[0] = String.valueOf(playersJogo[i - 1].id);
                        playersInfo[1] = playersJogo[i - 1].nome;
                        playersInfo[2] = playersJogo[i - 1].especie;
                        playersInfo[3] = String.valueOf(playersJogo[i - 1].currentEnergy);

                    }
                }

            }

        }
        // ganhou porque n ha energia
        if(noEnergy == 0){

            return playersInfo;
        }

        return null;

    }

    public ArrayList<String> getGameResults(){

        ArrayList<String> playerInfo = new ArrayList<>();
        ArrayList<String> winnerInfo = new ArrayList<>();
        String especie = "";
        ArrayList<Player> transitionInfo = new ArrayList<>();
        ArrayList<Player> sortedInfo = new ArrayList<>();

        for(int i = 0; i < playersJogo.length ; i++){
            transitionInfo.add(playersJogo[i]);
        }
        Player playerVencedor = new Player();
        while(transitionInfo.size() != 0){
            int nrVencedor = 0;
            for (int i = 0; i < transitionInfo.size();i++){
                if(playerVencedor.casaAtual < transitionInfo.get(i).casaAtual){
                    playerVencedor = transitionInfo.get(i);
                    nrVencedor = i;
                }else{
                    if(playerVencedor.casaAtual == transitionInfo.get(i).casaAtual){
                        if(playerVencedor.id > transitionInfo.get(i).id){
                            playerVencedor = transitionInfo.get(i);
                            nrVencedor = i;
                        }
                    }
                }
            }
            sortedInfo.add(playerVencedor);
            transitionInfo.remove(nrVencedor);
        }


        for(int i = 0; i < sortedInfo.size() ; i++){
            if(sortedInfo.get(i).especie == "Z"){especie = "Tarzan";}
            if(sortedInfo.get(i).especie == "E"){especie = "Elefante";}
            if(sortedInfo.get(i).especie == "L"){especie = "Leão";}
            if(sortedInfo.get(i).especie == "P"){especie = "Pássaro";}
            if(sortedInfo.get(i).especie == "T"){especie = "Tartaruga";}

            int posicao = i + 1;

           winnerInfo.add("#" + posicao + sortedInfo.get(i).nome + ", " + especie + ", " + sortedInfo.get(i).casaAtual);
        }





        return winnerInfo;
    }

    public JPanel getAuthorsPanel(){
        return null;
    }

    public String whoIsTaborda() {
        return "Wrestling";
    }





}
