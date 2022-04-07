public class Dragon extends Cow {
    public Dragon(String dragonName, String dragonImage)
    {
        super(dragonName);
        setImage(dragonImage);
    }

    public boolean canBreathFire()
    {
        return true;
    }
}
