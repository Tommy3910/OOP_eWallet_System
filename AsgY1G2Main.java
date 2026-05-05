import java.util.Scanner;

public class AsgY1G2Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TouchNGo tng1;
        tng1 = new TouchNGo(12345, 500);
        double left = tng1.balance - price;

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
                    System.out.println("Balance left=" + tng.balance);
                } else {
                    System.out.println("Insufficient balance");
                }
            }
        }

        scan.close();
    }
}