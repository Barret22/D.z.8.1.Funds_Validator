package app;

import java.lang.module.FindException;
import java.util.Scanner;

public class Main {

    static double balance;

    public static void main(String[] args) {
        balance = getBalance();
        validateAmount(balance,
                getAmount());
    }

    private static double getBalance() {
        return 1000.00; // Наявні кошти на рахунку
    }

    private static double getAmount() {
        System.out.printf("Balance is USD %.2f.%n" +
                "Enter purchase amount, USD: ", balance);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    // Метод валідації наявних коштів
    private static double validateAmount(double balance, double withdrawal) {
        if (withdrawal > balance ) {
            throw new FindException("Insufficient " +
                    "funds!");
        } else {
            balance = getBalance(balance, withdrawal);
            System.out.println("Funds are OK. Purchase paid.");
            System.out.printf("Balance is USD %.2f%n", balance);
            return balance;
        }
    }

    // Метод розрахунку наявних коштів на рахунку
    // після зняття певної суми коштів
    private static double getBalance(double balance, double withdrawal) {
        return balance - withdrawal;
    }
}
