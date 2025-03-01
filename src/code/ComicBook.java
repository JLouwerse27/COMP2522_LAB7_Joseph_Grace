public class ComicBook
                extends Literature
{
    // VARIABLE DECLARATIONS
    private String title;

    // CONSTRUCTORS
    public ComicBook(String title)
    {
        this.title = title;
    }

    // OTHER METHODS
    @Override
    public String getTitle() {
        return title;
    }
}
