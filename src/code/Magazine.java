public class Magazine
        extends Literature
{
    // VARIABLE DECLARATIONS
    private String title;

    // CONSTRUCTORS
    public Magazine(String title)
    {
        this.title = title;
    }

    // OTHER METHODS
    @Override
    public String getTitle() {
        return title;
    }
}
