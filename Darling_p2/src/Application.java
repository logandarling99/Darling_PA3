public class Application {
    public static void main(String ...args){
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        saver1.setSavingsBalance(2000.00);
        saver2.setSavingsBalance(3000.00);
        SavingsAccount.modifyInterestRate(0.04);

        for(int i = 0; i < 12; i++){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }

        saver1.printBalance();
        saver2.printBalance();

        SavingsAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        saver1.printBalance();
        saver2.printBalance();
    }
}
