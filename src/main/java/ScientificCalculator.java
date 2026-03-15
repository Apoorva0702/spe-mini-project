import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ScientificCalculator {
    private static final Logger logger = LogManager.getLogger(ScientificCalculator.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Scientific Calculator for DevOps Project ---");

        while (true) {
            System.out.println("\nSelect Operation:");
            System.out.println("1. Square root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural logarithm (ln(x))");
            System.out.println("4. Power function (x^b)");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            if (choice == 5) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    double a = scanner.nextDouble();
                    System.out.println("Result: " + squareRoot(a));
                    break;
                case 2:
                    System.out.print("Enter integer: ");
                    int b = scanner.nextInt();
                    System.out.println("Result: " + factorial(b));
                    break;
                case 3:
                    System.out.print("Enter number: ");
                    double c = scanner.nextDouble();
                    System.out.println("Result: " + naturalLog(c));
                    break;
                case 4:
                    System.out.print("Base (x): ");
                    double base = scanner.nextDouble();
                    System.out.print("Exponent (b): ");
                    double exp = scanner.nextDouble();
                    System.out.println("Result: " + power(base, exp));
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
        scanner.close();
    }

    public static double squareRoot(double x) {
        logger.info("[SQRT] - " + x);
        return Math.sqrt(x);
    }

    public static long factorial(int x) {
        logger.info("[FACTORIAL] - " + x);
        long result = 1;
        for (int i = 1; i <= x; i++) result *= i;
        return result;
    }

    public static double naturalLog(double x) {
        logger.info("[LOG] - " + x);
        return Math.log(x);
    }

    public static double power(double x, double b) {
        logger.info("[POWER] - " + x + " to " + b);
        return Math.pow(x, b);
    }
} //comment