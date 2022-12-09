package pt.ulusofona.lp2.deisiJungle;
import kotlin.comparisons.UComparisonsKt;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;



public class GameManager {

    Tabuleiro jungle = new Tabuleiro();
    Player[] playersJogo;
    String[] idsEspecie;


    public GameManager(){}



    public String[][] getSpecies(){

        String[][] especiesList = new String[5][7];
        especiesList[0][0] = "E";
        especiesList[0][1] = "Elefante";
        especiesList[0][2] = "elephant.png";
        especiesList[0][3] = "180";//EI
        especiesList[0][4] = "4";//CE
        especiesList[0][5] = "10";//GED
        especiesList[0][6] = "1..6";//V(X..Y)
        especiesList[1][0] = "L";
        especiesList[1][1] = "Leão";
        especiesList[1][2] = "lion.png";
        especiesList[1][3] = "80";
        especiesList[1][4] = "2";
        especiesList[1][5] = "10";
        especiesList[1][6] = "4..6";
        especiesList[2][0] = "P";
        especiesList[2][1] = "Pássaro";
        especiesList[2][2] = "bird.png";
        especiesList[2][3] = "70";
        especiesList[2][4] = "4";
        especiesList[2][5] = "50";
        especiesList[2][6] = "5..6";
        especiesList[3][0] = "Z";
        especiesList[3][1] = "Tarzan";
        especiesList[3][2] = "tarzan.png";
        especiesList[3][3] = "70";
        especiesList[3][4] = "2";
        especiesList[3][5] = "20";
        especiesList[3][6] = "1..6";
        especiesList[4][0] = "T";
        especiesList[4][1] = "Tartaruga";
        especiesList[4][2] = "turtle.png";
        especiesList[4][3] = "150";
        especiesList[4][4] = "1";
        especiesList[4][5] = "5";
        especiesList[4][6] = "1..3";
        return especiesList;
    }

    public String[][] getFoodTypes(){
        String[][] foodTypesList = new String[5][3];

        foodTypesList[0][0] = "e";//id
        foodTypesList[0][1] = "Erva";//nome
        foodTypesList[0][2] = "grass.png";//nome ficheiro

        foodTypesList[1][0] = "a";
        foodTypesList[1][1] = "Agua";
        foodTypesList[1][2] = "water.png";

        foodTypesList[2][0] = "b";
        foodTypesList[2][1] = "Cacho de bananas";
        foodTypesList[2][2] = "bananas.png";

        foodTypesList[3][0] = "c";
        foodTypesList[3][1] = "Carne";
        foodTypesList[3][2] = "meat.png";

        foodTypesList[4][0] = "m";
        foodTypesList[4][1] = "Congumelos magicos";
        foodTypesList[4][2] = "mushroom.png";

        return foodTypesList;
    }

    public InitializationError createInitialJungle(int jungleSize, String[][]
            foodsInfo, String[][] playersInfo){
        ArrayList idJogadores = new ArrayList();
        String[][] especiesList = getSpecies();
        String [][] foodList = getFoodTypes();
        //validar energia inicial
        for(int i = 0; i < playersInfo.length;i++){
            // validar o ID dos players
            // esta linha se calhar null
            if(playersInfo[i][0] == null || playersInfo[i][1] == null){
                return new InitializationError();
            }
            boolean isNumeric =  playersInfo[i][0].matches("[+-]?\\d*(\\.\\d+)?");
            if(idJogadores.contains(playersInfo[i][0]) || !isNumeric){
                return new InitializationError(); }
            idJogadores.add(playersInfo[i][0]);
            //validar Nº de Tarzans
            int procurarTarzan = 0;
            if (playersInfo[i][0].equals("Z")){
                procurarTarzan++; }
            if(procurarTarzan > 1){
                return new InitializationError(); }
            // validar nome do player
            if(playersInfo[i] == null){
                return new InitializationError(); }
            //validar  indice da especie
            int valido = 0;
            for(int k = 0; k< especiesList.length; k++){
                if((playersInfo[i][2] == especiesList[k][0])){
                    valido = 1;
                    break; }
            }
            if(valido == 0){
                return new InitializationError(); }
        }
        // valida numero de players
        if(playersInfo.length < 2 || playersInfo.length > 4){
            return new InitializationError(); }
        // valida tamanho do tabuleiro
        if(jungleSize < 2 * playersInfo.length){
            return new InitializationError(); }
        jungle = jungle.criarTabuleiro(jungleSize);
        playersJogo = new Player[playersInfo.length];

        playersInfo = sortPlayer(playersInfo);

        createPlayerSpecie(playersInfo);

        for(int i = 0; i < foodsInfo.length;i++) {
            // validar o ID dos players
            // esta linha se calhar null
            if (foodsInfo[i][0] == null || foodsInfo[i][1] == null ||
                    Integer.parseInt(foodsInfo[i][1]) < 0 || Integer.parseInt(foodsInfo[i][1]) > jungleSize) {
                return new InitializationError();
            }
            boolean isNumeric =  foodsInfo[i][0].matches("[+-]?\\d*(\\.\\d+)?");
            if(!isNumeric){
                return new InitializationError(); }
            if(foodsInfo[i] == null){
                return new InitializationError(); }
            int valido = 0;
            for(int k = 0; k< foodList.length; k++){
                if((foodsInfo[i][0] == foodList[k][0])){
                    valido = 1;
                    break; }
            }
            if(valido == 0){
                return new InitializationError(); }
        }

        return null;
    }

    public void createPlayerSpecie(String[][] playersInfo){

        int turno;

        for(int i = 0; i < playersInfo.length;i++) {
            if(i == 0){
                turno = 1;
            }else{
                turno = 0;
            }

            String especie = playersInfo[i][2];



            switch (especie){
                case "Z":
                    Tarzan tarzan = new Tarzan(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                            playersInfo[i][2],70,turno,1,idsEspecie[i]);
                    playersJogo[i] = tarzan;
                    jungle.arrayCelulas[0].adicionarInformacao(tarzan,jungle.arrayCelulas,1);
                    break;
                case "E":
                    Elefante elefante = new Elefante(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                            playersInfo[i][2],70,turno,1,idsEspecie[i]);
                    playersJogo[i] = elefante;
                    jungle.arrayCelulas[0].adicionarInformacao(elefante,jungle.arrayCelulas,1);
                    break;
                case "L":
                    Leao leao = new Leao(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                            playersInfo[i][2],180,turno,1,idsEspecie[i]);
                    playersJogo[i] = leao;
                    jungle.arrayCelulas[0].adicionarInformacao(leao,jungle.arrayCelulas,1);
                    break;
                case "P":
                    Passaro passaro = new Passaro(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                            playersInfo[i][2],70,turno,1,idsEspecie[i]);
                    playersJogo[i] = passaro;
                    jungle.arrayCelulas[0].adicionarInformacao(passaro,jungle.arrayCelulas,1);
                    break;
                case "T":
                    Tartaruga tartaruga = new Tartaruga(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                            playersInfo[i][2],150,turno,1,idsEspecie[i]);
                    playersJogo[i] = tartaruga;
                    jungle.arrayCelulas[0].adicionarInformacao(tartaruga,jungle.arrayCelulas,1);
                    break;
            }


        }
    }


    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo){
        ArrayList idJogadores = new ArrayList();
        String[][] especiesList = getSpecies();
        String [][] foodList = getFoodTypes();

        //validar energia inicial
        for(int i = 0; i < playersInfo.length;i++){
            // validar o ID dos players
            // esta linha se calhar null
            if(playersInfo[i][0] == null || playersInfo[i][1] == null){
                return new InitializationError();
            }
            boolean isNumeric =  playersInfo[i][0].matches("[+-]?\\d*(\\.\\d+)?");
            if(idJogadores.contains(playersInfo[i][0]) || !isNumeric){
                return new InitializationError(); }
            idJogadores.add(playersInfo[i][0]);
            //validar Nº de Tarzans
            int procurarTarzan = 0;
            if (playersInfo[i][0].equals("Z")){
                procurarTarzan++; }
            if(procurarTarzan > 1){
                return new InitializationError(); }
            // validar nome do player
            if(playersInfo[i] == null){
                return new InitializationError(); }
            //validar  indice da especie
            int valido = 0;
            for(int k = 0; k< especiesList.length; k++){
                if((playersInfo[i][2] == especiesList[k][0])){
                    valido = 1;
                    break; }
            }
            if(valido == 0){
                return new InitializationError(); }
        }
        // valida numero de players
        if(playersInfo.length < 2 || playersInfo.length > 4){
            return new InitializationError(); }
        // valida tamanho do tabuleiro
        if(jungleSize < 2 * playersInfo.length){
            return new InitializationError(); }
        jungle = jungle.criarTabuleiro(jungleSize);
        playersJogo = new Player[playersInfo.length];
        int turno;

        playersInfo = sortPlayer(playersInfo);

        for(int i = 0; i < playersInfo.length;i++) {
            if(i == 0){
                turno = 1;
            }else{
                turno = 0;
            }
            Player player = new Player(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                    playersInfo[i][2],100,turno,1,idsEspecie[i]);
            playersJogo[i] = player;

            jungle.arrayCelulas[0].adicionarInformacao(player,jungle.arrayCelulas,1); }

        return null;
    }


    public String[][] sortPlayer(String[][] playersInfo){


        ArrayList<String> idsPlayers = new ArrayList<>();
        String[][] playersInfoSorted = new String[playersInfo.length][4];
        idsEspecie = new String[playersInfo.length];

        String especie = "";
        for(int i = 0; i < playersInfo.length;i++){
            if( playersInfo[i][2] == "Z"){especie = "Tarzan";}
            if( playersInfo[i][2] == "E"){especie = "Elefante";}
            if( playersInfo[i][2] == "L"){especie = "Leão";}
            if( playersInfo[i][2] == "P"){especie = "Pássaro";}
            if( playersInfo[i][2] == "T"){especie = "Tartaruga";}
            idsPlayers.add(playersInfo[i][0] + "@@" + playersInfo[i][1] + "@@" +  playersInfo[i][2] + "@@" + especie);

        }

        Collections.sort(idsPlayers);

        for(int i = 0; i < idsPlayers.size();i++) {
            String currentLine = idsPlayers.get(i);
            String[] campos = currentLine.split("@@");
            playersInfoSorted[i][0] = campos[0];
            playersInfoSorted[i][1] = campos[1];
            playersInfoSorted[i][2] = campos[2];
            idsEspecie[i] = campos[3];

        }

        return playersInfoSorted;
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

    public MovementResult moveCurrentPlayer(int nrSquares, boolean bypassValidations){

        for (int i = 0; i < playersJogo.length; i++){
            boolean jogada = false;

            if(playersJogo[i].turno == 1){
                //Jogador certo


                // acertar o proximo jogador
                if(i + 1 == playersJogo.length){
                    playersJogo[0].turno = 1;
                }else{
                    playersJogo[i + 1].turno = 1;
                }
                playersJogo[i].turno = 0;

                int[] speed = new int[2];

                if(playersJogo[i].getClass() == Tarzan.class){
                    Tarzan player = (Tarzan) playersJogo[i];
                    speed = player.getSpeed();
                }
                if(playersJogo[i].getClass() == Elefante.class){
                    Elefante player = (Elefante) playersJogo[i];
                    speed = player.getSpeed();
                }
                if(playersJogo[i].getClass() == Passaro.class){
                    Passaro player = (Passaro) playersJogo[i];
                    speed = player.getSpeed();
                }
                if(playersJogo[i].getClass() == Leao.class){
                    Leao player = (Leao) playersJogo[i];
                    speed = player.getSpeed();
                }
                if(playersJogo[i].getClass() == Tartaruga.class){
                    Tartaruga player = (Tartaruga) playersJogo[i];
                    speed = player.getSpeed();
                }


                if (bypassValidations == false){

                    if(nrSquares < speed[0] || nrSquares > speed[1]){
                        return new MovementResult(MovementResultCode.INVALID_MOVEMENT,"INVALID PLAY");
                    }
                }

                playersJogo[i].currentEnergy -= 2;

                // jogada Atual

                jungle.arrayCelulas =jungle.arrayCelulas[playersJogo[i].casaAtual].
                        removerInformacao(playersJogo[i].id,
                        jungle.arrayCelulas, playersJogo[i].casaAtual);

                if(nrSquares + playersJogo[i].casaAtual >= jungle.tamanho ){
                    // ganhou
                    playersJogo[i].casaAtual = jungle.tamanho;
                    jungle.arrayCelulas[jungle.tamanho - 1].informacaoCelula.add(playersJogo[i]);
                }else{
                    playersJogo[i].casaAtual += nrSquares;
                    jungle.arrayCelulas[playersJogo[i].casaAtual - 1].informacaoCelula.add(playersJogo[i]);
                }
                jogada = true;
            }
            if(jogada){
                break;
            }
        }

        return new MovementResult(MovementResultCode.VALID_MOVEMENT,"VALID MOVIMENT");
    }

    public String[] getWinnerInfo(){

        int noEnergy = 0;
      
        String[] playersInfo = new String[4];

        Player playerVencedor = new Player();

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

            if(playerVencedor.casaAtual < playersJogo[i].casaAtual){
                playerVencedor = playersJogo[i];

            }else{
                if(playerVencedor.casaAtual == playersJogo[i].casaAtual){
                    if(playerVencedor.id > playersJogo[i].id){
                        playerVencedor = playersJogo[i];

                    }
                }
            }

        }
        // ganhou porque n ha energia
        if(noEnergy == 0){
            playersInfo[0] = String.valueOf(playerVencedor.id);
            playersInfo[1] = playerVencedor.nome;
            playersInfo[2] = playerVencedor.especie;
            playersInfo[3] = String.valueOf(playerVencedor.currentEnergy);


            return playersInfo;
        }

        return null;

    }

    public ArrayList<String> getGameResults(){

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
            playerVencedor = new Player();
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


            int posicao = i + 1;

           winnerInfo.add("#" + posicao + " " + sortedInfo.get(i).nome + ", " + sortedInfo.get(i).especieTotal + ", " + sortedInfo.get(i).casaAtual);
        }
        return winnerInfo;
    }

    public JPanel getAuthorsPanel(){
        return null;
    }

    public String whoIsTaborda() {
        return "Wrestling";
    }

    //-----------------------------------------------------2ª part-----------------------------------------------------------------//

    public String[] getCurrentPlayerEnergyInfo(int nrPositions){
        return null;
    }

    public boolean saveGame(File file){
        return true;
    }

    public boolean loadGame(File file){
        return true;
    }


}
