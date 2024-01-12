import java.util.TreeSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        TreeSet<Book> books=new TreeSet<>();
        books.add(new Book("Harry Potter",500));
        books.add(new Book("Gregor",100));
        books.add(new Book("Darren Shan",250));
        books.add(new Book("Darren Shan 2",300));
        books.add(new Book("Suç ve Ceza",800));
        books.add(new Book("Gregor2",110));
        for(Book book : books){
            System.out.println(book.getBookName()+": "+book.getPageNumber());
        }
        TreeSet<Book> books2= new TreeSet<>(new OrderByPageNumberComparator());
        while (!books.isEmpty()){
        books2.add(books.pollFirst());}
        for(Book book : books2){
            System.out.println(book.getBookName()+": "+book.getPageNumber());
        }
    }
}