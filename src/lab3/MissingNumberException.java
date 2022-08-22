package lab3;

public class MissingNumberException extends Exception {

    String string;
    public MissingNumberException(String string) {
        this.string = string;
    }

    public String toString() {
        return "Missing number in string: " + this.string;
    }

}
