package lab3;

public class MissingLetterException extends Exception {

    String string;
    public MissingLetterException(String string) {
        this.string = string;
    }

    public String toString() {
        return "Missing letter in string: " + this.string;
    }

}
