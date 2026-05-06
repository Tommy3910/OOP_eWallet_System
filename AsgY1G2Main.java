import java.util.Scanner;

public class AsgY1G2Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double price = 2.0;
        class payment {
            public void makePayment() {
                System.out.println("Generating payment");
            }
        }

        class TNG extends payment {
            TouchNGo tng;
            double price;

            public TNG(TouchNGo tng, double price) {
                this.tng = tng;
                this.price = price;
            }

            public void makePayment() {
                if (tng.balance >= price) {
                    tng.balance -= price;
                    System.out.println("Pay using TouchNGo");
                    System.out.println("Balance left:" + tng.balance);
                } else {
                    System.out.println("Insufficient balance");
                }
            }
        }

        class BDA extends payment {
            BankDebitAccount bda;
            double price;

            public BDA(BankDebitAccount bda, double price) {
                this.bda = bda;
                this.price = price;
            }

            public void makePayment() {
                if (bda.balance >= price) {
                    bda.balance -= price;
                    System.out.println("Pay using Bank Debit Account");
                    System.out.println("Balance left" + bda.balance);
                } else {
                    System.out.println("Insufficient balance");
                }
            }

        }
        scan.close();
        
    }

}
