package lectures.Lecture5.examples.bankProgram;

class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double initialDeposit) {
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative");
        }
        this.owner = owner;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return;
        }
        balance -= amount;
    }

    public void printStatus() {
        System.out.println(owner + " balance: " + balance);
    }
}
