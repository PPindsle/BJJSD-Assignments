package lab3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. Read a file that contains multiple sets of passwords (use http://www.theonegenerator.com/ to generate a set of test data)
 *
 * 2. Verify that the password contains all of the following criteria:
 * 1. A number
 * 2. A letter
 * 3. Special character (! @ #)
 *
 * 3. Create three User Defined Exceptions for the corresponding criteria.
 *
 * 4. If the password does not meet the criteria, create and throw the appropriate exception
 */

public class PasswordValidator {

    public static void main(String[] args) {
        String filename = "src/lab3/passwords.txt";
        File file = new File(filename);

        List<String> passwords = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String password;
            while ((password = br.readLine()) != null) {
               passwords.add(password);
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found: " + filename);
        } catch (IOException e) {
            System.out.println("ERROR: Could not read file: " + filename);
        }

        for (String password : passwords) {
            try {
                boolean containsNumber = false;
                boolean containsLetter = false;
                boolean containsSpecialCharacter = false;

                for (char c : password.toCharArray()) {
                    if (Character.isDigit(c)) {
                        containsNumber = true;
                    } else if (Character.isLetter(c)){
                        containsLetter = true;
                    } else if (!Character.isLetter(c) && !Character.isDigit(c) && !Character.isWhitespace(c)) {
                        containsSpecialCharacter = true;
                    }

                    // if all are true, there is no need to keep looking
                    if (containsLetter && containsNumber && containsSpecialCharacter) {
                        break;
                    }
                }

                if (!containsNumber) {
                    throw new MissingNumberException(password);
                }
                if (!containsLetter) {
                    throw new MissingLetterException(password);
                }
                if (!containsSpecialCharacter) {
                    throw new MissingSpecialCharacterException(password);
                }

            } catch (MissingNumberException | MissingLetterException | MissingSpecialCharacterException e) {
                System.out.println("ERROR: " + e.toString());
            }
        }
    }

}
