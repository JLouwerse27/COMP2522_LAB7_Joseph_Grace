import java.util.*;


/**
 * Describes a Bookstore object. Contains the main method
 *
 * @author ...
 * @version ...
 */
public class Bookstore<T extends Literature> {
    private List<T> items = new ArrayList<>();
    private String name;

    //CONSTRUCTOR
    public Bookstore(String name){
        this.name = name;
    }

    // MAIN METHOD
    public static void main(final String[] args) {
        final Bookstore<Literature> store = new Bookstore<>("My Store");
        store.addItem(new Novel("War and Peace"));
        store.addItem(new ComicBook("Spider-Man"));
        store.addItem(new Magazine("National Geographic"));
        store.printItems(); // Should print titles from different item types
        store.printBookTitle("Random book title");
        store.printTitlesInAlphaOrder();

        // Create a List to hold Novel objects
        List<Novel> novelCollection = new ArrayList<>();
        // Pass that list to addNovelsToCollection
        store.addNovelsToCollection(novelCollection);

        // ---static nested class---
        BookstoreInfo bi = new BookstoreInfo();
        bi.displayInfo(store.getName(), store.items.size());

        // Instantiate the inner class
        Bookstore.NovelStatistics ns = store.new NovelStatistics();
        double avgTitleLength = ns.averageTitleLength();
        System.out.println("Average title length: " + avgTitleLength);
    }

    // OTHER METHODS
    public void addItem(T item) {
        items.add(item);
    }

    public void printItems() {
        for(T item : items) {
            System.out.println(item.getTitle());
        }
    }

    public void printBookTitle(final String title) {
        items.forEach(item -> {
            if (item.getTitle().contains(title)) {
                System.out.println(item.getTitle());
            }
        });
    }

    public void printTitlesInAlphaOrder() {
        items.sort(Comparator.comparing(T::getTitle));
        items.forEach(item -> System.out.println(item.getTitle()));
    }

    /**
     * Adds only Novels from this Bookstore to the given novelCollection
     */
    public void addNovelsToCollection(final List<? super Novel> novelCollection) {
        for (final T item : items) {
            if (item instanceof Novel) {
                novelCollection.add((Novel) item);
            }
        }
    }

    public String getName(){
        return name;
    }

    // Inner class
    class NovelStatistics {
        public double averageTitleLength() {
            int totalLength = 0;
            for (final T item : items) {
                totalLength += item.getTitle().length();
            }
            return (double) totalLength / items.size();
        }
    }

    // Static nested class
    static class BookstoreInfo {
        public void displayInfo(final String storeName, final int itemCount) {
            System.out.println("BookStore: " + storeName + ", Items: " + itemCount);
        }
    }
}
