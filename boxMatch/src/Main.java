// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Fighter Rocky= new Fighter("Rocky",20,100,90,60);
        Fighter Ali =new Fighter("Ali",12, 150, 90,75);
        Match ilk=new Match(Ali,Rocky,80,100);
        ilk.run();
    }
}