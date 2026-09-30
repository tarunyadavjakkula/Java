interface Payment {
    void pay(double amount);
    void refund(double amount);
}
class UPIPayment implements Payment {
    String upiId;
    int upiPin;
    double balance;

    UPIPayment(String upiId, int upiPin, double balance) {
        this.upiId = upiId;
        this.upiPin = upiPin;
        this.balance = balance;
    }

    public void pay(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
        } else if (balance >= amount) {
            balance = balance - amount;
            System.out.println("UPI Payment Successful: " + amount);
        } else {
            System.out.println("UPI Payment Failed: Insufficient balance");
        }
    }

    public void refund(double amount) {
        balance = balance + amount;
        System.out.println("UPI Refund Successful: " + amount);
    }
}
class CardPayment implements Payment {
    String cardNumber;
    String cardHolder;
    int cvv;
    double limit;

    CardPayment(String cardNumber, String cardHolder, int cvv, double limit) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cvv = cvv;
        this.limit = limit;
    }

    public void pay(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
        } else if (limit >= amount) {
            limit = limit - amount;
            System.out.println("Card Payment Successful: " + amount);
        } else {
            System.out.println("Card Payment Failed: Limit exceeded");
        }
    }

    public void refund(double amount) {
        limit = limit + amount;
        System.out.println("Card Refund Successful: " + amount);
    }
}
class WalletPayment implements Payment {
    String walletId;
    double walletBalance;

    WalletPayment(String walletId, double walletBalance) {
        this.walletId = walletId;
        this.walletBalance = walletBalance;
    }

    public void pay(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
        } else if (walletBalance >= amount) {
            walletBalance = walletBalance - amount;
            System.out.println("Wallet Payment Successful: " + amount);
        } else {
            System.out.println("Wallet Payment Failed: Insufficient balance");
        }
    }

    public void refund(double amount) {
        walletBalance = walletBalance + amount;
        System.out.println("Wallet Refund Successful: " + amount);
    }
}
public class PaymentTest {
    public static void main(String[] args) {

        Payment p;

        p = new UPIPayment("emmanuel@upi", 1234, 5000);
        p.pay(1000);
        p.refund(500);

        System.out.println();

        p = new CardPayment("123456789012", "Emmanuel", 123, 3000);
        p.pay(1500);
        p.refund(500);

        System.out.println();

        p = new WalletPayment("WAL123", 2000);
        p.pay(2500);
        p.refund(500);
    }
}
