public class Cowsay {
    public static void main(String[] args)
    {
        if (args.length > 0)
        { // Initiate with at least one argument.
            checkArguments(args);
        }
    }

    private static void checkArguments(String[] args)
    {
        Cow[] cows = HeiferGenerator.getCows();// return the cows created in the heifer class for requested cows.

		/* ----EXPECTED ARGUMENTS----
		1. Check if -l argument exists
		2. Check if -n argument exists, check if cow type is dragon -> Check if can breath fire
		3. if any of the above is in the shadow realm (none-existent), default to pikachu
		 */

        switch (args[0])
        {
            case "-l"://List all the cows
                listCows(cows);
                break;

            case "-n": //Prints out cow image and message if available
                if (args.length > 1)//Confirm there's more than one argument
                {
                    Cow cow = findCow(args[1], cows);//find a specific cow, if not valid -> returns null

                    if (cow == null)//Check null -> could not find cow,print error message
                    {
                        System.out.println("Could not find " + args[1] + " cow!");
                    } else //Cow is valid -> check if there are additional arguments
                    {
                        if (args.length > 2)
                        {
                            //Check if cow is dragon
                            if (cow instanceof Dragon)
                            {
                                //is Dragon -> Check if it can breathe fire, print arguments as messages
                                //print dragon image and an additional fire specific message
                                printDragon(cow, args, ((Dragon) cow).canBreathFire());
                            } else //is regular cow -> print further arguments as messages
                            {
                                printCow(cow, 2, args);
                            }
                        }//else -> print cow with no message
                    }
                }//else -> is less than 1 argument, print default cow image
                break;

            default://print all arguments as messages by default
                printCow(cows[0], 0, args);
                break;
        }
    }

    //Helper method to print message and cow image using specific index
    private static void printCow(Cow cow, int startingIndex, String[] args)
    {
        for (int i = startingIndex; i < args.length - 1; i++)//print all except the last argument
        {
            System.out.print(args[i] + " ");
        }
        //Print last argument without a space
        System.out.print(args[args.length - 1]);
        //print the cow image on a new line
        System.out.println();
        System.out.println(cow.getImage());
    }

    private static void printDragon(Cow dragon, String[] args, boolean canBreatheFire)
    {
        for (int i = 2; i < args.length - 1; i++)//print all except the last argument
        {
            System.out.print(args[i] + " ");
        }
        //Print last argument without a space
        System.out.print(args[args.length - 1]);
        //print the cow image on a new line
        System.out.println();
        System.out.println(dragon.getImage());



        //Check if breathe is fire -> print about it
        if (canBreatheFire)
        {
            System.out.println("This dragon can breathe fire.");
        } else
        {
            System.out.println("This dragon cannot breathe fire.");
        }
    }

    // private helper method to call on for the list of cows.
    private static void listCows(Cow[] cows)
    {
        System.out.print("Cows available: ");
        for (Cow cow : cows)
        {
            System.out.print(cow.getName() + " ");
        }
        System.out.println();
    }

    // private helper method to call on for cows name.
    private static Cow findCow(String name, Cow[] cows)
    {
        for (Cow cow : cows)
        {
            if (cow.getName().equals(name))//Check if queried cow name is exists
            {
                return cow;
            }
        }
        return null;
    }
}
