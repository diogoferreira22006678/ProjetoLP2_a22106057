package pt.ulusofona.lp2.deisiJungle;

public class InitializationError {

    String message;

    public InitializationError(String message) {
        this.message = message;
    }

    String getMessage(){
        return message;
    }
}
