public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    public void setSavingsBalance(double balance){
        savingsBalance = balance;
    }

    public static void modifyInterestRate(double interestRate){
        annualInterestRate = interestRate;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public static double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public void calculateMonthlyInterest(){
        savingsBalance = savingsBalance * (annualInterestRate / 12) + savingsBalance;
    }

    public void printBalance(){
        System.out.println("The current balance for this account is " + savingsBalance);
    }
}
