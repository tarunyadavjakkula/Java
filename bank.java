class BankAccount {

     String accountHolder;
    long accountNumber;
    double balance;
    String accountType;
BankAccount(String accountHolder, long accountNumber,
                double balance, String accountType) {

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    void deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {

        if (amount <= balance) {
            balance = balance - amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    void checkBalance() {

        System.out.println("Current Balance : " + balance);
    }
double calculateInterest(float rate) {

        return (balance * rate) / 100;
    }
void displayDetails() {

        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Balance        : " + balance);
        System.out.println("------------------------------");
    }
}
public class BankManagement {

    public static void main(String[] args) {
BankAccount acc1 = new BankAccount(
                "Lavanya",
                1001,
                5000,
                "Savings");

        BankAccount acc2 = new BankAccount(
                "Rahul",
                1002,
                10000,
                "Current");
System.out.println("ACCOUNT DETAILS");
        System.out.println("====================");

        acc1.displayDetails();
        acc2.displayDetails();
System.out.println("OPERATIONS ON ACCOUNT 1");
        System.out.println("========================");

        acc1.deposit(2000);
        acc1.withdraw(3000);
        acc1.checkBalance();

        double interest1 = acc1.calculateInterest(5);
        System.out.println("Interest : " + interest1);

        System.out.println();
System.out.println("OPERATIONS ON ACCOUNT 2");
        System.out.println("========================");

        acc2.deposit(5000);
        acc2.withdraw(20000); // Insufficient funds
        acc2.checkBalance();

        double interest2 = acc2.calculateInterest(4);
        System.out.println("Interest : " + interest2);
    }
}