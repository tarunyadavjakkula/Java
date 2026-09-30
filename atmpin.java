import java.util.Scanner;

class ATMPinChecker {

    String username;
    String pinStored;

    // Parameterized constructor
    ATMPinChecker(String username, String pinStored) {
        this.username = username;
        this.pinStored = pinStored;
    }

    boolean verifyPIN(String enteredPIN) {

        return pinStored.equals(enteredPIN);
    }

    void authenticate() {

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {

            System.out.print("Enter PIN: ");
            String enteredPIN = sc.nextLine();

            if (verifyPIN(enteredPIN)) {
                System.out.println("PIN ENTERED CORRECT");
                return;
            } else {
                System.out.println("Incorrect PIN");
            }
        }

        System.out.println("ACCOUNT LOCKED");
    }

    public static void main(String[] args) {

        ATMPinChecker atm =
            new ATMPinChecker("Emmanuel", "1234");

        atm.authenticate();
    }
\