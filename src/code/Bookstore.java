import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * Describes a Bookstore object. Contains the main method
 *
 * @author Joseph Louwerse, Grace Jung
 * @version 1.0
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

        store.addItem(new Novel("War and Peace", 1951));
        store.addItem(new ComicBook("Spider-Man", 1962));
        store.addItem(new Magazine("National Geographic", 1940));
        store.printItems(); // Should print titles from different item types
        store.printBookTitle("Random book title");
        store.printTitlesInAlphaOrder();
        //fn should only return "National Geographic" and "Spider-Man" since "N" and "S" are before "T"
        store.printBooks(book -> book.getTitle().compareTo("Times Magazine") < 1);


        // Create a List to hold Novel objects
        List<Novel> novelCollection = new ArrayList<>();
        // Pass that list to addNovelsToCollection
        store.addNovelsToCollection(novelCollection);

        // ---static nested class---
        BookstoreInfo bi = new BookstoreInfo();
        bi.displayInfo(store.getName(), store.items.size());

        // Instantiate the inner class
        Bookstore.NovelStatistics ns = store.new NovelStatistics();
        ns.sortByTitleLength();
        double avgTitleLength = ns.averageTitleLength();
        System.out.println("Average title length: " + avgTitleLength);

        // Using a constructor reference
        Function<String, Bookstore> s2 = (name) -> new Bookstore(name);
        Bookstore store2 = s2.apply("Another Bookstore");

        Function<String, Novel> b1 = (name) -> new Novel(name);
        store2.addItem(b1.apply("How to write method references"));

        Function<String, ComicBook> b2 = (name) -> new ComicBook(name);
        store2.addItem(b2.apply("How to program"));

        Function<String, Magazine> b3 = (name) -> new Magazine(name);
        store2.addItem(b3.apply("Java: The best coding language"));

        store2.printItems();
    }

    // OTHER METHODS
    public void addItem(T item) {
        items.add(item);
    }

    public void printBooks(BookFilter filter) {
        Predicate<T> oldBooks = book -> book.getYearPublished() < 1950;
        Consumer<T> bookConsumer = book -> {
            if (filter.filter(book))
                System.out.println(book);
        };
        items.forEach(bookConsumer);

//        System.out.println("\n----printBooks()----");
//        for (T item: items) {
//            if (filter.filter(item)) {
//                System.out.println(item);
//            }
//        }
        }


    public void printItems() {

        System.out.println("----printItems()----");
        items.forEach(System.out::println);
    }

    public void printBookTitle(final String title) {
        items.forEach(item -> {
            if (item.getTitle().contains(title)) {
                System.out.println("📖 "  + item.getTitle());
            }
        });
    }

    public void printTitlesInAlphaOrder() {
        System.out.println("\n----printTitlesInAlphaOrder()----");
        items.sort(Comparator.comparing(T::getTitle));
        items.forEach(item -> System.out.println("📖 "  + item.getTitle()));
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

        public void sortByTitleLength() {
            System.out.println("---sortByTitleLength()---");
            items.sort(Comparator.comparingInt(novel -> novel.getTitle().length()));
            items.forEach(System.out::println);
        }

        public double averageTitleLength() {
            int totalLength = 0;
            for (final T item : items) {
                totalLength += item.getTitle().length();
            }
            return (items.size() > 0) ? (double) totalLength / items.size() : 0;
        }
    }

    // Static nested class
    static class BookstoreInfo {
        public void displayInfo(final String storeName, final int itemCount) {
            System.out.println("\nBookStore: " + storeName + ", Items: " + itemCount);
        }
    }
}
