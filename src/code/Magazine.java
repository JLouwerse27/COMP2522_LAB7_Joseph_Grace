public class Magazine
        extends Literature
{
    // VARIABLE DECLARATIONS
    private final String title;
    private final int yearPublished;

    // CONSTRUCTORS
    public Magazine(String title, int yearPublished)
    {
        this.title = title;
        this.yearPublished = yearPublished;
    }

    // OTHER METHODS
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getYearPublished()
    {
        return yearPublished;
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
