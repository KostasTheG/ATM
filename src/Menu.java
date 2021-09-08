import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    public void getLogin()throws IOException{
        int x =1;
        do{
            try{
                data.put(123456, 123);
                data.put(121212, 321);
                System.out.println("welcome the ATM project");
                System.out.println("Enter our customer number");
                setCustomerNumber(menuInput.nextInt());
                System.out.println("Enter your PIN");
                setPinNumber(menuInput.nextInt());
                }catch (Exception e){
                    System.out.println("Invalid PIN" + "\n");
                    x = 2;
                }
                for(Map.Entry<Integer, Integer> entry:data.entrySet()){
                    if(entry.getKey()==getCustomerNumber() && entry.getValue()==getPinNumber()){
                        getAccountType();
                }
            }
        }while (x==1);
    }

    int selection;

    //display Account type menu

    public void getAccountType(){
        System.out.println("Select the Account you want to access");
        System.out.println("Type 1: Checking Account");
        System.out.println("Type 2: Saving Account");
        System.out.println("Type 3: Exit");
        System.out.println("Choice :");
        selection = menuInput.nextInt();

        switch (selection){
            case 1:
                getChecking();
                break ;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using this ATM");

            default:
                System.out.println("Invalid Credentials" + "\n");
                getAccountType();
        }

    }


    //Display checking account menu with selection
    public void getChecking(){
        System.out.println("Checking Account");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw funds");
        System.out.println("Type 3: Deposit funds");
        System.out.println("Type 4: Exit");
        System.out.println("Choice : " + "\n");
        selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Checking Account Balance" + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawalInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getChecking();
        }
    }

    //Display saving account menu with selection
    public void getSaving(){
        System.out.println("Saving Account");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw funds");
        System.out.println("Type 3: Deposit funds");
        System.out.println("Type 4: Exit");
        System.out.println("Choice : " + "\n");
        selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Saving Account Balance" + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawalInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getSaving();
        }


    }


}
