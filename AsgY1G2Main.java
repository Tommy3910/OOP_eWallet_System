import java.util.Scanner;

public class AsgY1G2Main {
    public static void main(String[] args) {
        TouchNGo[] tngAccounts = new TouchNGo[10];
        BankDebitAccount[] bankAccounts = new BankDebitAccount[10];
        int tngCount = 0;
        int bankCount = 0;
        int selection ;
        Scanner input = new Scanner(System.in);

        System.out.println(
                "Welcome to E-wallet System" +
                        "=======================" +
                        "1.Add Account" +
                        "2.View Account" +
                        "3.Top Up Account" +
                        "4.Account Balance" +
                        "5.Make Payment" +
                        "6.Exit" +
                        "=======================");
        System.out.println("Please choose a number between(1-6)");    
        selection=input.nextInt();     

        switch (selection) {
            case 1:
                System.out.println("Choose account type:");
                System.out.println("a. Touch N Go");
                System.out.println("b. Bank Debit Account");
                String accountType = input.nextLine().toLowerCase();

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
                String viewType = input.nextLine().toLowerCase();

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
                System.out.println("Which account you want to top up:");
                System.out.println("a. Touch N Go");
                System.out.println("b. Bank Debit Account");
                String topupType = input.nextLine().toLowerCase();

                if(topupType)
        }
    }
}

