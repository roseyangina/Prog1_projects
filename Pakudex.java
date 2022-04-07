public class Pakudex {

    private Pakuri[] pakudex;
    private int capacity = 0;
    public Pakudex(){
        //Default constructor; if called, the default size for the Pakudex should be 20
        pakudex = new Pakuri[20];
    }
    public Pakudex(int capacity){
        //Initializes this object to contain exactly capacity objects when completely full
        pakudex = new Pakuri[capacity];
    }
    public int getSize(){
        //Returns the number of critters currently being stored in the Pakudex
        int size = 0;
        for (int i =0; i<pakudex.length; i++){
            if (pakudex[i]!=null){
                size+=1;
            }
        }
        return size;
    }
    public int getCapacity(){
        //Returns the number of critters that the Pakudex has the capacity to hold at most
        return pakudex.length;
    }
    public String[] getSpeciesArray(){
        //Returns a String array containing the species of the critters as ordered in the Pakudex;
        // if there are no species added yet, this method should return null
        int count;
        for (count = 0; count<pakudex.length; count++){
            if (pakudex[count] == null){
                break;
            }
        }
        String[] speciesArray = new String[count];
        for (int i = 0; i < speciesArray.length; i++)
        {
            speciesArray[i] = pakudex[i].getSpecies();
        }
        int size = 0;
        for (int i =0; i<pakudex.length; i++){
            if (pakudex[i]!=null){
                size+=1;
            }
        }
        if (size == 0)
        {
            return null;
        }
        return speciesArray;

    }
    public int[] getStats(String species) {
        int[] stats = {0,0,0};
        //(change the 100 value)
        //Returns an int array containing the attack, defense,
        // and speed statistics of species at indices 0, 1, and 2 respectively;
        // if species is not in the Pakudex, returns null.
        //find index of species, loop through pakudex
        int size = 0;
        for (int i =0; i<pakudex.length; i++){
            if (pakudex[i]!=null){
                size+=1;
            }
        }
        boolean check = false;
        for(int i = 0; i < size; i++)
        {
            if ((pakudex[i] != null) && species.equals(pakudex[i].getSpecies()))
            {
                check = true;
            }
        }
        if (check){
            for (int i = 0; i <= size; i++) {
                if (pakudex[i].getSpecies().equals(species)) {
                    stats[0] = pakudex[i].getAttack();
                    stats[1] = pakudex[i].getDefense();
                    stats[2] = pakudex[i].getSpeed();
                    return stats;
                } else if (i == pakudex.length - 1) {
                    return stats;
                }
            }
        }
        return null;
    }
    public void sortPakuri () {
        //Sorts the Pakuri objects in this Pakudex

        boolean swapped = true;
        for (int i = 0; i < pakudex.length && swapped; i++) {
            swapped = false;
            for (int j = 1; j < pakudex.length; j++) {
                if (pakudex[j] != null &&
                        (pakudex[j].getSpecies()).compareTo(pakudex[j - 1].getSpecies()) < 0) {
                    Pakuri temp = pakudex[j];
                    pakudex[j] = pakudex[j - 1];
                    pakudex[j - 1] = temp;
                    swapped = true;
                }
            }
        }

        System.out.print("Pakuri have been sorted!");
    }
        public boolean addPakuri (String species) {
            boolean added = true;
            int size = 0;
            for (int i =0; i<pakudex.length; i++){
                if (pakudex[i]!=null){
                    size+=1;
                }
            }
            if (size==pakudex.length){
                added = false;
                System.out.print("Error: Pakudex is full!");
                return added;
            }
            if (added==true){
                for (int i = 0; i < pakudex.length; i++)
                {
                    if ((pakudex[i] != null) &&
                            species.equalsIgnoreCase(pakudex[i].getSpecies()))
                    {
                        added = false;
                        System.out.println("Error: Pakudex already contains this species!");
                        return added;
                    }
                }
            }
            if (added==true){
                Pakuri newPakuri = new Pakuri(species);
                pakudex[size] = newPakuri;
            }
            //Adds species to the Pakudex; if successful, return true, and false otherwise
            System.out.print("Pakuri species " + species + " successfully added!");
            return added;
        }
        public boolean evolveSpecies (String species){
            boolean evolved = false;
            //Attempts to evolve species within the Pakudex; if successful, return true, and false otherwise
            int size = 0;
            for (int i =0; i<pakudex.length; i++){
                if (pakudex[i]!=null){
                    size+=1;
                }
            }
            boolean check = false;
            for(int i = 0; i < size; i++)
            {
                if ((pakudex[i] != null) &&
                        species.equals(pakudex[i].getSpecies()))
                {
                    check = true;
                }
            }
            if (check) {
                for (int i = 0; i < pakudex.length; i++) {
                    if ((pakudex[i].getSpecies()).equals(species)) {
                        pakudex[i].evolve();
                        evolved = true;
                        return evolved;
                    } else if (i == pakudex.length - 1) {
                        evolved = false;
                        return evolved;
                    }
                }
            }
            return evolved;
        }

    }




