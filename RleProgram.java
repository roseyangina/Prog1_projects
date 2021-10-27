import java.util.Scanner;

public class RleProgram {
    public static void main(String[] args) {
        //initializing variables to be used in the program

        String userInput;
        byte[] loadedImage = null;
        int menuOption = 1;

        Scanner in = new Scanner(System.in);

        // 1. Display welcome message

        System.out.println("Welcome to the RLE image encoder!" + "\n");

        //2. Display color test with the message

        System.out.println("Displaying Spectrum Image:");
        ConsoleGfx.displayImage(ConsoleGfx.testRainbow);
        System.out.println();

        //3. Display the menu - while loop or if-else chain
        while (menuOption != 0) {
            System.out.println(
                        "RLE Menu\n" +
                            "--------\n" +
                            "0. Exit\n" +
                            "1. Load File\n" +
                            "2. Load Test Image\n" +
                            "3. Read RLE String\n" +
                            "4. Read RLE Hex String\n" +
                            "5. Read Data Hex String\n" +
                            "6. Display Image\n" +
                            "7. Display RLE String\n" +
                            "8. Display Hex RLE Data\n" +
                            "9. Display Hex Flat Data\n\n" +
                            "Select a Menu Option: ");
            menuOption = in.nextInt();          //scans user input on choice of menu option

            //Invokes ConsoleGfx.loadFile(UserInput) and store the returned bytes array into imageData array
            if (menuOption == 1) {
                System.out.println("Enter name of file to load: ");
                userInput = in.next();
                loadedImage = ConsoleGfx.loadFile(userInput);
            }

            // option 2 - Load file - Store ConsoleGfx.testImage into the imageData array
            else if (menuOption == 2) {
                System.out.println("Test image data loaded.");
                loadedImage = ConsoleGfx.testImage;

            }
            //option 3: Reading RLE String
            else if (menuOption == 3) {
                System.out.print("Enter an RLE string to be decoded: ");
                userInput = in.next();
                loadedImage = decodeRle(stringToRle(userInput));
            }

            //option 4: Reading RLE Hex String
            else if (menuOption == 4) {
                System.out.print("Enter the hex string holding RLE data: ");
                userInput = in.next();
                loadedImage = decodeRle(stringToData(userInput));
            }
            //option 5: Reading Flat Data Hex String
            else if (menuOption == 5) {
                System.out.print("Enter the hex string holding flat data: ");
                userInput = in.next();
                System.out.println();
                loadedImage = stringToData(userInput);
            }

            // option 6 -display image stored inside imageData array
            else if (menuOption == 6) {
                ConsoleGfx.displayImage(loadedImage);
            }

            //option 7: Displaying the RLE String
            else if (menuOption == 7)
            {
                System.out.print("RLE representation: ");
                if (loadedImage == null || loadedImage.length == 0)
                    System.out.println("(no data)");
                else
                    System.out.println(toRleString(encodeRle(loadedImage)));
            }

            //option 8: Displaying the RLE Hex Data
            else if (menuOption == 8) {
                System.out.print("RLE hex values: ");
                if (loadedImage == null || loadedImage.length == 0)
                    System.out.println("(no data)");
                else
                    System.out.println(toHexString(encodeRle(loadedImage)));
            }
            //option 9: Displaying the Flat Hex Data
            else if (menuOption == 9) {
                System.out.print("Flat hex values: ");
                if (loadedImage == null || loadedImage.length == 0)
                    System.out.println("(no data)");
                else
                    System.out.println(toHexString(loadedImage));

                }
            }

        }

        //Invoking the methods called upon in this program.

        //M1: translate data to hex string
        public static String toHexString(byte[] data)
            {
                StringBuilder result = new StringBuilder();
                for (byte b : data)
                    result.append(Integer.toHexString(b));
                return result.toString();
            }
        //M2: returns runs of data in image data set

        public static int countRuns ( byte[] flatData){

                int r = 1; // r for runs
                int repeats = 1;
                for (int i = 0; i + 1 < flatData.length; i++) {
                    //matching and not the last
                    if (flatData[i] == flatData[i + 1] && i + 2 != flatData.length)
                        repeats++;
                        //do not match or last
                    else {
                        //max of 15 runs or repeats for a byte in a row
                        r += Math.ceil(repeats / 15.0);
                        repeats = 1;

                        //not matching and last, then subtract one as runs was twice incremented for the last byte
                        if (i + 2 == flatData.length && flatData[i] == flatData[i + 1])
                            r--;
                    }
                }
                return r;
            }
        //M3: Returns encoding(in RLE) of the raw data passed in.
        public static byte[] encodeRle ( byte[] flatData)
        {
                byte[] result = new byte[countRuns(flatData) * 2];
                byte repeatByte, repeats = 1;
                short resultIndex = 0;
                repeatByte = flatData[0];

                for (int i = 0; i < flatData.length; i++) {
                    if (i + 1 < flatData.length && flatData[i] == flatData[i + 1])
                        repeats++;
                    else {
                        //maximum of 15 runs or repeats for a byte in a row
                        double runs = Math.ceil(repeats / 15.0);
                        for (int j = 0; j < runs; j++) {
                            result[resultIndex] = (byte) Math.min(15, repeats);
                            repeats -= 15;
                            result[resultIndex + 1] = repeatByte;
                            resultIndex += 2;
                        }
                        repeats = 1;
                        if (i + 1 < flatData.length)
                            repeatByte = flatData[i + 1];
                    }
                }
                return result;
            }

        //M4: Return decompressed size RLE data, used to generate flat data from RLE encoding.
        public static int getDecodedLength ( byte[] rleData)
            {
                int result = 0;
                for (int i = 0; i < rleData.length; i += 2)
                    result += rleData[i];
                return result;
            }

        //M5: Return the decoded data set from RLE encoded data.
        public static byte[] decodeRle ( byte[] rleData)
            {
                byte[] result = new byte[getDecodedLength(rleData)];
                int indexDecode = 0;
                for (int i = 0; i + 1 < rleData.length; i += 2) {
                    for (int j = 0; j < rleData[i]; j++)
                        result[indexDecode + j] = rleData[i + 1];
                    indexDecode += rleData[i];
                }
                return result;
            }

        //M6: translate hex string to byte data
        public static byte[] stringToData (String dataString)
        {
                byte[] result = new byte[dataString.length()];
                for (int i = 0; i < dataString.length(); i++) {
                    char c = dataString.charAt(i);
                    switch (c) {
                        // convert letter  to integer
                        case 48:
                            result[i] = 0;
                            break;
                        case 49:
                            result[i] = 1;
                            break;
                        case 50:
                            result[i] = 2;
                            break;
                        case 51:
                            result[i] = 3;
                            break;
                        case 52:
                            result[i] = 4;
                            break;
                        case 53:
                            result[i] = 5;
                            break;
                        case 54:
                            result[i] = 6;
                            break;
                        case 55:
                            result[i] = 7;
                            break;
                        case 56:
                            result[i] = 8;
                            break;
                        case 57:
                            result[i] = 9;
                            break;
                        case 97:
                            result[i] = 10;
                            break;
                        case 98:
                            result[i] = 11;
                            break;
                        case 99:
                            result[i] = 12;
                            break;
                        case 100:
                            result[i] = 13;
                            break;
                        case 101:
                            result[i] = 14;
                            break;
                        case 102:
                            result[i] = 15;
                            break;
                    }
                }
                return result;
            }
        //M7: Translating RLE data to human-readable string
        public static String toRleString(byte[] rleData)
        {
            StringBuilder result = new StringBuilder();
            int i;
            for (i = 0; i + 2 < rleData.length; i+=2)
            {
                result.append(rleData[i]).append(Integer.toHexString(rleData[i + 1]));
                result.append(":");
            }
            result.append(rleData[i]).append(Integer.toHexString(rleData[i + 1]));
            return result.toString();
        }

        //M8: Translating a string to RLE byte data
        public static byte[] stringToRle(String rleString)
        {
            int index = -1;
            int resIndex = 0; //resulting index
            byte repeats;
            char repeatedCharacter;
            int length = rleString.length() - rleString.replace(":", "").length();

            //sourced from https://stackoverflow.com/questions/275944/how-do-i-count-thenumber-of-occurrences-of-a-char-in-a-string

            length = length * 2 + 2;
            byte[] result = new byte[length];

            //Taking count of number of occurrences in string
            int i = 0;
            while (i < rleString.length())
            {
                index = rleString.indexOf(":", index + 1);
                if (index == -1)
                    index = rleString.length();
                String subStr = rleString.substring(i, index);
                repeats = Byte.parseByte( subStr.substring(0, subStr.length() -1) );
                repeatedCharacter = subStr.charAt(subStr.length()-1);
                result [resIndex] = repeats;
                result [resIndex + 1] =
                        Byte.parseByte(String.valueOf(repeatedCharacter),16);
                resIndex +=2;
                i = index + 1;
            }
            return result;
        }
    }









