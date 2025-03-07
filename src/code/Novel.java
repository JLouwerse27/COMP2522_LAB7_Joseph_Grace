/**
 * Describes a Novel object. Extends the comparable interface
 * and contains a constructor with validation methods for all
 * input parameters: Title, Author, and yearPublished. Contains
 * getters for all instance variables. Overrides the compareTo
 * method and contains a toString method to concatenate the
 * novel into a String representation.
 *
 * @author Liam Pickrell, Leslie Zhang, James Smith
 * @version 1.0
 */
    public class Novel  extends     Literature
                        implements  Comparable<Novel>
{

    // Instance Variable Declarations
    private final String title;
    private final int yearPublished;

    // Static Final constants declarations.
    private static final int CURRENT_YEAR = 2025;
    private static final int YEAR_ZERO = 0;


    // CONSTRUCTORS
    /**
     * Constructor for a Novel object. Validates
     * all input parameters using validation methods
     * then creates Novel objects.
     *
     * @param title the title of the Novel.
     */
    public Novel(String title, int yearPublished)
    {
        validateTitle(title);
        //validateYear(year);
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

    // ACCESSORS
    /**
     * Getter for the Novel's Title.
     *
     * @return the novel's title as a String.
     */
    @Override
    public final String getTitle()
    {
        return title;
    }

    @Override
    public int getYearPublished()
    {
        return yearPublished;
    }

    // OTHER METHODS
    /**
     * Overriding the compareTo method, if this novel is
     * Newer than the Novel we're comparing returns a
     * positive, if this Novel is Older than the Novel
     * we're comparing returns a negative value.
     *
     * @param n the novel we are comparing to.
     * @return positive if newer, negative if older.
     */
    @Override
    public int compareTo(Novel n)
    {
        return this.title.compareTo(n.title);
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
