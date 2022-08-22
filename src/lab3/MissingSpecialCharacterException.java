package lab3;

public class MissingSpecialCharacterException extends Exception {

    String string;
    public MissingSpecialCharacterException(String string) {
        this.string = string;
    }

    public String toString() {
        return "Missing special character in string: " + this.string;
    }

}
