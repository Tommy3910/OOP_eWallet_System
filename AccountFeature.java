public interface AccountFeature {
    double topup(double ammountTopup);
    double makePayment(double amountDeduct);
    void checkBalance();
    void displayAccountInfo();

}
