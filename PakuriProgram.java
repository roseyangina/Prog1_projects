import java.util.Arrays;
import java.util.Scanner;

public class PakuriProgram {


        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            //1. Display welcome message
            System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
            //2. Prompt for capacity and confirm
            System.out.print("Enter max capacity of the Pakudex: ");
            boolean allowed = false;
            String tentative;
            int capacity = 0;
            while (!allowed) {
                tentative = input.next();
                boolean isNumber = false;
                for (int i = 0; i < tentative.length(); i++) {
                    if (Character.isDigit(tentative.charAt(i))) {
                        isNumber = true;
                    } else {
                        isNumber = false;
                    }
                }
                if (tentative.charAt(0) != '-' && isNumber) {
                    capacity = Integer.parseInt(tentative);
                    allowed = true;
                } else {
                    allowed = false;
                    System.out.println("Please enter a valid size.");
                    System.out.print("Enter max capacity of the Pakudex: ");
                }
            }
            Pakudex pakudex = new Pakudex(capacity);
            System.out.print("The Pakudex can hold " + pakudex.getCapacity() + " species of Pakuri.");
                    System.out.println("");
            //3. Display the menu:
            System.out.print("\nPakudex Main Menu\n" +
                    "-----------------\n" +
                    "1. List Pakuri\n" +
                    "2. Show Pakuri\n" +
                    "3. Add Pakuri\n" +
                    "4. Evolve Pakuri\n" +
                    "5. Sort Pakuri\n" +
                    "6. Exit\n");
            //4. Prompt for input.
            System.out.print("\nWhat would you like to do? ");
            boolean exit = false;
            while (!exit) {
                String selection = input.next();
                while (!(selection.equals("1") ||
                        selection.equals("2") ||
                        selection.equals("3") ||
                        selection.equals("4") ||
                        selection.equals("5") ||
                        selection.equals("6"))) {
                    System.out.println("Unrecognized menu selection!");
                    System.out.print("\nPakudex Main Menu\n" +
                            "-----------------\n" +
                            "1. List Pakuri\n" +
                            "2. Show Pakuri\n" +
                            "3. Add Pakuri\n" +
                            "4. Evolve Pakuri\n" +
                            "5. Sort Pakuri\n" +
                            "6. Exit\n");
                    //4. Prompt for input.
                    System.out.print("\nWhat would you like to do? ");
                    selection = input.next();
                }
                switch (selection) {
                    case "1": //List Pakuri
                        String[] list = pakudex.getSpeciesArray();
                        if (list != null) {
                            System.out.print("Pakuri In Pakudex:\n");
                            for (int i = 0; i < list.length; i++) {
                                System.out.println((i + 1) + ". " + list[i]);
                            }
                        }
                        else {
                            System.out.print("No Pakuri in Pakudex yet!");
                        }
                        System.out.print("\nPakudex Main Menu\n" +
                                "-----------------\n" +
                                "1. List Pakuri\n" +
                                "2. Show Pakuri\n" +
                                "3. Add Pakuri\n" +
                                "4. Evolve Pakuri\n" +
                                "5. Sort Pakuri\n" +
                                "6. Exit\n");
                        //4. Prompt for input.
                        System.out.print("\nWhat would you like to do? ");
                        break;
                    case "2": //Show Pakuri
                        System.out.print("Enter the name of the species to display: ");
                                //returns array, need to print Attack: [0] defense: [1] speed [2]
                                String species = input.next();
                        int[] stats;
                        stats = pakudex.getStats(species);
                        if (stats==null || stats[0]==0 && stats[1] == 0 && stats[2]
                                ==0){
                            System.out.print("Error: No such Pakuri!");
                        }
                        else
                        {
                            System.out.println("Species: " + species);
                            System.out.println("Attack: " + stats[0]);
                            System.out.println("Defense: " + stats[1]);
                            System.out.println("Speed: " + stats[2]);
                        }
                        System.out.print("\nPakudex Main Menu\n" +
                                "-----------------\n" +
                                "1. List Pakuri\n" +
                                "2. Show Pakuri\n" +
                                "3. Add Pakuri\n" +
                                "4. Evolve Pakuri\n" +
                                "5. Sort Pakuri\n" +
                                "6. Exit\n");
                        //4. Prompt for input.
                        System.out.print("\nWhat would you like to do? ");
                        break;
                    case "3": //Add Pakuri
                        if (pakudex.getSize()==pakudex.getCapacity()){
                            System.out.print("Error: Pakudex is full!");
                            System.out.print("\n\nPakudex Main Menu\n" +
                                    "-----------------\n" +
                                    "1. List Pakuri\n" +
                                    "2. Show Pakuri\n" +
                                    "3. Add Pakuri\n" +
                                    "4. Evolve Pakuri\n" +
                                    "5. Sort Pakuri\n" +
                                    "6. Exit\n");
                            //4. Prompt for input.
                            System.out.print("\nWhat would you like to do? ");
                            break;
                        }

                        System.out.print("Enter the name of the species to add: ");
                                String addspecies = input.next();
                        pakudex.addPakuri(addspecies);
                        System.out.print("\n\nPakudex Main Menu\n" +
                                "-----------------\n" +
                                "1. List Pakuri\n" +
                                "2. Show Pakuri\n" +
                                "3. Add Pakuri\n" +
                                "4. Evolve Pakuri\n" +
                                "5. Sort Pakuri\n" +
                                "6. Exit\n");
                        //4. Prompt for input.
                        System.out.print("\nWhat would you like to do? ");
                        break;
                    case "4": //Evolve Pakuri
                        System.out.print("Enter the name of the species to evolve: ");
                        String evolve = input.next();
                        //boolean check
                        if ( pakudex.evolveSpecies(evolve)==true) {
                            System.out.println(evolve + " has evolved!");
                        }
                        else {
                            System.out.println("Error: No such Pakuri!");
                        }
                        System.out.print("\nPakudex Main Menu\n" +
                                "-----------------\n" +
                                "1. List Pakuri\n" +
                                "2. Show Pakuri\n" +
                                "3. Add Pakuri\n" +
                                "4. Evolve Pakuri\n" +
                                "5. Sort Pakuri\n" +
                                "6. Exit\n");
                        //4. Prompt for input.
                        System.out.print("\nWhat would you like to do? ");
                        break;
                    case "5": //Sort Pakuri
                        pakudex.sortPakuri();
                        System.out.print("\nPakudex Main Menu\n" +
                                "-----------------\n" +
                                "1. List Pakuri\n" +
                                "2. Show Pakuri\n" +
                                "3. Add Pakuri\n" +
                                "4. Evolve Pakuri\n" +
                                "5. Sort Pakuri\n" +
                                "6. Exit\n");
                        //4. Prompt for input.
                        System.out.print("\nWhat would you like to do? ");
                        break;
                    case "6": //Exit
                        exit = true;
                        System.out.print("Thanks for using Pakudex! Bye!");
                }
            }
        }

    }
