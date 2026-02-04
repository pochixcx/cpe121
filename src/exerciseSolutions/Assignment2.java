package exerciseSolutions;

public class Assignment2 {
  
    // Loan evaluator
    public static void main(String[] args) {

        int income = 60000;
        int creditScore = 700;
        boolean isEmployed = false;

        int loanAmount;

        if (income < 0) {
            System.out.println("INVALID INCOME");
        } else if (creditScore < 600) {
            System.out.println("Not eligible");
        } else if (income < 10000) {
            System.out.println("Not eligible");
        } else {

            if (income < 20000) {
                loanAmount = 50000;
            } else if (income < 50000) {
                loanAmount = 150000;
            } else {
                loanAmount = 300000;
            }

            if (!isEmployed) {
                loanAmount = 50000;
            }

            System.out.println("Loan Amount: " + loanAmount);
        }
    }
}


