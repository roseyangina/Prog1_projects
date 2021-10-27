import java.util.Scanner;
public class ConnectFour {
    public static void main(String[] args) {

            Scanner scnr =new Scanner(System.in);
            int numberOfRows, numberOfColumns;
        //Intro to the game by asking for user input
            System.out.print("What would you like the height of the board to be ? ");
                    numberOfRows = scnr.nextInt();
            System.out.print("What would you like the length of the board to be ? ");
                    numberOfColumns = scnr.nextInt();

            char[][] board = new char[numberOfRows][numberOfColumns];
            initializeBoard(board);     //sets each spot in the array to “-”.
            printBoard(board);          //method to print the board
            System.out.println("Player 1: x");
            System.out.println("Player 2: o");
            boolean player1 = true;
            char player;
            int columnChoice, result;
            int totalPlays = 0;
            boolean hasPlayerWon;


            while (true){
                if (player1){
                    System.out.print("Player 1:");
                    player = 'x';
                } else {
                    System.out.print("Player 2:");
                    player = 'o';
                }
                System.out.print("Which column would you like to choose? ");
                columnChoice = scnr.nextInt();

                if(columnChoice < 0 || columnChoice >= numberOfColumns){
                    System.out.println("Please enter choice between 0 and " + (numberOfColumns - 1));
                } else {
                    result = insertChip(board, columnChoice, player);   //Places the token in the column that the user has chosen
                    if(result == -1) {
                        System.out.println("There is no room to insert.Please try again!!!");
                    } else {
                        printBoard(board);
                        hasPlayerWon =checkIfWinner(board, columnChoice,result,player);   /*After a token is added, checks
                         whether the token in this location, of the specified chip type, creates four in a row*/
                        if (hasPlayerWon){      //boolean statement
                            if (player1) {         //if player one has won
                                System.out.print("Player 1 won the game!");
                            } else {
                                System.out.print("Player 2 won the game!");
                            }
                            break;
                        }
                        player1 = !player1;
                        totalPlays++;
                    }
                }
                if (totalPlays == numberOfRows * numberOfColumns){
                    System.out.println("Draw. Nobody wins.");
                    break;
                }
            }   //end of while loop
        }
        //Methods invoked in the game in the while loop
        public static void printBoard(char[][] array) {
            for (int i = array.length - 1; i >= 0; i--){
                for(int j = 0; j < array[0].length; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        }
        public static void initializeBoard(char[][] array) {
            for (int i = 0; i < array.length; i++) {
                for(int j = 0; j < array[0].length; j++) {
                    array[i][j] = '-';
                }
            }
        }
        public static int insertChip(char[][] array, int col, char chipType) {
            for(int i = 0; i < array.length; i++) {
                if(array[i][col] == '-') {
                    array[i][col] = chipType;
                    return i;
                }
            }
            return -1;
        }
        public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
            int count = 0;
            for (char[] chars : array) {
                if (chars[col] == chipType) {
                    count++;
                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
            count = 0;
            for (int i = 0; i < array[0].length; i++) {
                if (array[row][i] == chipType) {
                    count++;
                    if(count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
            return false;
        }


    }//end of main class
