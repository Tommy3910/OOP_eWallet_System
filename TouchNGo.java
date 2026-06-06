public class TouchNGo extends Payment {

    public TouchNGo(String tngID, double balance) {
        super(tngID, balance);
    }

    public double makePayment(double amountDeduct) {
        System.out.println("Pay using TouchNGo");
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

    public void checkBalance() {
        System.out.printf("TouchNGo Balance: RM%.2f\n", balance);
    }

    public String getTngId() {
        return accountID;
    }


    public void setAccountID(String accountID){
        this.accountID = accountID;
    }

     public void displayAccountInfo(){
        System.out.println("Account Type: Touch N Go Account");
        System.out.println("Account no:" + accountID);
        System.out.printf("Balance: RM%.2f\n", balance); //printf %.2f rounds up the value
    }
}
