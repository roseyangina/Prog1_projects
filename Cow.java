public class Cow {
    private final String name;
    private String image = "";

    public Cow(String cowName)
    {
        name = cowName;
    }

    //return cow nem
    public String getName()
    {
        return name;
    }

    //return cow image
    public String getImage()
    {
        return image;
    }

    //set cow image
    public void setImage(String s)
    {
        image = s;
    }
}
