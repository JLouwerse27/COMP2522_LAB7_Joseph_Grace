public class ComicBook
                extends Literature
{
    // VARIABLE DECLARATIONS
    private final String title;
    private final int yearPublished;

    // CONSTRUCTORS
    public ComicBook(String title, int yearPublished)
    {
        validateTitle(title);
        this.title = title;
        this.yearPublished = yearPublished;
    }

    // VALIDATION METHODS
    /*
     * Validation method for title. Ensures the title isn't null
     * blank or empty string.
     *
     * @param title the title of the Novel.
     * @throws IllegalArgumentException if invalid.
     */
    private final void validateTitle(String title)
    {
        if(title == null    ||
                title.isEmpty()  ||
                title.isBlank())
        {
            throw new IllegalArgumentException("Invalid " +
                    "Title: " + title);
        }
    }


    // OTHER METHODS

    @Override
    public final String getTitle() {
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
