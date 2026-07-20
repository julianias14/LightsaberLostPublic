package archives;

/**
 * Jedi class for a single Jedi on LightsaberLost
 * 
 * It contains attibutes such as name, age, homeworld, and lightsaber clues
 * 
 * @authors Juliania Shyprykevych, Meenakshi Anoop
 */

public class Jedi {
    //Jedi's full name
    private String name;
    //Jedi's age
    private int age;
    //Jedi's homeworld
    private String homeworld;
    //Jedi's lightsaber color
    private String lightsaberColor;
    //Jedi's lightsaber hilt material
    private String lightsaberHilt;
    //Jedi's lightsaber image path name
    private String image;
    //Jedi's image
    private String jediImage;

    /**
     * Jedi constructor which initialies all attributes
     * 
     * 
     * @param name      String full name of Jedi
     * @param age       age of Jedi
     * @param homeworld homeworld of Jedi
     * @param lightsaberColor   Jedi's lightsaber color
     * @param lightsaberHilt    Jedi's lightsaber hilt material
     * @param image             Jedi's image path name
     */
    public Jedi(String name, int age, String homeworld, String lightsaberColor, String lightsaberHilt, String image) {
        this.name = name;
        this.age = age;
        this.homeworld = homeworld;
        this.lightsaberColor = lightsaberColor;
        this.lightsaberHilt = lightsaberHilt;
        this.image = image;
    }

    public Jedi() {
        this(null, 0, null, null, null,null);
    }

    /**
     * @return This Jedi's name
     */
    public String getName() { return name; }
    public void setName(String s) { name = s; }

    /**
     * @return This Jedi's age
     */
    public int getAge() { return age; }
    public void setAge(int a) { age = a; }

    /**
     * @return This Jedi's homeworld
     */
    public String getHomeworld() { return homeworld; }
    public void setHomeworld(String h) { homeworld = h; }

    /**
     * @return This Jedi's lightsaber color
     */
    public String getLightsaberColor() { return lightsaberColor; }
    public void setLightsaberColor(String c) { lightsaberColor = c; }

    /**
     * @return This Jedi's lightsaber hilt
     */
    public String getLightsaberHilt() { return lightsaberHilt; }
    public void setLightsaberHilt(String h) { lightsaberHilt = h; }

    /**
     * @return This Jedi's image path name
     */
    public String getImage() { return image; }
    public void setImage(String i) { image = i; }

    /**
     * @return This Jedi's image path name
     */
    public String getJediImage() { return jediImage; }
    public void setJediImage(String i) { jediImage = i; }

    /**
     * Checks if two Jedi are equal
     * 
     * @param o Object to compare to
     */
    @Override
    public boolean equals(Object o) {  
        if (o == null  || !(o instanceof Jedi)) {
            return false;
        }
        if (o instanceof Jedi) {
            Jedi j = (Jedi) o;

            boolean nameCheck;
            if(name == null) {
                nameCheck = (j.getName() == null);
            } else {
                nameCheck = name.equals(j.getName());
            }

            boolean homeworldCheck;
            if(homeworld == null) {
                homeworldCheck = (j.getHomeworld() == null);
            } else {
                homeworldCheck = homeworld.equals(j.getHomeworld());
            }

            boolean lightsaberColorCheck;
            if(lightsaberColor == null) {
                lightsaberColorCheck = (j.getLightsaberColor() == null);
            } else {
                lightsaberColorCheck = lightsaberColor.equals(j.getLightsaberColor());
            }

            boolean lightsaberHiltCheck;
            if(lightsaberHilt == null) {
                lightsaberHiltCheck = (j.getLightsaberHilt() == null);
            } else {
                lightsaberHiltCheck = lightsaberHilt.equals(j.getLightsaberHilt());
            }

            boolean imageCheck;
            if(image == null) {
                imageCheck = (j.getImage() == null);
            } else {
                imageCheck = image.equals(j.getImage());
            }

            return nameCheck && j.getAge()==age && homeworldCheck && lightsaberColorCheck && lightsaberHiltCheck && imageCheck;
        }
        return false;
    }
}
