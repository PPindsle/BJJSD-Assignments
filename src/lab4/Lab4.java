package lab4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Read a credit card CSV statement
 * Creating a balance variable that calculates the running balance of the user’s account
 * If the field says CREDIT, then add the amount to the balance
 * If the field says DEBIT, then subtract the amount to the balance
 * If the final amount is greater than zero, charge a 10% fee and warn the user
 * If the final amount is zero, thank the user for their payments
 * If the final amount is less than zero, thank the user for their payment and display their overpayment.
 */

public class Lab4 {

    public static void main(String[] args) {
        ArrayList<String[]> transactions = getTransactions();
        for (String[] transaction : transactions) {
            processTransaction(transaction);
        }
    }

    private static void processTransaction(String[] data) {
        System.out.println(Arrays.toString(data));
        String type = data[1];
        double amount = Double.parseDouble(data[3]);
        double balance = 0;

        if (type.equalsIgnoreCase("credit")) {
            balance += amount;
        } else if (type.equalsIgnoreCase("debit")) {
            balance -= amount;
        } else {
            System.out.println("Some other transaction");
            return;
        }

        System.out.println("Thank you for your payment.");

        if (balance > 0) {
            double fee = amount * 0.1;
            if (balance >= balance - fee) {
                balance -= fee;
                System.out.println("A 10% transaction fee has been applied.");
            }
        }

        System.out.println("New balance: " + balance);
    }

    private static ArrayList<String[]> getTransactions() {
        String filename = "src/lab4/transactions.csv";
        File file = new File(filename);

        ArrayList<String[]> rows = new ArrayList<String[]>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String row;
            while ((row = br.readLine()) != null) {
                rows.add(row.split(","));
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return rows;
    }

}
