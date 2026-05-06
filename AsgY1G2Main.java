import java.util.Scanner;

public class AsgY1G2Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice; 
        String accountNum; 
        double balance;








        System.out.print("Enter account number for BankDebitAccount: ");
        accountNum = scan.nextLine();
        System.out.println("Enter Balance for:");
        balance = scan.nextDouble();

        BankDebitAccount b = new BankDebitAccount(accountNum, balance);

    
        
        do{
            System.out.println("\n===========================");
            System.out.println("1. Display Bank Debit Account Info");
            System.out.println("2. Top Up Bank Debit Account");
            System.out.println("3. Make Payment");
            System.out.println("6. Check Balance");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            choice =scan.nextInt(); 

            switch(choice){
                case 1:
                    System.out.println("Display account info selected.");
                    break;

                case 2: 
                    System.out.println("Top up amount.");
                    break;

                case 3:
                    System.out.println("Make payment selected.");
                    break;
                    
                case 4:
                    System.out.println("Check balance selected");
                    break;
                case 5:
                    System.out.println(" Quitting system....");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again. ");
            }

        }while (choice !=5);

        double price = 2.0;
        class payment {
            public void makePayment() {
                System.out.println("Payment done");
            }
        }

        class TNG extends payment {
            public void makePayment() {

            }
        }
        scan.close();
        
    }

}
