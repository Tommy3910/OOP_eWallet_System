import java.util.Scanner;
import java.util.InputMismatchException;

public class AsgY1G2Main {

    public static void main(String[] args) {
        TouchNGo[] tngAccounts = new TouchNGo[10];
        BankDebitAccount[] bankAccounts = new BankDebitAccount[10];
        int tngCount = 0;
        int bankCount = 0;
        int selection = 0;
        String id;
        Scanner input = new Scanner(System.in);

        //pre-made accounts 
        tngAccounts[tngCount++]= new TouchNGo("1212121212121212", 100000); //click display to show polymorphism
        bankAccounts[bankCount++]= new BankDebitAccount("2424242424242424", 200000);

        do {
            
            System.out.println("______________________________");
            System.out.println("Welcome to E-wallet System");
            System.out.println("=======================");
            System.out.println("1. Add Account");
            System.out.println("2. View Account");
            System.out.println("3. Top Up Account");
            System.out.println("4. Account Balance");
            System.out.println("5. Make Payment");
            System.out.println("6. Exit");
            System.out.println("=======================");

        try {
            System.out.print("Please choose a number between (1-6): ");
            selection = input.nextInt();
            input.nextLine();

            if (selection < 1 || selection > 6) {
                System.out.println("====================================================");
                System.out.println("Invalid selection. Please choose between 1 and 6.");
                continue;
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("====================================================");
            System.out.println("Invalid input. Please enter numbers only.");
            input.nextLine();
            continue;
        }
        catch(Exception ex){
            System.out.println("==================================================");
            System.out.println("Got error lah-, please try again.");
            input.nextLine();
            continue;
        }



            switch (selection) {
                case 1:
                    try{
                        System.out.println("Choose account type:");
                        System.out.println("======================================");
                        System.out.println("a. Touch N Go");
                        System.out.println("b. Bank Debit Account");
                        System.out.println("======================================");
                        String accountType = input.nextLine().trim().toLowerCase();

                        if (accountType.equals("a")) {
                            if (tngCount >= tngAccounts.length) {
                                System.out.println("Touch N Go account list is full.");
                                break;
                            }

                            System.out.print("Enter tng number (16 digits): ");
                            id = input.nextLine();
                            System.out.println("================================");
                            
                            if (!Payment.isValidInput(id)){
                                System.out.println("____________________________________________");
                                System.out.println("Invalid tng number. It's 16 digits lahhh!");
                                System.out.println("_____________________________________________");
                                break;
                            }

                            TouchNGo t = new TouchNGo(id, 0.0);
                            tngAccounts[tngCount++] = t;
                            System.out.println("Touch N Go account added.");

                        } else if (accountType.equals("b")) {
                            if (bankCount >= bankAccounts.length) {
                                System.out.println("Bank Debit account list is full.");
                                break;
                            }
                            System.out.print("Enter account number (16 digits): ");
                            String accountN = input.nextLine();
                            System.out.println("=================================");

                            if (!Payment.isValidInput(accountN)){
                                System.out.println("____________________________________________");
                                System.out.println("Invalid account number. It's 16 digits lahhh!");
                                System.out.println("_____________________________________________");
                                break;
                            }

                            BankDebitAccount d = new BankDebitAccount(accountN, 0.0);
                            bankAccounts[bankCount++] = d;
                            System.out.println("Bank Debit account added.");

                        } else {
                            System.out.println("Invalid account type selected.");
                        }

                    }catch(Exception e){
                        System.out.println("__________________________________________________________");
                        System.out.println("Something went wrong while adding account. You broke isit?");
                        System.out.println("__________________________________________________________");
                    }
                    break;

                case 2:
                    try{
                        System.out.println("View account type:");
                        System.out.println("======================================");
                        System.out.println("a. Touch N Go");
                        System.out.println("b. Bank Debit Account");
                        System.out.println("======================================");
                        System.out.println("Enter your choice: ");
                        String viewType = input.nextLine().trim().toLowerCase();

                        if (viewType.equals("a")) {
                            if (tngCount == 0) {
                                System.out.println("__________________________________");
                                System.out.println("No Touch N Go accounts found.");
                                System.out.println("__________________________________");
                                break;
                            }
                            System.out.println("Touch N Go accounts:");

                            for (int i = 0; i < tngCount; i++) {
                                System.out.println((i + 1) + ". " + tngAccounts[i].getTngId());
                            }
                                        
                                System.out.println("Enter account number: ");
                                int selectedIndex = input.nextInt()-1;
                                input.nextLine();
                

                            if (selectedIndex < 0 || selectedIndex >= tngCount) {
                                System.out.println("____________________");
                                System.out.println("Invalid selection.");
                                System.out.println("____________________");
                                break;
                            }
                            
                            Payment selectedAccount = tngAccounts[selectedIndex];
                            selectedAccount.displayAccountInfo();

                        
                            }
                            else if (viewType.equals("b")) {
                                if (bankCount == 0) {
                                    System.out.println("_____________________________");
                                    System.out.println("No Bank Debit accounts found.");
                                    System.out.println("_____________________________");
                                    break;
                                }
                            System.out.println("Bank Debit accounts:");
                            for (int i = 0; i < bankCount; i++) {
                                System.out.println((i + 1) + ". " + bankAccounts[i].getAccountNo());
                            }

                            System.out.println("Enter account number: ");
                            int selectedIndex = input.nextInt()-1;
                            input.nextLine();
                            
                            if (selectedIndex < 0 || selectedIndex >= bankCount) {
                                System.out.println("___________________");
                                System.out.println("Invalid selection.");
                                System.out.println("___________________");
                                break;
                            }

                            Payment selectedAccount = bankAccounts[selectedIndex];
                            selectedAccount.displayAccountInfo();


                            }else {
                            System.out.println("Invalid view option.");
                            }
                        }
                        catch(InputMismatchException e){
                            System.out.println("____________________________________");
                            System.out.println("Invalid input. Please number only!!");
                            System.out.println("______________________________________");
                            input.nextLine();
                        }
                        catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("_____________________________________");
                            System.out.println("Invalid Selection. Account not found.");
                            System.out.println("______________________________________");
                        }
                        catch (Exception e){
                            System.out.println("___________________________________________________");
                            System.out.println("Something went wrong while viewing ni de account.");
                            System.out.println("___________________________________________________");
                        }
                        break;    

                case 3:
                    try{
                        System.out.println("Which account do you want to top up?");
                        System.out.println("======================================");
                        System.out.println("a. Touch N Go");
                        System.out.println("b. Bank Debit Account");
                        System.out.println("======================================");
                        String topupType = input.nextLine().trim().toLowerCase();

                        if (topupType.equals("a")) {
                            if (tngCount == 0) {
                                System.out.println("________________________________________");
                                System.out.println("No Touch N Go accounts found to top up.");
                                System.out.println("_________________________________________");
                                break;
                            }

                            System.out.println("Touch N Go accounts:");
                            for (int i = 0; i < tngCount; i++) {
                                System.out.println((i + 1) + ". " + tngAccounts[i].getTngId());
                            }
                
                                System.out.println("Enter account number to top up: ");
                                int selectedIndex = input.nextInt()-1;
                                input.nextLine();
                                
                            if (selectedIndex < 0 || selectedIndex >= tngCount) {
                                System.out.println("_____________________");
                                System.out.println("Invalid selection.");
                                System.out.println("_____________________");
                                break;
                            }       

                                System.out.println("Enter top up amount: ");
                                double amount = input.nextDouble();
                                input.nextLine();

                            if (amount <=0 ){
                                System.out.println("____________________________________________");
                                System.out.println("Invalid amount. Amount must be more than 0.");
                                System.out.println("____________________________________________");
                                break;
                            }
    
                                Payment selectedAccount = tngAccounts[selectedIndex];
                                selectedAccount.topUp(amount);
                            }
                            else if (topupType.equals("b")) {
                            if (bankCount == 0) {
                                System.out.println("__________________________________________");
                                System.out.println("No Bank Debit accounts found to top up.");
                                System.out.println("__________________________________________");
                                break;
                            }

                            System.out.println("Bank Debit accounts:");
                            for (int i = 0; i < bankCount; i++) {
                                System.out.println((i + 1) + ". " + bankAccounts[i].getAccountNo());
                            }

                                System.out.println("Enter account number to top up: ");
                                int selectedIndex = input.nextInt()-1;
                                input.nextLine();

                            if (selectedIndex < 0 || selectedIndex >= bankCount) {
                                System.out.println("_____________________");
                                System.out.println("Invalid selection.");
                                System.out.println("_____________________");
                                break;
                            } 
                               
                                System.out.println("Enter top up amount: ");
                                double amount = input.nextDouble();
                                input.nextLine();

                                if(amount <=0){
                                    System.out.println("____________________________________________");
                                    System.out.println("Invalid amount. Amount must be more than 0.");
                                    System.out.println("_____________________________________________");
                                    break;
                                }

                                Payment selectedAccount = bankAccounts[selectedIndex];
                                selectedAccount.topUp(amount);

                            }
                             else {
                            System.out.println("Invalid account type selected.");
                            System.out.println("_______________________________");
                             }
                        }
                        catch(InputMismatchException e){
                            System.out.println("____________________________________");
                            System.out.println("Invalid input. Please number only!!");
                            System.out.println("______________________________________");
                            input.nextLine();
                        }
                        catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("_____________________________________");
                            System.out.println("Invalid Selection. Account not found.");
                            System.out.println("______________________________________");
                        }
                        catch (Exception e){
                            System.out.println("___________________________________________________");
                            System.out.println("Something went wrong while topping up account, probably cause you broke...");
                            System.out.println("___________________________________________________");
                        }
                        break;    
            
                case 4:
                    try{
                        System.out.println("Which account do you want to view balance for?");
                        System.out.println("======================================");
                        System.out.println("a. Touch N Go");
                        System.out.println("b. Bank Debit Account");
                        System.out.println("======================================");
                        System.out.println("Enter your choice: ");
                        String balanceType = input.nextLine().trim().toLowerCase();

                        if (balanceType.equals("a")) {
                            if (tngCount == 0) {
                                System.out.println("No Touch N Go accounts found.");
                                break;
                            }

                            System.out.println("Touch N Go accounts:");
                            for (int i = 0; i < tngCount; i++) {
                                System.out.println((i + 1) + ". " + tngAccounts[i].getTngId());
                            }
                            
                            
                            System.out.println("Enter account number: ");
                            int selectedIndex = input.nextInt()-1;
                            input.nextLine();
                            
                            if(selectedIndex < 0 || selectedIndex >= tngCount){
                                System.out.println("____________________");
                                System.out.println("Invalid selection.");
                                System.out.println("____________________");
                                break;
                            }

                            Payment selectedAccount = tngAccounts[selectedIndex];
                            selectedAccount.checkBalance();
                        }
                        else if (balanceType.equals("b")) {
                            if (bankCount == 0) {
                                System.out.println("No Bank Debit accounts found.");
                                System.out.println("______________________________");
                                break;
                            }

                            System.out.println("Bank Debit accounts:");
                            for (int i = 0; i < bankCount; i++) {
                                System.out.println("_________________________________________");
                                System.out.println((i + 1) + ". " + bankAccounts[i].getAccountNo());
                                System.out.println("_________________________________________");
                            }
                            
                            System.out.println("Enter account number: ");
                            int selectedIndex = input.nextInt() - 1;
                            input.nextLine();  
                            
                            if (selectedIndex < 0 || selectedIndex >= bankCount) {
                                System.out.println("___________________");
                                System.out.println("Invalid selection.");
                                System.out.println("___________________");
                                break;
                            } 

                            Payment selectedAccount = bankAccounts[selectedIndex];
                            selectedAccount.checkBalance();
                            
                        } 
                        else {
                            System.out.println("Invalid account type selected.");
                            System.out.println("_______________________________");
                            }
                    }
                    catch(InputMismatchException e){
                        System.out.println("____________________________________");
                        System.out.println("Invalid input. Please number only!!");
                        System.out.println("______________________________________");
                        input.nextLine();
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("_____________________________________");
                        System.out.println("Invalid Selection. Account not found.");
                        System.out.println("______________________________________");
                    }
                    catch (Exception e){
                        System.out.println("__________________________________________________________________");
                        System.out.println("Something went wrong while checking account balance. ERROR 404 :D");
                        System.out.println("___________________________________________________________________");
                    }
                    break; 
         case 5:
            try{
                System.out.println("Which account do you want to make payment with?");
                System.out.println("======================================");
                System.out.println("a. Touch N Go");
                System.out.println("b. Bank Debit Account");
                System.out.println("======================================");
                System.out.println("Enter your choice: ");
                String paymentType = input.nextLine().trim().toLowerCase();

                if (paymentType.equals("a")) {
                    if (tngCount == 0) {
                        System.out.println("No Touch N Go accounts found.");
                        break;
                    }
                    System.out.println("Touch N Go accounts:");
                    for (int i = 0; i < tngCount; i++) {
                        System.out.println("_________________________________________");
                        System.out.println((i + 1) + ". " + tngAccounts[i].getTngId());
                        System.out.println("_________________________________________");
                    }

                        System.out.print("Enter account number: ");
                        int selectedIndex = input.nextInt() - 1; 
                        input.nextLine();
                    
                    if (selectedIndex < 0 || selectedIndex >= tngCount){
                        System.out.println("_____________________________________________");
                        System.out.println("Invalid selection. Please enter a valid range.");
                        System.out.println("_______________________________________________");
                        break;
                    }
            
                    System.out.print("Enter payment amount: ");
                    double price = input.nextDouble();
                    input.nextLine(); 

                    if(price <= 0){
                        System.out.println("____________________________________________");
                        System.out.println("Invalid amount. Amount must be more than 0.");
                        System.out.println("_____________________________________________");
                        break;
                    }   
                
                    Payment selectedAccount = tngAccounts[selectedIndex];
                    selectedAccount.makePayment(price);
                }    
                else if (paymentType.equals("b")) {
                    if (bankCount == 0) {
                        System.out.println("No Bank Debit accounts found.");
                        System.out.println("______________________________");
                        break;
                    }

                    System.out.println("Bank Debit accounts:");
                    for (int i = 0; i < bankCount; i++) {
                        System.out.println("_____________________________________________");
                        System.out.println((i + 1) + ". " + bankAccounts[i].getAccountNo());
                        System.out.println("_____________________________________________");
                    }

                    System.out.println("Enter account number: ");
                    int selectedIndex = input.nextInt() - 1;
                    input.nextLine();

                        if(selectedIndex < 0 || selectedIndex >= bankCount){
                            System.out.println("_____________________________________________");
                            System.out.println("Invalid selection. Please enter a valid range.");
                            System.out.println("_____________________________________________");
                            break;
                        }
                    

                    System.out.println("Enter payment amount: ");
                    double price = input.nextDouble();
                    input.nextLine();
                    

                    if(price <= 0){
                        System.out.println("___________________________________________________________");
                        System.out.println("Invalid amount. I know you broke, input must be more than 0.");
                        System.out.println("___________________________________________________________");
                        break;
                    }   
                    
                    Payment selectedAccount = bankAccounts[selectedIndex];
                    selectedAccount.makePayment(price);
                    
                }
                else{
                    System.out.println("Invalid account type selected.");
                    System.out.println("________________________________");
                    }
            }
            catch(InputMismatchException e){
                            System.out.println("____________________________________");
                            System.out.println("Invalid input. Please number only!!");
                            System.out.println("______________________________________");
                            input.nextLine();
                        }
                        catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("_____________________________________");
                            System.out.println("Invalid Selection. Account not found.");
                            System.out.println("______________________________________");
                        }
                        catch (Exception e){
                            System.out.println("______________________________________________________________________");
                            System.out.println("Something went wrong while making payment, probably cause you broke...");
                            System.out.println("______________________________________________________________________");
                        }
                        break;    

                case 6:
                    System.out.println("====================================================");
                    System.out.println("Bye Bye, Don't forget to come back with more money.");

                    break;

                default:
                    System.out.println("====================================================");
                    System.out.println("Invalid selection.");
                    break;
            } 
     
         } while (selection != 6);
        
        input.close();
        }
   
    }

