import java.util.Scanner;

public class NumericConversion {

    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        // usersChoice is a variable stored as an integer to allow the user to choose from the allotted menu options.
        int menuOption ; //menuOption refers to the choice the user inputs from menu.

        String userInput; // String allows users to input String values to be converted to the Result.

        do {                //do- while loop to account for cho

            displayMenu(); // Invoking the displayMenu method.
            if(scn.hasNextInt()) {
                menuOption = scn.nextInt();
                /* Scanner. hasNextInt() method checks whether the current input contains an integer or not.
                From: https://www.delftstack.com/howto/java/check-if-input-is-integer-in-java/
                */
            }
            else {
                menuOption = 4;
            }
            // Switch method created to expound on the execution of each choice from Menu options.
            switch (menuOption) {
                    // Decode hexadecimal.
                        case 1:
                            System.out.print("Please enter the numeric string to convert: ");
                                userInput = scn.next(); // User inputs string to be converted to hexadecimal.
                            if (userInput.startsWith("0x")) {
                                userInput = userInput.substring(2); // Users input equals a substring to be converted.
                            }
                            System.out.println("Result: " + hexStringDecode(userInput) + "\n");
                            continue;
                      // Decode binary.
                        case 2:
                            System.out.print("Please enter the numeric string to convert: ");
                                userInput = scn.next();
                            if (userInput.startsWith("0b")) {
                                userInput = userInput.substring(2);
                            }
                            System.out.println("Result: " + binaryStringDecode(userInput) + "\n");
                            continue;
                       // Convert binary to hexadecimal.
                        case 3:
                            System.out.print("Please enter the numeric string to convert: ");
                                    userInput = scn.next();

                            if (userInput.startsWith("0x")) {
                                userInput = userInput.substring(2);
                            }
                            System.out.println("Result: " + binaryToHex(userInput) + "\n" );
                            continue;
                        case 4:
                            System.out.print("Goodbye!\n");
                            break;

                        default:
                            System.out.println("Invalid response.\n");
                            break;
                    } // End of switch method
                }
                while(menuOption != 4);
            } // Close main

            // Methods to called on to perform the case conversion calculations
            public static Long hexStringDecode(String hex) {
                long dec = 0;
                for (int i = 0; i < hex.length(); i++) {
                    dec = 16 * dec;
                    dec = dec + hexCharDecode(hex.charAt(i));
                }
                return dec;
         /* for (int i = hex.length() - 1, j = 0; i >= 0; i--, j++) {
         dec = dec + hexCharDecode(hex.charAt(i)) * (long) Math.pow(16, j);
         }
         return dec; */

            } // end of hexStringDecode method

        public static Long binaryStringDecode(String binary) {
            long dec = 0;
            for (int i = binary.length() - 1, j = 0; i >= 0; i--, j++) {
                dec += Integer.parseInt(String.valueOf(binary.charAt(i))) * (long)
                        Math.pow(2, j);
            }
            return dec;
        } // end of binaryStringDecode method.

        public static String binaryToHex(String binary) {
            String hex = "";
            for (int i = binary.length() - 4, j = binary.length(); j >= 0; i -= 4, j -=
                    4) {
                String group = binary.substring(Math.max(i, 0), j);
                int groupDec = 0;
                for (int k = group.length() - 1, m = 0; k >= 0; k--, m++) {
                    groupDec += Integer.parseInt(String.valueOf(group.charAt(k))) *
                            (int) Math.pow(2, m);
                }
                char groupHex;
                if (groupDec > 9) {
                    groupHex = (char) ((char) (groupDec - 10) + 'A');
                } else {
                    groupHex = (char) ((char) groupDec + '0');
                }
                hex = groupHex + hex;
            }
            return hex;

        } // close binaryToHex method

        public static short hexCharDecode(char digit) {
            short val = 0;
            if (digit >= '0' && digit <= '9') {
                val = (short) (digit - '0');
            } else if (digit >= 'A' && digit <= 'F') {
                val = (short) (digit - 'A' + 10);
            } else if (digit >= 'a' && digit <= 'f') {
                val = (short) (digit - 'a' + 10);
            }
            return val;
        } // Close hexCharDecode method.

          // Print menu options to the screen
        private static void displayMenu() {
            System.out.println("Decoding Menu");
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit\n");
            System.out.print("Please enter an option: ");
        } // End displayMenu Method.
}

