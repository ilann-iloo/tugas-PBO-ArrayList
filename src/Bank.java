public class Bank {
    private int balance;

    public Bank(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
        System.out.println("Deposit: Rp " + amount);
        System.out.println("Current balance: Rp " + this.balance);
        System.out.println();
    }

    public void withdraw(int amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdraw: Rp " + amount);
            System.out.println("Current balance: Rp " + this.balance);
        } else {
            System.out.println("Withdraw: Rp " + amount + " (Saldo tidak cukup)");
        }
        System.out.println();
    }
    public int getBalance() {
        return this.balance;
    }
}
