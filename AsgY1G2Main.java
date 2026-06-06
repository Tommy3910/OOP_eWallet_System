import java.util.Scanner;

public class AsgY1G2Main {
    public static void main(String[] args) {
        int selection;
        String account;
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

        switch (selection) {
            case 1:
                System.out.println("Which account you want to add");
                System.out.println("a.Touch N Go"+"\nb.Bank Debit Account");
                account=input.next();
                if(account="a"){
                    TouchNGo t;
                    System.out.println("Enter account number:");
                    t.setTngId(input.nextLine());
                }
                else if(account="b"){
                    BankDebitAccount d;
                    System.out.println("Enter account number: ");
                    
                }
        }

        
    }

}
