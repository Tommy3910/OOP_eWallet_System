public class TouchNGo extends Payment {
    private String tngID;

    public TouchNGo(String tngID, double balance) {
        super(balance);
        this.tngID = tngID;
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

    public double checkbalance() {
        return balance;
    }

    public String getTngId() {
        return tngID;
    }
    public void setTngId(String tngID){
        this.tngID=tngID;
    }
}
