public class Payment implements AccountFeature {
    protected double balance;
    protected String accountID;

    public Payment() {
    }

    public Payment(String accountID, double balance) {
        this.accountID = accountID;
        this.balance = balance;
    }

    public String getAccountID(){
        return accountID;
    }

    public double getBalance(){
        return balance;
    }

    public void GentPayment() {
        System.out.println("Generating payment");
    }

    public double topUp(double amountTopUp){
        if(amountTopUp > 0){
            balance += amountTopUp;
            System.out.println("Top-up succesful");
        }else {
        System.out.println("Invalid top-up amount");
        }
        return balance;
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

    public void checkBalance(){
        System.out.printf("Balance: RM%.2f\n" + balance);
    }

    public void displayAccountInfo(){
        System.out.println ("Generic Payment Account");
        System.out.printf("Balance: RM%.2fn\n", balance);
    }
}
 