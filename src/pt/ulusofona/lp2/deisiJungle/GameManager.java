package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.util.ArrayList;


public class GameManager {

    Tabuleiro jungle = new Tabuleiro();


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
            boolean isNumeric =  playersInfo[i][0].matches("[+-]?\\d*(\\.\\d+)?");

            if(idJogadores.contains(playersInfo[i][0]) && !isNumeric){
                return false;
            }

            idJogadores.add(playersInfo[i][0]);

            //validar Nº de Tarzans
            int procurarTarzan = 0;

            if (playersInfo[i][0].equals("Z")){
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

        Celula[] arrayCelulas = new Celula[jungleSize];

        jungle = jungle.criarTabuleiro(jungleSize,initialEnergy,arrayCelulas);

        return true;
    }

    public int[] getPlayerIds(int squareNr){


        return null;
    }

    public String[] getSquareInfo(int squareNr){

        String[] informacao = new String[3];


        return informacao;
    }

    public String[] getPlayerInfo(int playerId){

        String[] playerInfo = new String[4];


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
        return "Wrestling";
    }





}
