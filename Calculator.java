import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        float operand01;                                     //operand01 is used to indicate first operand
        float operand02;                                        //operand02 is used to indicate second operand

        System.out.print("Enter first operand:");
        operand01 = scanner.nextFloat();
        System.out.print("Enter second operand:");
        operand02 = scanner.nextFloat();

        System.out.print("Calculator Menu");
        System.out.println("---------------");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.print("Which operation do you want to perform?");
        int choice = scanner.nextInt();

        float answer = 0;
        switch (choice) {

            case 1:
                answer = (operand01 + operand02);
                break;

            case 2:
                answer = (operand01 - operand02);
                break;

            case 3:
                answer = (operand01 * operand02);
                break;

            case 4:
                answer = (operand01 / operand02);
                break;
            default:
                answer = -999999;
        }


            if (answer == -999999) {
                System.out.println("Error: Invalid selection! Terminating program.");
        }
            else {
                System.out.println("The result of the operation is" + " " + answer + "." + "Goodbye!");
            }



    }
}

