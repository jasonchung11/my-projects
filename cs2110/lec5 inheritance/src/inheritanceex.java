
public class inheritanceex {
    private double balance;
    private String number;

    public inheritanceex(String num) {
        number= num;
    }

    public class InterestAccount extends inheritanceex {
        private double interestRate;

        public InterestAccount(String num, double rate) {
            super(num);
            interestRate= rate;
        }
    }
}
