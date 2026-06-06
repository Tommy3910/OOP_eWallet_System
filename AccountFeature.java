public interface AccountFeature {
    double topUp(double ammountTopup);
    double makePayment(double amountDeduct);
    void checkBalance();
    void displayAccountInfo();
    String getAccountID();

}
