 class BankDebitAccount extends Payment{
    private String accountNo;
    private double balance;


    public BankDebitAccount(String accountNo, double balance){
        this.accountNo = accountNo;
        this.balance = balance; 
    }

    public double topUp(double amountTopUp){
         if(amountTopUp > 0){
        balance += amountTopUp;
         }else
            System.out.println("No amount inputed");

        return balance;
    }

    public double makePayment(double amountDeduct){
        if (amountDeduct <= 0){
            System.out.println("Error");
        }else if (amountDeduct > balance){
            System.out.println("Insufficient balance");
        }else{ 
            balance -= amountDeduct;
            System.out.println("Payment succesful");
        }
        return balance;
    }

    public void checkBalance(){
        System.out.println("Balance: "+ balance);
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        if (balance  >= 0){
            this.balance = balance;
        }else{
            System.out.println("Why negative? You broke?");
        }
    }

    public void displayAccountInfo(){
        System.out.println("Account Type: Bank Debit Account");
        System.out.println("Account no:" + accountNo);
        System.out.printf("Balance: RM%.2f\n", balance); //printf %.2f rounds up the value
    }

}