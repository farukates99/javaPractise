import java.util.Comparator;

public class Book implements Comparable<Book> {
    private String bookName;
    private int pageNumber;

    public Book(String bookName, int pageNumber) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public int compareTo(Book o) {

        return this.getBookName().compareTo(o.getBookName());
        };
    }
