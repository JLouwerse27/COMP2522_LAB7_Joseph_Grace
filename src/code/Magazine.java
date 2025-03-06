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

    /**
     * To String Method to concatenate a string
     * representation of the Novel object.
     *
     * @return the String representation of the Novel.
     */
    @Override
    public String toString()
    {
        return (this.title);
    }
}
