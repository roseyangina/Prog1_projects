
import java.util.Scanner;

public class SciCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String operand01="";
        String operand02="";
        double sum = 0;
        int numOfCalculations = 0;
        double average = 0;

        int choice = 1;
        double result = 0.0;

while (true) {

    if (choice >= 1 && choice <= 6) {
        System.out.println("Current Result: " + result + "\n");
        System.out.println("Calculator Menu");
        System.out.println("---------------");
        System.out.println("0. Exit Program");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exponentiation");
        System.out.println("6. Logarithm");
        System.out.println("7. Display Average" + "\n");
    }
    System.out.println("Enter Menu Selection: ");

    choice = scanner.nextInt();

    if (choice >= 1 && choice <= 6) {
        System.out.println("Enter first operand: ");
        operand01 = scanner.next();

        System.out.println("Enter second operand: ");
        operand02 = scanner.next();
    }
    if (operand01.equals("RESULT")) {
        operand01=String.valueOf(result);
    } if(operand02.equals("RESULT")) {
        operand02=String.valueOf(result);
    }
                switch(choice) {
                    case 1:
                        result = Double.parseDouble((operand01)) + Double.parseDouble(operand02);
                        sum += result;
                        numOfCalculations++;
                        break;
                    case 2:
                        result = (Double.parseDouble(operand01) -Double.parseDouble(operand02));
                        sum += result;
                        numOfCalculations++;
                        break;
                    case 3:
                        result = Double.parseDouble(operand01) * Double.parseDouble(operand02);
                        sum += result;
                        numOfCalculations++;
                        break;
                    case 4:
                        result = Double.parseDouble(operand01) / Double.parseDouble(operand02);
                        sum += result;
                        numOfCalculations++;
                        break;
                    case 5:
                        result = Math.pow(Double.parseDouble(operand01),Double.parseDouble(operand02));
                        sum += result;
                        numOfCalculations++;
                        break;
                    case 6:
                        result = Math.log(Double.parseDouble(operand02)) / Math.log(Double.parseDouble(operand01));
                        sum += result;
                        numOfCalculations++;
                        break;

                    case 7:
                        if (numOfCalculations>0){

                            result = (sum/numOfCalculations);
                            average = Math.round(result*100.0)/100.0;

                            System.out.println("Sum of calculations: " + sum);
                            System.out.println("Number of calculations: " + numOfCalculations);
                            System.out.println("Average of calculations: " + average );
                        } else{
                                System.out.println("Error: No calculations yet to average!"+"\n");
                        }

                        break;

                    case 0:
                        System.out.println("Thanks for using this calculator. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Error: Invalid selection!"+"\n");
                    }

                }
            }
        }



































