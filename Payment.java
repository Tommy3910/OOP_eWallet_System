public class Payment {
    protected double balance;

    public Payment() {
    }

    public Payment(double balance) {
        this.balance = balance;
    }

    public void GentPayment() {
        System.out.println("Generating payment");
    }

    public double makePayment(double amountDeduct) {
        System.out.println("Processing generic payment...");
        if (amountDeduct <= 0) {
            System.out.println("Error: amount must be positive");
        } else if (amountDeduct > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amountDeduct;
            System.out.println("Payment successful");
        }
        return balance;
    }
}
 