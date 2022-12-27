package pt.ulusofona.lp2.deisiJungle;

import pt.ulusofona.lp2.deisiJungle.food.*;
import pt.ulusofona.lp2.deisiJungle.specie.*;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class GameManager {

    Board jungle = new Board();
    Player[] playersJogo;
    String[][] saveInfoFood;
    String[][] saveInfoPlayer;
    int turn = 0;
    int winnerByDefault = 0;


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
        foodTypesList[4][1] = "Cogumelos magicos";
        foodTypesList[4][2] = "mushroom.png";

        return foodTypesList;
    }

    public void createPlayerSpecie(String[][] playersInfo){

        for(int i = 0; i < playersInfo.length;i++) {

            String especie = playersInfo[i][2];

            switch (especie) {
                case "Z" -> {
                    Player tarzan = new Player(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                            playersInfo[i][2], 70, 0, 1, "Tarzan", 0, 0);
                    tarzan.setSpecie(new Tarzan());
                    tarzan.getSpecie().setMinSpeed(1);
                    tarzan.getSpecie().setMaxSpeed(6);
                    playersJogo[i] = tarzan;
                    jungle.arrayCells[0].addInformation(tarzan, jungle.arrayCells, 1);
                }
                case "E" -> {
                    Player elephant = new Player(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                            playersInfo[i][2], 180, 0, 1, "Elefante", 0, 0);
                    elephant.setSpecie(new Elephant());
                    elephant.getSpecie().setMinSpeed(1);
                    elephant.getSpecie().setMaxSpeed(6);
                    playersJogo[i] = elephant;
                    jungle.arrayCells[0].addInformation(elephant, jungle.arrayCells, 1);
                }
                case "L" -> {
                    Player lion = new Player(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                            playersInfo[i][2], 80, 0, 1, "Leao", 0, 0);
                    lion.setSpecie(new Lion());
                    lion.getSpecie().setMinSpeed(4);
                    lion.getSpecie().setMaxSpeed(6);
                    playersJogo[i] = lion;
                    jungle.arrayCells[0].addInformation(lion, jungle.arrayCells, 1);
                }
                case "P" -> {
                    Player bird = new Player(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                            playersInfo[i][2], 70, 0, 1, "Passaro", 0, 0);
                    bird.setSpecie(new Bird());
                    bird.getSpecie().setMinSpeed(5);
                    bird.getSpecie().setMaxSpeed(6);
                    playersJogo[i] = bird;
                    jungle.arrayCells[0].addInformation(bird, jungle.arrayCells, 1);
                }
                case "T" -> {
                    Player turtle = new Player(Integer.parseInt(playersInfo[i][0]), playersInfo[i][1],
                            playersInfo[i][2], 150, 0, 1, "Tartaruga", 0, 0);
                    turtle.setSpecie(new Turtle());
                    turtle.getSpecie().setMinSpeed(1);
                    turtle.getSpecie().setMaxSpeed(3);
                    playersJogo[i] = turtle;
                    jungle.arrayCells[0].addInformation(turtle, jungle.arrayCells, 1);
                }
            }


        }
    }

    public void createFood(String[][] foodInfo){
        for (int i = 0; i < foodInfo.length; i++){
            String id = foodInfo[i][0];
            int position = Integer.parseInt(foodInfo[i][1]);

            switch (id){
                case "e" -> {
                    Food weed = new Weed(id, position,"grass.png","Erva");
                    jungle.arrayCells[position - 1].addInformationFood(weed, jungle.arrayCells, position);
                    break;
                }
                case "a" -> {
                    Food water = new Water(id, position,"water.png","Agua");
                    jungle.arrayCells[position - 1].addInformationFood(water, jungle.arrayCells, position);
                    break;
                }
                case "b" -> {
                    Food banana = new Bananas(id, position, "bananas.png", 3, "Bananas");
                    jungle.arrayCells[position - 1].addInformationFood(banana, jungle.arrayCells, position);
                    break;
                }
                case "c" -> {
                    Food carne = new Meat(id, position, "meat.png", "Carne");
                    jungle.arrayCells[position - 1].addInformationFood(carne, jungle.arrayCells, position);
                    break;
                }
                case "m" -> {
                    Random rand = new Random();
                    Food mushroom = new MagicMushrooms(id, position ,"mushroom.png", "Cogumelo Magico");
                    jungle.arrayCells[position - 1].addInformationFood(mushroom, jungle.arrayCells, position);
                    break;
                }
            }

            }
        }

    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo){
        saveInfoPlayer = playersInfo;
        ArrayList idJogadores = new ArrayList();
        String[][] especiesList = getSpecies();
        int procurarTarzan = 0;
        //validar energia inicial
        for(int i = 0; i < playersInfo.length;i++){

            if(playersInfo[i][0] == null || playersInfo[i][1] == null){
                return new InitializationError("PLAYERINFO NULL");
            }

            boolean isNumeric =  playersInfo[i][0].matches("[+-]?\\d*(\\.\\d+)?");

            if(idJogadores.contains(playersInfo[i][0]) || !isNumeric){
                return new InitializationError("INVAlID PLAYER ID"); }

            idJogadores.add(playersInfo[i][0]);
            //validar Nº de Tarzans
            if (playersInfo[i][2].equals("Z")){
                procurarTarzan++; }
            if(procurarTarzan > 1){
                return new InitializationError("MORE THEN ONE TARZAN"); }
            // validar nome do player
            if(playersInfo[i] == null){
                return new InitializationError("PLAYERINFO NULL"); }
            //validar  indice da especie
            int valido = 0;
            for(int k = 0; k< especiesList.length; k++){
                if((playersInfo[i][2].equals(especiesList[k][0]))){
                    valido = 1;
                    break; }
            }
            if(valido == 0){
                return new InitializationError("INVALID PLAYER SPECIE"); }
        }
        // valida numero de players
        if(playersInfo.length < 2 || playersInfo.length > 4){
            return new InitializationError("INVALID NUMBER OF PLAYERS"); }
        // valida tamanho do tabuleiro
        if(jungleSize < 2 * playersInfo.length){
            return new InitializationError("INVALID LENGTH"); }

        jungle = jungle.createBoard(jungleSize);
        playersJogo = new Player[playersInfo.length];
        createPlayerSpecie(playersInfo);
        Arrays.sort(playersJogo, Comparator.comparingInt(p -> p.getId()));
        playersJogo[0].setTurn(1);

        return null;
    }

    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo, String[][] foodInfo){
        saveInfoPlayer = playersInfo;
        saveInfoFood = foodInfo;
        ArrayList idJogadores = new ArrayList();
        String[][] especiesList = getSpecies();
        String [][] foodList = getFoodTypes();
        int procurarTarzan = 0;
        //validar energia inicial
        for(int i = 0; i < playersInfo.length;i++){

            if(playersInfo[i][0] == null || playersInfo[i][1] == null){
                return new InitializationError("PLAYERINFO NULL");
            }

            boolean isNumeric =  playersInfo[i][0].matches("[+-]?\\d*(\\.\\d+)?");

            if(idJogadores.contains(playersInfo[i][0]) || !isNumeric){
                return new InitializationError("INVAlID PLAYER ID"); }

            idJogadores.add(playersInfo[i][0]);
            //validar Nº de Tarzans

            if (playersInfo[i][2].equals("Z")){
                procurarTarzan++; }
            if(procurarTarzan > 1){
                return new InitializationError("MORE THEN ONE TARZAN"); }
            // validar nome do player
            if(playersInfo[i] == null){
                return new InitializationError("PLAYERINFO NULL"); }
            //validar  indice da especie
            int valido = 0;
            for(int k = 0; k< especiesList.length; k++){
                if((playersInfo[i][2].equals(especiesList[k][0]))){
                    valido = 1;
                    break; }
            }
            if(valido == 0){
                return new InitializationError("INVALID PLAYER SPECIE"); }
        }
        // valida numero de players
        if(playersInfo.length < 2 || playersInfo.length > 4){
            return new InitializationError("INVALID NUMBER OF PLAYERS"); }
        // valida tamanho do tabuleiro
        if(jungleSize < 2 * playersInfo.length){
            return new InitializationError("INVALID LENGTH"); }

        for(int i = 0; i < foodInfo.length; i++){
            boolean isNumeric =  foodInfo[i][1].matches("[+-]?\\d*(\\.\\d+)?");
            if(!isNumeric){
                return new InitializationError("POSITION NOT NUMERIC");
            }
            if(Integer.parseInt(foodInfo[i][1]) <= 1 || Integer.parseInt(foodInfo[i][1]) >= jungleSize){
                return new InitializationError("Invalid Food Positioning");
            }
            if(!foodInfo[i][0].equals("e") && !foodInfo[i][0].equals("a") && !foodInfo[i][0].equals("b")
                    && !foodInfo[i][0].equals("m") && !foodInfo[i][0].equals("c")){
                return new InitializationError("Invalid Food ID");
            }
        }
        jungle = jungle.createBoard(jungleSize);
        playersJogo = new Player[playersInfo.length];
        createPlayerSpecie(playersInfo);
        createFood(foodInfo);
        Arrays.sort(playersJogo, Comparator.comparingInt(p -> p.getId()));
        playersJogo[0].setTurn(1);

        return null;
    }

    public int[] getPlayerIds(int squareNr){

        if(squareNr < 1 || squareNr > jungle.arrayCells.length){
            return new int[0];
        }

        int[] arrayids = jungle.arrayCells[squareNr - 1].getPlayersIdCell(jungle.arrayCells, squareNr);

        return arrayids;
    }

    public String[] getSquareInfo(int squareNr){

        if(squareNr < 1 || squareNr > jungle.arrayCells.length){
            return null;
        }

        String[] informacao = new String[3];

        if(squareNr == jungle.length){
            informacao[0] = "finish.png";
            informacao[1] = "Meta";
        }else {
            if(jungle.arrayCells[squareNr - 1].cellInformationFood == null) {
                informacao[0] = "blank.png";
                informacao[1] = "Vazio";
            }else{
                Food food = jungle.arrayCells[squareNr - 1].cellInformationFood;
                informacao[0] = food.getImageName();
                informacao[1] = food.getToolTip(turn);
            }
        }
        String idPlayers = "";
        ArrayList<Player> players = jungle.arrayCells[squareNr - 1].cellInformationPlayer;

        if(players.size() == 0){
            informacao[2] = idPlayers;
            return informacao;
        }

        for (int i = 0; i < players.size(); i++){
            if(i == players.size() - 1){
                idPlayers += String.valueOf(players.get(i).getId());
            }else{
                idPlayers += (players.get(i).getId()) + ",";
            }
        }

        informacao[2] = idPlayers;

        return informacao;
    }

    public String[] getPlayerInfo(int playerId){

        String[] playerInfo = new String[5];

        for(int i = 0; i < playersJogo.length; i++){

            if(playersJogo[i].getId() == playerId){

                playerInfo[0] = String.valueOf(playersJogo[i].getId());
                playerInfo[1] = playersJogo[i].getName();
                playerInfo[2] = playersJogo[i].getSpecies();
                playerInfo[3] = String.valueOf(playersJogo[i].getCurrentEnergy());
                playerInfo[4] = playersJogo[i].getSpecie().getMinVelocity() + ".."
                        + playersJogo[i].getSpecie().getMaxVelocity();
                return playerInfo;
            }
        }

        return null;
    }

    public String[] getCurrentPlayerInfo(){

        String[] playerInfo = new String[5];

        for(int i = 0; i < playersJogo.length; i++){

            if(playersJogo[i].getTurn() == 1){

                playerInfo[0] = String.valueOf(playersJogo[i].getId());
                playerInfo[1] = playersJogo[i].getName();
                playerInfo[2] = playersJogo[i].getSpecies();
                playerInfo[3] = String.valueOf(playersJogo[i].getCurrentEnergy());
                playerInfo[4] = playersJogo[i].getSpecie().getMinVelocity() + ".."
                        + playersJogo[i].getSpecie().getMaxVelocity();

                return playerInfo;
            }
        }

        return null;
    }

    public String[] getCurrentPlayerEnergyInfo(int nrPositions){

        String[] playerInfo = new String[2];

        for(int i = 0; i < playersJogo.length; i++){
            if (playersJogo[i].getTurn() == 1){
                Player player = playersJogo[i];

                playerInfo[0] = String.valueOf(Math.abs(player.getSpecie().getEnergyPerCell() * nrPositions));
                playerInfo[1] = String.valueOf(player.getSpecie().getRecoveryEnergy());
            }
        }
        return playerInfo;
    }

    public String[][] getPlayersInfo(){

        String[][] playersInfo = new String[playersJogo.length][5];

        for(int i = 0; i < playersJogo.length; i++){

            playersInfo[i][0] = String.valueOf(playersJogo[i].getId());
            playersInfo[i][1] = playersJogo[i].getName();
            playersInfo[i][2] = playersJogo[i].getSpecies();
            playersInfo[i][3] = String.valueOf(playersJogo[i].getCurrentEnergy());
            playersInfo[i][4] = playersJogo[i].getSpecie().getMinVelocity() + ".."
                    + playersJogo[i].getSpecie().getMaxVelocity();

        }

        return playersInfo;
    }

    public int turnRegulator(){

        int correctPosition = - 1;

        for(int i = 0; i < playersJogo.length; i++){
            if(playersJogo[i].getTurn() == 1){
                correctPosition = i;
                playersJogo[i].setTurn(0);
                if(i == playersJogo.length - 1){
                    playersJogo[0].setTurn(1);
                }else{
                    playersJogo[i + 1].setTurn(1);
                }
                break;
            }
        }

        return correctPosition;
    }

    public MovementResult moveCurrentPlayer(int nrSquares, boolean bypassValidations){
        turn++;
        int correctPosition = turnRegulator();
        Specie specie = playersJogo[correctPosition].getSpecie();
        int energyCost = specie.getEnergyPerCell() * nrSquares;
        int playerCurrentHouse = playersJogo[correctPosition].getCurrentHouse();
        Player player = playersJogo[correctPosition];
        //SLEEP
        if(nrSquares == 0){
            playersJogo[correctPosition] = playersJogo[correctPosition].getSpecie().sleep(playersJogo[correctPosition]);
            //SLEEP AND FOOD
            if(jungle.arrayCells[playerCurrentHouse - 1].cellInformationFood != null){
                Food food = jungle.arrayCells[playerCurrentHouse - 1].cellInformationFood;
                playersJogo[correctPosition] = food.eatFood(playersJogo[correctPosition], turn, nrSquares);
                if(food.getId().equals("c") && specie.getTypeOfFood() == 1){
                    return new MovementResult(MovementResultCode.VALID_MOVEMENT,null);
                }
                return new MovementResult(MovementResultCode.CAUGHT_FOOD,"Apanhou " + food.getName());
            }
            return new MovementResult(MovementResultCode.VALID_MOVEMENT, null);
        }
        //NOTENOUGHENERGY
        if(energyCost > player.getCurrentEnergy()){
            return new MovementResult(MovementResultCode.NO_ENERGY,null);}
        //IFPLAYBEHIND1
        if(playerCurrentHouse + nrSquares <= 0){
            return new MovementResult(MovementResultCode.INVALID_MOVEMENT,null);
        }
        //BYPASS
        if(!bypassValidations){
            if(Math.abs(nrSquares) < specie.getMinVelocity() || Math.abs(nrSquares) > specie.getMaxVelocity()){
                return new MovementResult( MovementResultCode.INVALID_MOVEMENT,null);
            } }
                if(playerCurrentHouse + nrSquares > 0 && playerCurrentHouse + nrSquares < jungle.length){
                    if(jungle.arrayCells[playerCurrentHouse + nrSquares - 1].cellInformationFood == null){
                         playersJogo[correctPosition] = player.move(nrSquares,player);
                         jungle.arrayCells = jungle.arrayCells[playerCurrentHouse-1].removeInformation(player.getId(),jungle.arrayCells,playerCurrentHouse);
                         jungle.arrayCells = jungle.arrayCells[playerCurrentHouse + nrSquares -1].addInformation(player, jungle.arrayCells, playerCurrentHouse + nrSquares);
                      return new MovementResult(MovementResultCode.VALID_MOVEMENT,null);
                    }else{
                        playersJogo[correctPosition] = player.move(nrSquares,player);
                        Food food = jungle.arrayCells[playerCurrentHouse + nrSquares - 1].cellInformationFood;
                        jungle.arrayCells = jungle.arrayCells[playerCurrentHouse - 1].removeInformation(player.getId(),jungle.arrayCells,playerCurrentHouse);
                        jungle.arrayCells = jungle.arrayCells[playerCurrentHouse + nrSquares - 1].addInformation(player, jungle.arrayCells, playerCurrentHouse + nrSquares);
                        playersJogo[correctPosition] = food.eatFood(playersJogo[correctPosition], turn, nrSquares);
                        if(food.getId().equals("c") && specie.getTypeOfFood() == 1){
                            return new MovementResult(MovementResultCode.VALID_MOVEMENT,null);
                        }
                        return new MovementResult(MovementResultCode.CAUGHT_FOOD,"Apanhou " + food.getName());
                    }
                }else{
                    if(playerCurrentHouse + nrSquares >= jungle.length){
                        playersJogo[correctPosition] = player.move(jungle.length - playerCurrentHouse, player);
                        jungle.arrayCells = jungle.arrayCells[playerCurrentHouse - 1].removeInformation(player.getId(),jungle.arrayCells,playerCurrentHouse);
                        jungle.arrayCells = jungle.arrayCells[jungle.length - 1].addInformation(player, jungle.arrayCells, jungle.length);
                        return new MovementResult(MovementResultCode.VALID_MOVEMENT,null);
                    }
                }
        return new MovementResult( MovementResultCode.INVALID_MOVEMENT,null);
    }

    public String[] getWinnerInfo() {

        int halfTheMap = jungle.length / 2;

        String[] playersInfo = new String[4];

        Player playerVencedor = new Player();

        for (int i = 0; i < playersJogo.length; i++) {

            //won cuz it made to the final
            if (playersJogo[i].getCurrentHouse() == jungle.length) {
                playersInfo[0] = String.valueOf(playersJogo[i].getId());
                playersInfo[1] = playersJogo[i].getName();
                playersInfo[2] = playersJogo[i].getSpecies();
                playersInfo[3] = String.valueOf(playersJogo[i].getCurrentEnergy());

                winnerByDefault = 0;
                return playersInfo;
            }

            if (playerVencedor.getCurrentHouse() < playersJogo[i].getCurrentHouse()) {
                playerVencedor = playersJogo[i];

            } else {
                if (playerVencedor.getCurrentHouse() == playersJogo[i].getCurrentHouse()) {
                    if (playerVencedor.getId() > playersJogo[i].getId()) {
                        playerVencedor = playersJogo[i];

                    }
                }
            }
        }

        // won because of more then double the houses of any player
        if(halfTheMap % 2 == 0){
            halfTheMap -= 1;
        }

        Player[] tempArray = playersJogo.clone();

        Arrays.sort(tempArray, (p1, p2) -> p2.getCurrentHouse() - p1.getCurrentHouse());
        Player player1 = tempArray[0];
        Player player2 = tempArray[1];

        if (Math.abs(player1.getCurrentHouse() - player2.getCurrentHouse()) > halfTheMap) {
            playersInfo[0] = String.valueOf(player2.getId());
            playersInfo[1] = player2.getName();
            playersInfo[2] = player2.getSpecies();
            playersInfo[3] = String.valueOf(player2.getCurrentEnergy());

            winnerByDefault = 1;
            return playersInfo;
        }

        return null;
    }

    public ArrayList<String> getGameResults(){

        ArrayList<String> winnerInfo = new ArrayList<>();
        String especie = "";
        ArrayList<Player> transitionInfo = new ArrayList<>();
        ArrayList<Player> sortedInfo = new ArrayList<>();

            for (int i = 0; i < playersJogo.length; i++) {
                transitionInfo.add(playersJogo[i]);
            }
            Player playerVencedor = new Player();
            while (transitionInfo.size() != 0) {
                int nrVencedor = 0;
                playerVencedor = new Player();
                for (int i = 0; i < transitionInfo.size(); i++) {
                    if (playerVencedor.getCurrentHouse() < transitionInfo.get(i).getCurrentHouse()) {
                        playerVencedor = transitionInfo.get(i);
                        nrVencedor = i;
                    } else {
                        if (playerVencedor.getCurrentHouse() == transitionInfo.get(i).getCurrentHouse()) {
                            if (playerVencedor.getId() > transitionInfo.get(i).getId()) {
                                playerVencedor = transitionInfo.get(i);
                                nrVencedor = i;
                            }
                        }
                    }
                }
                sortedInfo.add(playerVencedor);
                transitionInfo.remove(nrVencedor);
            }
            for (int i = 0; i < sortedInfo.size(); i++) {


                int posicao = i + 1;

                winnerInfo.add("#" + posicao + " " + sortedInfo.get(i).getName()
                        + ", " + sortedInfo.get(i).getTotalSpecies() + ", " + sortedInfo.get(i).getCurrentHouse() + ", " +
                        sortedInfo.get(i).getDistanceTravelled() + ", " + sortedInfo.get(i).getFoodCount());
            }

            if(winnerByDefault == 0) {
                return winnerInfo;
            }else{
                String temp = winnerInfo.get(1);
                winnerInfo.set(0, winnerInfo.get(1));
                winnerInfo.set(1, temp);

                return winnerInfo;
            }

    }

    public JPanel getAuthorsPanel(){
        return null;
    }

    public String whoIsTaborda() {
        return "Wrestling";
    }

    public boolean saveGame(File file){


        if(saveInfoFood != null){
            //WITHFOOD

        }

            //WITHOUTFOOD
            for(int i = 0; i < saveInfoPlayer.length; i++){

            }

        return false;
    }

    public boolean loadGame(File file) {
        return true;

    }
}
