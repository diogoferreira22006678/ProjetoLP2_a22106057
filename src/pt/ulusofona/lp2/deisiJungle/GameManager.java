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

    public void createInitialJungle(int jungleSize, String[][] playersInfo) throws InvalidInitialJungleException{
        saveInfoPlayer = playersInfo;
        ArrayList idJogadores = new ArrayList();
        String[][] especiesList = getSpecies();
        int procurarTarzan = 0;
        //validar energia inicial
        for(int i = 0; i < playersInfo.length;i++){

            if(playersInfo[i][0] == null || playersInfo[i][1] == null){
                throw  new InvalidInitialJungleException("PLAYERINFO IS NULL", true , false);

            }

            boolean isNumeric =  playersInfo[i][0].matches("[+-]?\\d*(\\.\\d+)?");

            if(idJogadores.contains(playersInfo[i][0]) || !isNumeric){
                throw  new InvalidInitialJungleException("INVALID PLAYER ID", true , false);
                }

            idJogadores.add(playersInfo[i][0]);
            //validar Nº de Tarzans
            if (playersInfo[i][2].equals("Z")){
                procurarTarzan++; }
            if(procurarTarzan > 1){
                throw  new InvalidInitialJungleException("MORE THEN ONE TARZAN", true , false);}
            // validar nome do player
            if(playersInfo[i] == null){
                throw  new InvalidInitialJungleException("PLAYERINFO IS NULL", true , false); }
            //validar  indice da especie
            int valido = 0;
            for(int k = 0; k< especiesList.length; k++){
                if((playersInfo[i][2].equals(especiesList[k][0]))){
                    valido = 1;
                    break; }
            }
            if(valido == 0){
                throw  new InvalidInitialJungleException("INVALID PLAYER SPECIE", true , false); }
        }
        // valida numero de players
        if(playersInfo.length < 2 || playersInfo.length > 4){
            throw  new InvalidInitialJungleException("INVALID NUMBER OF PLAYERS", true , false); }
        // valida tamanho do tabuleiro
        if(jungleSize < 2 * playersInfo.length){
            throw  new InvalidInitialJungleException("INVALID BOARD LENGTH", true , false); }

        jungle = jungle.createBoard(jungleSize);
        playersJogo = new Player[playersInfo.length];
        createPlayerSpecie(playersInfo);
        Arrays.sort(playersJogo, Comparator.comparingInt(p -> p.getId()));
        playersJogo[0].setTurn(1);

    }

    public void createInitialJungle(int jungleSize, String[][] playersInfo, String[][] foodInfo) throws InvalidInitialJungleException{
        saveInfoPlayer = playersInfo;
        saveInfoFood = foodInfo;
        ArrayList idJogadores = new ArrayList();
        String[][] especiesList = getSpecies();
        int procurarTarzan = 0;
        //validar energia inicial
        for(int i = 0; i < playersInfo.length;i++){

            if(playersInfo[i][0] == null || playersInfo[i][1] == null){
                throw  new InvalidInitialJungleException("PLAYERINFO IS NULL", true , false);
            }

            boolean isNumeric =  playersInfo[i][0].matches("[+-]?\\d*(\\.\\d+)?");

            if(idJogadores.contains(playersInfo[i][0]) || !isNumeric){
                throw  new InvalidInitialJungleException("INVALID PLAYER ID", true , false); }

            idJogadores.add(playersInfo[i][0]);
            //validar Nº de Tarzans
            if (playersInfo[i][2].equals("Z")){
                procurarTarzan++; }
            if(procurarTarzan > 1){
                throw  new InvalidInitialJungleException("MORE THEN ONE TARZAN", true , false); }
            // validar nome do player
            if(playersInfo[i] == null){
                throw  new InvalidInitialJungleException("PLAYERINFO IS NULL", true , false); }
            //validar  indice da especie
            int valido = 0;
            for(int k = 0; k< especiesList.length; k++){
                if((playersInfo[i][2].equals(especiesList[k][0]))){
                    valido = 1;
                    break; }
            }
            if(valido == 0){
                throw  new InvalidInitialJungleException("INVALID PLAYER SPECIE", true , false); }
        }
        // valida numero de players
        if(playersInfo.length < 2 || playersInfo.length > 4){
            throw  new InvalidInitialJungleException("INVALID NUMBER OF PLAYERS", true , false); }
        // valida tamanho do tabuleiro
        if(jungleSize < 2 * playersInfo.length){
            throw  new InvalidInitialJungleException("INVALID BOARD LENGTH", true , false); }

        for(int i = 0; i < foodInfo.length; i++){
            boolean isNumeric =  foodInfo[i][1].matches("[+-]?\\d*(\\.\\d+)?");
            if(!isNumeric){
                throw  new InvalidInitialJungleException("POSITION NOT NUMERIC", false , true);
            }
            if(Integer.parseInt(foodInfo[i][1]) <= 1 || Integer.parseInt(foodInfo[i][1]) >= jungleSize){
                throw  new InvalidInitialJungleException("INVALID FOOD POSITION", false , true);
            }
            if(!foodInfo[i][0].equals("e") && !foodInfo[i][0].equals("a") && !foodInfo[i][0].equals("b")
                    && !foodInfo[i][0].equals("m") && !foodInfo[i][0].equals("c")){
                throw  new InvalidInitialJungleException("INVALID FOOD ID", false , true);
            }
        }
        jungle = jungle.createBoard(jungleSize);
        playersJogo = new Player[playersInfo.length];
        createPlayerSpecie(playersInfo);
        createFood(foodInfo);
        Arrays.sort(playersJogo, Comparator.comparingInt(p -> p.getId()));
        playersJogo[0].setTurn(1);

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
                playersJogo[correctPosition].addFoodName(food.getName());
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
                        playersJogo[correctPosition].addFoodName(food.getName());
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

        Player[] tempArray = playersJogo.clone();

        Arrays.sort(tempArray, (p1, p2) -> {
            if (p1.getCurrentHouse() == p2.getCurrentHouse()) {
                return p1.getId() - p2.getId();
            }
            return p2.getCurrentHouse() - p1.getCurrentHouse();
        });

        if(winnerByDefault == 1 ){
            // Switch the first and second elements
            Player temp = tempArray[0];
            tempArray[0] = tempArray[1];
            tempArray[1] = temp;
        }

        ArrayList winnerInfo = new ArrayList();

        for(int i = 0; i < tempArray.length;i++) {

            int posicao = i + 1;

            winnerInfo.add("#" + posicao + " " + tempArray[i].getName()
                    + ", " + tempArray[i].getTotalSpecies() + ", " + tempArray[i].getCurrentHouse() + ", " +
                    tempArray[i].getDistanceTravelled() + ", " + tempArray[i].getFoodCount());
        }

        return winnerInfo;
    }

    public JPanel getAuthorsPanel(){
        return null;
    }

    public String whoIsTaborda() {
        return "Wrestling";
    }

    public boolean saveGame(File file){

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(file));

            writer.write("Turn " + turn + "\n");

            writer.write("Length " + jungle.length + "\n");

            // Write the players array to the file
            for (int i = 0; i < playersJogo.length; i++) {
                    writer.write("Player " + playersJogo[i].getId() + " " + playersJogo[i].getName() + " " +
                            playersJogo[i].getCurrentHouse() + " " + playersJogo[i].getCurrentEnergy() + " " +
                            playersJogo[i].getFoodCount() + " " + saveInfoPlayer[i][2] + " " +
                            playersJogo[i].getDistanceTravelled() + " " + playersJogo[i].getTotalSpecies() + " " +
                            playersJogo[i].getTurn() + " " + playersJogo[i].getSpecie().getAteBanana());

                writer.write("\n");
            }

            if(saveInfoFood != null) {
                // Write the food array to the file
                for (int i = 0; i < jungle.arrayCells.length; i++) {

                    if(jungle.arrayCells[i].cellInformationFood != null) {
                        Food food = jungle.arrayCells[i].cellInformationFood;
                        switch (food.getId()){
                            case"e":
                            case"a":
                            case"c":{
                                writer.write("Food " + food.getId() + " " + food.getPosition() + " " + food.getImageName() +
                                        " " + food.getName());
                                break;
                            }
                            case"b":{
                                writer.write("Food " + food.getId() + " " + food.getPosition() + " " + food.getImageName() +
                                        " " + food.getName() + " " + food.getQuantity());
                                break;
                            }
                            case"m":{
                                writer.write("Food " + food.getId() + " " + food.getPosition() +
                                        " " + food.getImageName() + " " + food.getName() + " " + food.getRandomNumber());
                                break;
                            }
                        }
                        writer.write("\n");
                    }
                }
            }

            writer.flush();

        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public boolean loadGame(File file) {
        BufferedReader reader = null;
        ArrayList<Food> foodList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            ArrayList<Player> arrayTemp = new ArrayList();
            int length = 0;
            int turnTemp = 0;
            while ((line = reader.readLine()) != null) {
                String[] pieces = line.split(" ");
                switch (pieces[0]){
                    case "Turn":{turnTemp = Integer.parseInt(pieces[1]);break;}
                    case "Length":{length = Integer.parseInt(pieces[1]);break;}
                    case "Player":{
                        Player player = new Player();
                        player.setId(Integer.parseInt(pieces[1]));
                        player.setName(pieces[2]);
                        player.setCurrentHouse(Integer.parseInt(pieces[3]));
                        player.setCurrentEnergy(Integer.parseInt(pieces[4]));
                        player.setFoodCount(Integer.parseInt(pieces[5]));
                        player.setidSpecie(pieces[6]);
                        switch (pieces[6]){
                            case "Z": player.setSpecie(new Tarzan());break;
                            case "E": player.setSpecie(new Elephant());break;
                            case "L": player.setSpecie(new Lion());break;
                            case "P": player.setSpecie(new Bird());break;
                            case "T": player.setSpecie(new Turtle());break;
                        }
                        player.setDistanceTravelled(Integer.parseInt(pieces[7]));
                        player.setTotalSpecies(pieces[8]);
                        player.setTurn(Integer.parseInt(pieces[9]));
                        player.getSpecie().setAteBanana(Integer.parseInt(pieces[10]));
                        arrayTemp.add(player);
                    }
                    case "Food":{
                        switch (pieces[1]){
                            case"e":{Food food = new Weed(pieces[1],Integer.parseInt(pieces[2]),pieces[3], pieces[4]);
                                foodList.add(food);}
                            case"a":{Food food = new Water(pieces[1],Integer.parseInt(pieces[2]),pieces[3], pieces[4]);
                                foodList.add(food);}
                            case"c":{Food food = new Meat(pieces[1],Integer.parseInt(pieces[2]),pieces[3], pieces[4]);
                                foodList.add(food);break;}
                            case"b":{
                                Food food = new Bananas(pieces[1],Integer.parseInt(pieces[2]),pieces[3], Integer.parseInt(pieces[5]) ,pieces[4]);
                                foodList.add(food);break;}
                            case"m":{Food food = new MagicMushrooms(pieces[1],Integer.parseInt(pieces[2]),pieces[3], pieces[4] + " " + pieces[5]);
                                food.setnRandom(Integer.parseInt(pieces[6]));
                                foodList.add(food);break;
                            }}}}}reader.close();
            if(foodList == null){
                return loadGame(turnTemp, length, arrayTemp, null);
            }return loadGame(turnTemp,length,arrayTemp,foodList);
        } catch (FileNotFoundException e) {e.printStackTrace();
        } catch (IOException e) {e.printStackTrace();}return false;
    }

    public Boolean loadGame(int turnTemp, int length, ArrayList<Player> arrayTemp, ArrayList<Food> foodList){
        turn = turnTemp;
        playersJogo = new Player[arrayTemp.size()];
        for (int i = 0; i < playersJogo.length ; i++){
            playersJogo[i] = arrayTemp.get(i);
        }
        jungle = new Board();
        jungle = jungle.createBoard(length);
        String[][] playerInfo = new String[playersJogo.length][3];
        for (int k = 0; k < playersJogo.length; k++) {
            playerInfo[k][0] = String.valueOf(playersJogo[k].getId());
            playerInfo[k][1] = playersJogo[k].getName();
            playerInfo[k][2] = playersJogo[k].getidSpecie();
        }
        String[][] foodInfo = new String[foodList.size()][2];
        if(foodList != null) {
            for(int k = 0; k < foodList.size();k++){
                foodInfo[k][0] = foodList.get(k).getId();
                foodInfo[k][1] = String.valueOf(foodList.get(k).getPosition());
            }
            try {
                createInitialJungle(length,playerInfo,foodInfo);
            } catch (InvalidInitialJungleException e) {
               return false;
            }
        }else{
            try {
                createInitialJungle(length,playerInfo);
            } catch (InvalidInitialJungleException e) {
                return false;
            }
        }
        for (int i = 0; i < playersJogo.length; i++) {
            playersJogo[i].setCurrentEnergy(arrayTemp.get(i).getCurrentEnergy());
            playersJogo[i].setFoodCount(arrayTemp.get(i).getFoodCount());
            playersJogo[i].setidSpecie(arrayTemp.get(i).getidSpecie());
            playersJogo[i].setCurrentHouse(arrayTemp.get(i).getCurrentHouse());
            playersJogo[i].setDistanceTravelled(arrayTemp.get(i).getDistanceTravelled());
            playersJogo[i].setTurn(arrayTemp.get(i).getTurn());
            playersJogo[i].setTotalSpecies(arrayTemp.get(i).getTotalSpecies());
            playersJogo[i].setId(arrayTemp.get(i).getId());
            jungle.arrayCells[playersJogo[i].getCurrentHouse() - 1].removeInformation(playersJogo[i].getId(), jungle.arrayCells, 1);
            jungle.arrayCells[playersJogo[i].getCurrentHouse() - 1].addInformation(playersJogo[i], jungle.arrayCells, playersJogo[i].getCurrentHouse());
        }
        if(foodInfo != null){
            for(int i = 0; i < jungle.length; i++){
                if(jungle.arrayCells[i].cellInformationFood != null){
                    Food food = jungle.arrayCells[i].cellInformationFood;
                    for(int k = 0; i < foodList.size(); i++) {
                        if(food.getPosition() == foodList.get(k).getPosition()) {
                            food.setName(foodList.get(i).getName());
                            if (food.getId() == "m") {
                                food.setnRandom(foodList.get(k).getRandomNumber());
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
