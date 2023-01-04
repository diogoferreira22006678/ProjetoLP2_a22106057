package pt.ulusofona.lp2.deisiJungle;

public class InvalidInitialJungleException extends Exception{

    private String message;
    Boolean invalidPlayer = false;
    Boolean invalidFood = false;

    public InvalidInitialJungleException(String message, Boolean invalidPlayer, Boolean invalidFood) {
        this.message = message;
        this.invalidPlayer = invalidPlayer;
        this.invalidFood = invalidFood;
    }

    public String getMessage() {
        return message;
    }

    public void setInvalidFood(Boolean invalidFood) {
        this.invalidFood = invalidFood;
    }

    public void setInvalidPlayer(Boolean invalidPlayer) {
        this.invalidPlayer = invalidPlayer;
    }

    public Boolean isInvalidPlayer(){
        return this.invalidPlayer;
    }

    public Boolean isInvalidFood(){
        return this.invalidFood;
    }
}
