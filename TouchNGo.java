public class TouchNGo {
    protected int tngID;
    double balance;

    public TouchNGo(int tngID, double balance) {
        this.tngID = tngID;
        this.balance = balance;
    }

    public double accountbalance() {
        return balance;
    }
}
