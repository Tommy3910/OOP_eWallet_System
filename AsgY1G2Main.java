import java.util.Scanner;

public class AsgY1G2Main {
    public static void main(String[] args) {
        TouchNGo[] tngAccounts = new TouchNGo[10];
        BankDebitAccount[] bankAccounts = new BankDebitAccount[10];
        int tngCount = 0;
        int bankCount = 0;
        int selection;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Welcome to E-wallet System");
            System.out.println("=======================");
            System.out.println("1. Add Account");
            System.out.println("2. View Account");
            System.out.println("3. Top Up Account");
            System.out.println("4. Account Balance");
            System.out.println("5. Make Payment");
            System.out.println("6. Exit");
            System.out.println("=======================");
            System.out.print("Please choose a number between (1-6): ");
            selection = input.nextInt();
            input.nextLine();

            switch (selection) {
                case 1:
                    System.out.println("Choose account type:");
                    System.out.println("a. Touch N Go");
                    System.out.println("b. Bank Debit Account");
                    String accountType = input.nextLine().trim().toLowerCase();

                    if (accountType.equals("a")) {
                        if (tngCount >= tngAccounts.length) {
                            System.out.println("Touch N Go account list is full.");
                            break;
                        }
                        System.out.print("Enter account number: ");
                        String id = input.nextLine();
                        TouchNGo t = new TouchNGo(id, 0.0);
                        tngAccounts[tngCount++] = t;
                        System.out.println("Touch N Go account added.");
                    } else if (accountType.equals("b")) {
                        if (bankCount >= bankAccounts.length) {
                            System.out.println("Bank Debit account list is full.");
                            break;
                        }
                        System.out.print("Enter account number: ");
                        String accountN = input.nextLine();
                        BankDebitAccount d = new BankDebitAccount(accountN, 0.0);
                        bankAccounts[bankCount++] = d;
                        System.out.println("Bank Debit account added.");
                    } else {
                        System.out.println("Invalid account type selected.");
                    }
                    break;

                case 2:
                    System.out.println("View account type:");
                    System.out.println("a. Touch N Go");
                    System.out.println("b. Bank Debit Account");
                    String viewType = input.nextLine().trim().toLowerCase();

                    if (viewType.equals("a")) {
                        if (tngCount == 0) {
                            System.out.println("No Touch N Go accounts found.");
                            break;
                        }
                        System.out.println("Touch N Go accounts:");
                        for (int i = 0; i < tngCount; i++) {
                            System.out.println((i + 1) + ". " + tngAccounts[i].getTngId());
                        }
                        System.out.print("Enter account number: ");
                        int selectedIndex = input.nextInt() - 1;
                        input.nextLine();
                        if (selectedIndex < 0 || selectedIndex >= tngCount) {
                            System.out.println("Invalid selection.");
                        } else {
                            tngAccounts[selectedIndex].displayAccountInfo();
                        }
                    } else if (viewType.equals("b")) {
                        if (bankCount == 0) {
                            System.out.println("No Bank Debit accounts found.");
                            break;
                        }
                        System.out.println("Bank Debit accounts:");
                        for (int i = 0; i < bankCount; i++) {
                            System.out.println((i + 1) + ". " + bankAccounts[i].getAccountNo());
                        }
                        System.out.print("Enter account number: ");
                        int selectedIndex = input.nextInt() - 1;
                        input.nextLine();
                        if (selectedIndex < 0 || selectedIndex >= bankCount) {
                            System.out.println("Invalid selection.");
                        } else {
                            bankAccounts[selectedIndex].displayAccountInfo();
                        }
                    } else {
                        System.out.println("Invalid view option.");
                    }
                    break;

                case 3:
                    System.out.println("Which account do you want to top up?");
                    System.out.println("a. Touch N Go");
                    System.out.println("b. Bank Debit Account");
                    String topupType = input.nextLine().trim().toLowerCase();

                    if (topupType.equals("a")) {
                        if (tngCount == 0) {
                            System.out.println("No Touch N Go accounts found to top up.");
                            break;
                        }
                        System.out.println("Touch N Go accounts:");
                        for (int i = 0; i < tngCount; i++) {
                            System.out.println((i + 1) + ". " + tngAccounts[i].getTngId());
                        }
                        System.out.print("Enter account number to top up: ");
                        int selectedIndex = input.nextInt() - 1;
                        input.nextLine();
                        if (selectedIndex < 0 || selectedIndex >= tngCount) {
                            System.out.println("Invalid selection.");
                        } else {
                            System.out.print("Enter top up amount: ");
                            double amount = input.nextDouble();
                            input.nextLine();
                            tngAccounts[selectedIndex].topUp(amount);
                        }
                    } else if (topupType.equals("b")) {
                        if (bankCount == 0) {
                            System.out.println("No Bank Debit accounts found to top up.");
                            break;
                        }
                        System.out.println("Bank Debit accounts:");
                        for (int i = 0; i < bankCount; i++) {
                            System.out.println((i + 1) + ". " + bankAccounts[i].getAccountNo());
                        }
                        System.out.print("Enter account number to top up: ");
                        int selectedIndex = input.nextInt() - 1;
                        input.nextLine();
                        if (selectedIndex < 0 || selectedIndex >= bankCount) {
                            System.out.println("Invalid selection.");
                        } else {
                            System.out.print("Enter top up amount: ");
                            double amount = input.nextDouble();
                            input.nextLine();
                            bankAccounts[selectedIndex].topUp(amount);
                        }
                    } else {
                        System.out.println("Invalid account type selected.");
                    }
                    break;

                case 4:
                    System.out.println("Which account do you want to view balance for?");
                    System.out.println("a. Touch N Go");
                    System.out.println("b. Bank Debit Account");
                    String balanceType = input.nextLine().trim().toLowerCase();

                    if (balanceType.equals("a")) {
                        if (tngCount == 0) {
                            System.out.println("No Touch N Go accounts found.");
                            break;
                        }
                        System.out.println("Touch N Go accounts:");
                        for (int i = 0; i < tngCount; i++) {
                            System.out.println((i + 1) + ". " + tngAccounts[i].getTngId());
                        }
                        System.out.print("Enter account number: ");
                        int selectedIndex = input.nextInt() - 1;
                        input.nextLine();
                        if (selectedIndex < 0 || selectedIndex >= tngCount) {
                            System.out.println("Invalid selection.");
                        } else {
                            tngAccounts[selectedIndex].checkBalance();
                        }
                    } else if (balanceType.equals("b")) {
                        if (bankCount == 0) {
                            System.out.println("No Bank Debit accounts found.");
                            break;
                        }
                        System.out.println("Bank Debit accounts:");
                        for (int i = 0; i < bankCount; i++) {
                            System.out.println((i + 1) + ". " + bankAccounts[i].getAccountNo());
                        }
                        System.out.print("Enter account number: ");
                        int selectedIndex = input.nextInt() - 1;
                        input.nextLine();
                        if (selectedIndex < 0 || selectedIndex >= bankCount) {
                            System.out.println("Invalid selection.");
                        } else {
                            bankAccounts[selectedIndex].checkBalance();
                        }
                    } else {
                        System.out.println("Invalid account type selected.");
                    }
                    break;

                case 5:
                    System.out.println("Which account do you want to make payment with?");
                    System.out.println("a. Touch N Go");
                    System.out.println("b. Bank Debit Account");
                    String paymentType = input.nextLine().trim().toLowerCase();

                    if (paymentType.equals("a")) {
                        if (tngCount == 0) {
                            System.out.println("No Touch N Go accounts found.");
                            break;
                        }
                        System.out.println("Touch N Go accounts:");
                        for (int i = 0; i < tngCount; i++) {
                            System.out.println((i + 1) + ". " + tngAccounts[i].getTngId());
                        }
                        System.out.print("Enter account number: ");
                        int selectedIndex = input.nextInt() - 1;
                        input.nextLine();
                        if (selectedIndex < 0 || selectedIndex >= tngCount) {
                            System.out.println("Invalid selection.");
                        } else {
                            System.out.print("Enter payment amount: ");
                            double price = input.nextDouble();
                            input.nextLine();
                            tngAccounts[selectedIndex].makePayment(price);
                        }
                    } else if (paymentType.equals("b")) {
                        if (bankCount == 0) {
                            System.out.println("No Bank Debit accounts found.");
                            break;
                        }
                        System.out.println("Bank Debit accounts:");
                        for (int i = 0; i < bankCount; i++) {
                            System.out.println((i + 1) + ". " + bankAccounts[i].getAccountNo());
                        }
                        System.out.print("Enter account number: ");
                        int selectedIndex = input.nextInt() - 1;
                        input.nextLine();
                        if (selectedIndex < 0 || selectedIndex >= bankCount) {
                            System.out.println("Invalid selection.");
                        } else {
                            System.out.print("Enter payment amount: ");
                            double price = input.nextDouble();
                            input.nextLine();
                            bankAccounts[selectedIndex].makePayment(price);
                        }
                    } else {
                        System.out.println("Invalid account type selected.");
                    }
                    break;

                case 6:
                    System.out.println("Bye Bye");
                    break;

                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        } while (selection != 6);

        input.close();
    }
}
