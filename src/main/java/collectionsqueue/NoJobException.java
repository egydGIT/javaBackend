package collectionsqueue;

public class NoJobException extends Exception {

    private String message;

    public NoJobException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
