package pt.ulusofona.lp2.deisiJungle;

public class InvalidInitialBoardException{

    String message;
    Boolean invalidPlayer = false;
    Boolean invalidFood = false;
    InvalidInitialJungleException exception;

    public InvalidInitialBoardException(InvalidInitialJungleException exception){
        this.exception = exception;
    }

    public void setInvalidFood(Boolean invalidFood) {
        this.invalidFood = invalidFood;
    }

    public void setInvalidPlayer(Boolean invalidPlayer) {
        this.invalidPlayer = invalidPlayer;
    }

    public String getMessage(){
        return exception.getMessage();
    }
    public Boolean isInvalidPlayer(){
        return this.invalidPlayer;
    }
    public Boolean isInvalidFood(){
        return this.invalidFood;
    }
}
