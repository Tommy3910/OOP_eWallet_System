 class BankDebitAccount extends Payment{

 

    
    public BankDebitAccount(String accountNo, double balance){
        super(accountNo, balance);
    }

    public double topUp(double amountTopUp){
         if(amountTopUp > 0){
        balance += amountTopUp;
        System.out.println("Succesfully toped up");
         }else
            System.out.println("You broke");

        return balance;
    }

    public double makePayment(double amountDeduct) {
        System.out.println("Processing Bank Debit Accoint Payment...");
        if (amountDeduct <= 0) {
            System.out.println("Error: YOU BROKE!!!");
        } else if (amountDeduct > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amountDeduct;
            System.out.println("Payment successful using Bank Debit card");
        }
        return balance;
    }

    public void checkBalance(){
        System.out.println("Balance: RM%.2f\n"+ balance);
    }

    public String getAccountNo(){
        return accountID;
    }

    public void setAccountID(String accountNo){
        this.accountID = accountNo;
        
    }
    public void displayAccountInfo(){
        System.out.println("Account Type: Bank Debit Account");
        System.out.println("Account no:" + accountID);
        System.out.printf("Balance: RM%.2f\n", balance); //printf %.2f rounds up the value
    }

}