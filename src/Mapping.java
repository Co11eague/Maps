import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mapping {

    public static final int INITIAL_LOCATION = 95;

    /** TODO
     * create a static LocationMap object
     */
    static LocationMap map = new LocationMap();

    /** TODO
     * create a vocabulary HashMap to store all directions a user can go
     */
    HashMap<String, String> vocabulary = new HashMap<>();
    /** TODO
     * create a FileLogger object
     */
    FileLogger fileLog = new FileLogger();

    /** TODO
     * create a ConsoleLogger object
     */
    ConsoleLogger consoleLog = new ConsoleLogger();


    public Mapping() {

        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("DOWN", "D");
        vocabulary.put("UP", "U");
        vocabulary.put("NORTHEAST", "NE");
        vocabulary.put("NORTHWEST", "NW");
        vocabulary.put("SOUTHEAST", "SE");
        vocabulary.put("SOUTHWEST", "SW");
        vocabulary.put("QUIT", "Q");




        /** TODO
         * complete the vocabulary HashMap <Key, Value> with all directions.
         * use the directions.txt file and crosscheck with the ExpectedInput and ExpectedOutput files to find the keys and the values
         */
    }

    public void mapping() {

        /** TODO
         * create a Scanner object
         */
        Scanner sc = new Scanner(System.in);

        /**
         * initialise a location variable with the INITIAL_LOCATION
         */
        int location = INITIAL_LOCATION;

        while (true) {

            /** TODO
             * get the location and print its description to both console and file
             * use the FileLogger and ConsoleLogger objects
             */
            consoleLog.log(map.get(location).getDescription());
            fileLog.log(map.get(location).getDescription());


            /** TODO
             * verify if the location is exit
             */


            /** TODO
             * get a map of the exits for the location
             */
            Location direc = map.get(location);


            /** TODO
             * print the available exits (to both console and file)
             * crosscheck with the ExpectedOutput files
             * Hint: you can use a StringBuilder to append the exits
             */
            StringBuilder s = new StringBuilder();
            s.append("Available exits are ");
            for (Object key : direc.getExits().keySet()) {
                s.append(key).append(", ");
            }
            fileLog.log(s.toString());
            consoleLog.log(s.toString());


            String dir;
            boolean mark = false;
            dir = sc.nextLine().toUpperCase();
            String[] words = dir.split("\\W+");
            try {
                location = (int) direc.getExits().get(vocabulary.get(dir));
                mark = true;

            } catch (Exception ignored) {
            }
            if (!mark) {
                //System.out.println("CAI");
                try {
                    location = (int) direc.getExits().get(dir);
                    mark = true;
                } catch (Exception ignored) {
                }
            }
            if (!mark) {
                for (String str : words) {
                    //System.out.println(str);
                    for (String test : vocabulary.keySet()) {
                        //System.out.println(str + " " + test);
                        if (test.equals(str)) {
                            //System.out.println(direc.getExits().get(vocabulary.get(str)));
                            try {
                                //System.out.println(location);
                                location = (int) direc.getExits().get(vocabulary.get(str));
                                mark = true;
                                //System.out.println(location);

                            } catch (Exception ignored) {
                            }
                        }
                        // System.out.println(location);
                    }
                }
            }
            if (!mark) {
                consoleLog.log("You cannot go in that direction");
                fileLog.log("You cannot go in that direction");
            }
            if (location == 0){
                consoleLog.log(map.get(location).getDescription());
                fileLog.log(map.get(location).getDescription());
                break;
            }
        }
        //System.out.println(location);







            /** TODO
             * input a direction
             * ensure that the input is converted to uppercase
             */

            /** TODO
             * are we dealing with a letter / word for the direction to go to?
             * available inputs are: a letter(the HashMap value), a word (the HashMap key), a string of words that contains the key
             * crosscheck with the ExpectedInput and ExpectedOutput files for examples of inputs
             * if the input contains multiple words, extract each word
             * find the direction to go to using the vocabulary mapping
             * if multiple viable directions are specified in the input, choose the last one
             */

            /** TODO
             * if user can go in that direction, then set the location to that direction
             * otherwise print an error message (to both console and file)
             * check the ExpectedOutput files
             */
        }

    public static void main(String[] args) {
        /**TODO
         * run the program from here
         * create a Mapping object
         * start the game
         */
        Mapping start  = new Mapping();
        start.mapping();
    }
}

