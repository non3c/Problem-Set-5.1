import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        fractionQuiz();



    }

    public static void estimatePI () {
        Fraction MILU = new Fraction(355, 113);
        Fraction estimate = MILU;

        final double EPSILION = Math.abs(Math.PI - estimate.toDouble());

        while (Math.abs(Math.PI - estimate.toDouble()) >= EPSILION) {
            if (estimate.toDouble() < Math.PI) {
                estimate.setNum(estimate.getNum()+1);
            }
            else if (estimate.toDouble() > Math.PI) {
                estimate.setDenom(estimate.getDenom()+1);
            }
        }

        System.out.println(estimate);
    }

    public static void fractionQuiz() {
        int score = 0;
        int total = 0;

        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();
        Fraction answer = new Fraction();
        Scanner input = new Scanner(System.in);

        System.out.println("Let's see how Asian you are");





        while (true) {
            int function = (int)(Math.random()*4+1);
            f1 = Fraction.randomFraction();
            f2 = Fraction.randomFraction();

            if (function == 1) {
                System.out.print(f1 + " + " + f2 + " = ");
                answer = Fraction.add(f1, f2);
            }
            else if (function == 2) {
                System.out.print(f1 + " - " + f2 + " = ");
                answer = Fraction.subtract(f1, f2);
            }
            else if (function == 3) {
                System.out.print(f1 + " x " + f2 + " = ");
                answer = Fraction.multiply(f1, f2);
            }
            else if (function == 4) {
                System.out.print(f1 + " / " + f2 + " = ");
                answer = Fraction.divide(f1, f2);
            }

//            Fraction userInput = new Fraction(input.next());
            String userInput = input.nextLine();
            Fraction fractionInput;

            total ++;
            if (userInput.equals("quit")) {
                total --;
                break;
            }
            else fractionInput = new Fraction(userInput);

            if (fractionInput.toDouble() == answer.toDouble()) {
                score ++;
                System.out.println("Correct! Good Job, now try this one.");
            }
            else System.out.println("Nope, you got it wrong. The answer is: " + answer);
        }

        Fraction result = new Fraction(score, total);
        System.out.println("Wow, impressive! You got " + result + ", that is " + result.toDouble()*100 + "%");
    }
}
