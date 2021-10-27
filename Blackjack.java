import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        P1Random pullrandom = new P1Random();
        //defining variable at the beginning to keep track of the statistics
        int gameCount = 0;
        int gamesPlayed = 0;
        int playerscard = 0;
        int players_Hand = 0;
        int dealers_Hand = 0;
        int playerW = 0;
        int dealerW = 0;
        int tiedGames = 0;
        double percentageW = 0;
        double pcent = 0;

        String chooseMenu = "";
        System.out.println("START GAME #1");

        //Introducing the main loop of the operation

        while (!chooseMenu.equals("4")) {//main condition is based on player not picking the option to exit

            if (players_Hand > 21 || players_Hand == 0) {

                gameCount++;
                playerscard = pullrandom.nextInt(13) + 1;

                if (playerscard == 1) {
                    System.out.println("Your card is a ACE!");

                } else if (playerscard >= 2 && playerscard <= 10) {
                    System.out.println("Your card is a " + playerscard + "!");

                } else if (playerscard == 11) {
                    System.out.println("Your card is a JACK!");

                } else if (playerscard == 12) {
                    System.out.println("Your card is a QUEEN!");

                } else {
                    System.out.println("Your card is a KING!");
                }

                if (playerscard >= 1 && playerscard <= 10) {
                    players_Hand = playerscard;
                }
                else {
                    players_Hand = 10;
                }
                System.out.println("Your hand is: " + players_Hand + "\n"); // using \n to make output look neater

            }

                //Main menu that player chooses from
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println("Choose an option: ");

                chooseMenu = scanner.next();

                switch (chooseMenu) {
                    //case scenario outcomes depending on which option the player chooses from the menu
                    case "1":
                        playerscard = pullrandom.nextInt(13) + 1;

                        if (playerscard == 1) {
                            System.out.println("Your card is a ACE!");
                        }
                        else if (playerscard >= 2 && playerscard <= 10) {
                            System.out.println("Your card is a " + playerscard + "!");
                        }
                        else if (playerscard == 11) {
                            System.out.println("Your card is a JACK!");
                        }
                        else if (playerscard == 12) {
                            System.out.println("Your card is a QUEEN!");
                        }
                        else {
                            System.out.println("Your card is a KING!");
                        }

                        if (playerscard >= 1 && playerscard <= 10) {
                            players_Hand = players_Hand + playerscard;   //players hand value increases by card number
                        } else {

                            players_Hand = players_Hand + 10;
                        }
                        System.out.println("Your hand is: " + players_Hand + "\n");
                        // case scenarios in the game that determine who wins the rounds
                        if (players_Hand >= 21) {

                            if (players_Hand == 21 && dealers_Hand != 21) {
                                System.out.println("BLACKJACK! You win!");
                                System.out.println("START GAME #" + (gameCount + 1)); //to ensure the next game number is registered
                                players_Hand = 0;
                                playerW = playerW + 1;
                            }
                            else if (players_Hand < 21 && dealers_Hand > 21) {
                                System.out.println("Dealer's hand: " + dealers_Hand);
                                System.out.println("Your hand is: " + players_Hand);
                                System.out.println("You win!");
                                players_Hand = 0;
                                playerW = playerW + 1; //taking count of number of player wins for statistics
                                System.out.println("START GAME #" + (gameCount + 1));
                            }
                            else if (players_Hand > 21 && dealers_Hand <= 21) {
                                System.out.println("You exceeded 21! You lose.\n");
                                dealerW = dealerW + 1;      //keeping track of dealer's wins
                                System.out.println("START GAME #" + (gameCount + 1));
                            }
                            else if (players_Hand == dealers_Hand) {
                                System.out.println("Dealer's hand: " + dealers_Hand);
                                System.out.println("Your hand is : " + players_Hand);
                                System.out.println("It's a tie! No one wins!\n");
                                System.out.println("START GAME #" + (gameCount + 1));
                                players_Hand = 0;

                                tiedGames = tiedGames + 1; //taking count of number of tied games
                            }
                            gamesPlayed = gamesPlayed + 1;
                            break;
                        }
                        break;

                    case "2": // when player picks option 2 dealers hand is dealt
                        dealers_Hand = pullrandom.nextInt(11) + 16;
                        System.out.println("Dealer's hand: " + dealers_Hand);
                        System.out.println("Your hand is: " + players_Hand);

                        if (dealers_Hand > players_Hand && dealers_Hand <= 21) {

                            System.out.println("Dealer wins!\n");
                            System.out.println("START GAME #" + (gameCount + 1));
                            players_Hand = 0;
                            dealerW = dealerW + 1;

                        } else if (dealers_Hand < players_Hand) {
                            System.out.println("You win!\n");
                            players_Hand = 0;
                            System.out.println("START GAME #" + (gameCount + 1));
                            playerW = playerW + 1;

                        } else if (dealers_Hand > 21) {
                            System.out.println("You win!\n");
                            players_Hand = 0;
                            System.out.println("START GAME #" + (gameCount + 1));
                            playerW = playerW + 1;
                        } else {
                            System.out.println("It's a tie! No one wins!\n");
                            players_Hand = 0;
                            System.out.println("START GAME #" + (gameCount + 1));
                            tiedGames = tiedGames + 1;      //keeping count of tied games
                        }
                        gamesPlayed = gamesPlayed + 1;
                          break;

                    case "3": // if player picks option 3, statistics to be printed
                        System.out.println("Number of Player wins: " + playerW);
                        System.out.println("Number of Dealer wins: " + dealerW);
                        System.out.println("Number of tie games: " + tiedGames);
                        System.out.println("Total # of games played is: " + gamesPlayed);

                        if (gamesPlayed > 0) {
                            percentageW = (playerW / (double) gamesPlayed) * 100; //double is including as this is a floating point operation
                            pcent = Math.round(percentageW * 100.0) / 100.0; // finding percentage of player wins to the total number of games played
                            System.out.println("Percentage of Player wins: " + pcent + "%");
                        }

                        break;

                    case "4":
                        break;

                    default:            //if input in choosing from menu veers from what is required(options 1 through 4)
                        System.out.println("Invalid input!");
                        System.out.println("Please enter an integer value between 1 and 4."+ "\n");

                }
            }
        }
  }

































