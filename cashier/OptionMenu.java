package cashier;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {

  Scanner menuInput = new Scanner(System.in);
  DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

  HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

  public void getLogin() throws IOException {

    int x = 1;
    do {
      try {
        data.put(952141, 191904);
        data.put(989947, 71976);

        System.out.println("Welcome to the Cashier Project!");
        System.out.print("Enter your customer number: ");
        setCustomerNumber(menuInput.nextInt());

        System.out.print("Enter your PIN number: ");
        setPinNumber(menuInput.nextInt());
      } catch (Exception e) {
        System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
        x = 2;
      }
      int cn = getCustomerNumber();
      int pn = getPinNumber();
      if (data.containsKey(cn) && data.get(cn) == pn) {
        getAccountType();
      } else
        System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n");
      System.out.println("\n" + "If you do not have an Account please crate your Account !" + "\n");
      System.out.println("Enter your customer Number: ");
      int customerNumber = menuInput.nextInt();
      System.out.println("Enter your PIN Number: ");
      int pinNumber = menuInput.nextInt();
      data.put(customerNumber, pinNumber);
      System.out.println("\n" + "Your Account has been successfully created !" + "\n");
      System.out.println("Do you want to continue ?" + "\n" + "Type 1 to continue and 2 to exit");
      int choice = menuInput.nextInt();
      if (choice == 1) {
        getLogin();
      } else {
        System.out.println("Thank You for using this Cashier, bye.");
        System.exit(0);
      }
    } while (x == 1);
  }

  public void getAccountType() {
    System.out.println("Select the Account you want to access: ");
    System.out.println(" Type 1 - Checking Account");
    System.out.println(" Type 2 - Saving Account");
    System.out.println(" Type 3 - Exit");
    System.out.print("Choice: ");

    int selection = menuInput.nextInt();

    switch (selection) {
      case 1:
        getChecking();
        break;

      case 2:
        getSaving();
        break;

      case 3:
        System.out.println("Thank You for using this Cashier, bye.");
        System.exit(0);
        break;

      default:
        System.out.println("\n" + "Invalid Choice." + "\n");
        getAccountType();
    }
  }

  public void getChecking() {
    System.out.println("Checking Account: ");
    System.out.println(" Type 1 - View Balance");
    System.out.println(" Type 2 - Withdraw Funds");
    System.out.println(" Type 3 - Deposit Funds");
    System.out.println(" Type 4 - Exit");
    System.out.print("Choice: ");

    int selection = menuInput.nextInt();

    switch (selection) {
      case 1:
        System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
        getAccountType();
        break;

      case 2:
        getCheckingWithdrawInput();
        getAccountType();
        break;

      case 3:
        getCheckingDepositInput();
        getAccountType();
        break;

      case 4:
        System.out.println("Thank You for using this Cashier, bye.");
        System.exit(0);
        break;

      default:
        System.out.println("\n" + "Invalid Choice." + "\n");
        getChecking();
    }
  }

  public void getSaving() {
    System.out.println("Saving Account: ");
    System.out.println(" Type 1 - View Balance");
    System.out.println(" Type 2 - Withdraw Funds");
    System.out.println(" Type 3 - Deposit Funds");
    System.out.println(" Type 4 - Exit");
    System.out.print("Choice: ");

    int selection = menuInput.nextInt();

    switch (selection) {
      case 1:
        System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
        getAccountType();
        break;

      case 2:
        getSavingWithdrawInput();
        getAccountType();
        break;

      case 3:
        getSavingDepositInput();
        getAccountType();
        break;

      case 4:
        System.out.println("Thank You for using this Cashier, bye.");
        System.exit(0);
        break;

      default:
        System.out.println("\n" + "Invalid Choice." + "\n");
        getSaving();
    }
  }

}
