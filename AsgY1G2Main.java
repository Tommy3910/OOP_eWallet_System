import java.util.Scanner;

import javax.swing.plaf.basic.BasicButtonListener;

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
                bda.makePayment(price);
                System.out.printf("Balance left: RM%.2f\n", bda.getBalance());
            }

        }
        scan.close();
        
    }

}
