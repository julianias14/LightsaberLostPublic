package archives;
import java.util.ArrayList;

/**
 * The LightsaberLost class represents methods to be implemented on the archives.
 * This class will be filled out and submitted
 * @authors Juliania Shyprykevych, Meenakshi Anoop
 */

public class Student_LightsaberLost {
    private ArrayList<Jedi> archives; //reference to archives ArrayList
    /**
     * Default constructor
     * Creates a new arraylist for the archives
     */
    public LightsaberLost() {
        //DO NOT edit or remove
        archives = new ArrayList<>();
    }

    /**
     * Build the archives based on data within a CSV file
     * Loop through the file and create new Jedi objects for each line
     * After creating the object, add it to the archives arraylist
     * 
     * @param filename The file to be read
     */
    public void rebuildArchive(String filename) {
        //WRITE YOUR CODE HERE
    }

    /**
     * Utilize selection sort to sort the archives arraylist by color in alphabetical order.
     * 
     */
    public void sortByColor() {
        //WRITE YOUR CODE HERE
    }

    /**
     * Create a new ColorRange object and utilize binary search to search through the archives arraylist for the starting and ending indices of a color.
     * Use binary search to find the matching color.
     * Once found, locate the starting index of this color and add it to a ColorRange object into the first index attribute.
     * Then, find the last index of the color and add it to the ColorRange last index attribute.
     * Return the ColorRange object created.
     * 
     * @param color the color to be searched for within the arraylist
     * 
     * @return a ColorRange object containing the starting and ending index of @param color after the archives have been sorted by color.
     */
    public ColorRange extractColor(String color) {
        //WRITE YOUR CODE HERE
        return null; //update this line, it is provided so the code compiles
    }

    /**
     * The archives have now been turned into an array through the driver and are given as a parameter.
     * Debug the code for insertion sort below using the debugger so that it correctly sorts the lightsabers
     * alphabetically by their hilt.
     * 
     * @param arr archives array to be sorted
     * 
     */
    public void sortByHilt(Jedi[] arr){
    //DEBUG THE FOLLOWING SOLUTION
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int minimumIndex = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j].getLightsaberHilt().compareTo(arr[minimumIndex].getLightsaberHilt()) > 0){
                    minimumIndex = j;
                }
            }

            Jedi temp = arr[i];
            arr[i] = arr[minimumIndex];
            arr[i] = temp;
        }
    }

    /**
     * Utilize binary search on the array to find the hilt that matches the lightsaber's owner.
     * 
     * @param arr archives array to be searched through
     * @param hilt to be searched for
     * 
     * @return the Jedi object from the @param Jedi arr[] that matches the @param String hilt.
     */
    public Jedi findOwner(Jedi arr[], String hilt) {
        //WRITE YOUR CODE HERE
        return null; //update this line, it is provided so the code compiles
    }
    /**
     * @return the selected archives
     */
    public ArrayList<Jedi> getArchives(){
        return archives;
    }
}
