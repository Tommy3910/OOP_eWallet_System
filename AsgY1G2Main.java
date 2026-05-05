import java.util.Scanner;

public class AsgY1G2Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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