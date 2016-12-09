public class User {
    private int attempts;
    private double balance;
    private String pin;

    public User(double balance, String pin){
        this.attempts = 0;
        this.balance = balance;
        this.pin = pin;
    }

    public int getAttempts() {
        return attempts;
    }
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
}
