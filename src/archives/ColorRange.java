package archives;
/**
 * ColorRange class representing indices for a selected lightsaber color in the Jedi archives after it is sorted by color.
 * 
 * The Color Range stores the starting and ending index for each color.
 * @authors Juliania Shyprykevych, Meenakshi Anoop
 */
public class ColorRange {
    //starting index for color within the archives when sorted by color
    private int startIndex;
    //last index for color within the archives when sorted by color
    private int lastIndex;

    /**
     * Color range constructor which initialies the first and last indices of colors within the archives when sorted by color.
     * 
     * @param startIndex starting index of a color
     * @param lastIndex  last index of a color
     */
    public ColorRange(int startIndex, int lastIndex) {
        this.startIndex = startIndex;
        this.lastIndex = lastIndex;
    }

    public ColorRange() {
        this(-1,-1);
    }

    /**
     * @return This color's starting index
     */
    public int getStartIndex() { return startIndex; }
    public void setStartIndex(int s) { startIndex = s; }

    /**
     * @return This color's last index
     */
    public int getLastIndex() { return lastIndex; }
    public void setLastIndex(int l) { lastIndex = l; }
}
