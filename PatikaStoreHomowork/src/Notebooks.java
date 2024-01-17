import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Notebooks extends Products{
    static ArrayList<Notebooks> noteBooks= new ArrayList<>();

    static{
    noteBooks.add(new Notebooks(1,7000.0,0,5,"HUAWEI Matebook 14","Huawei",512,14,16));
    noteBooks.add(new Notebooks(2,3699.0,0,5,"LENOVO V14 IGL","Lenovo",1024,14,8));
    noteBooks.add(new Notebooks(3,8199.0,0,5,"ASUS Tuf Gaming","Asus",2048,15.6,32));
    }
    public Notebooks(int id, double price, int amountOfDiscount, int stockNumber, String productName, String brandName, int amountOfMemory, double screenSize, int ram) {
        super(id, price, amountOfDiscount, stockNumber, productName, brandName, amountOfMemory, screenSize, ram);
    }
    public Notebooks() {
        super();
    }

    public static ArrayList<Notebooks> getNoteBooks() {
        return noteBooks;
    }

    public static void setNoteBooks(ArrayList<Notebooks> noteBooks) {
        Notebooks.noteBooks = noteBooks;
    }

    public void getListBrands(){
        System.out.println("Notebook List");

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-9s | %-9s | %-9s |\n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");
        printProductInfo(noteBooks);
        System.out.println("----------------------------------------------------------------------------------------------------");
        return;
    }
    public void getListBrands(List<Notebooks> notebook){
        System.out.println("Notebook List");

        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-9s | %-9s | %-9s |\n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");
        printProductInfo(notebook);
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        return;
    }
    private static void printProductInfo(List<Notebooks> noteBooks) {
        for(Products list : noteBooks){
        System.out.printf("| %-3d | %-30s | %-9.2f | %-9s | %-9d | %-9.1f | %-9d |\n",
                list.getId(), list.getProductName(), list.getPrice(),
                list.getBrandName(), list.getAmountOfMemory(), list.getScreenSize(), list.getRam());
    }}
    public void setId(int id) {
        while(isIdUnique(id)) {
            System.out.println("This id is not a unique id");
            System.out.print("Enter the another id:");
            id=input.nextInt();
            System.out.println();
        }
        this.id = id;
    }
    private boolean isIdUnique(int id) {

        for (Notebooks product : noteBooks) {
            if (product.getId() == id) {
                return true; // Id zaten mevcut, eşsiz değil
            }
        }
        return false; // Id eşsiz
    }
    public void setProduct(){

        System.out.println("Enter the product information");
        System.out.print("Enter the product ID: ");
        this.setId(input.nextInt());
        System.out.println();
        System.out.println("Enter the product price: ");
        this.setPrice(input.nextDouble());
        System.out.println();
        System.out.println("Enter the amountofDiscount: ");
        this.setAmountOfDiscount(input.nextInt());
        input.nextLine();  // Consume the newline character
        System.out.println();
        System.out.println("Enter the product name: ");
        this.setProductName(input.nextLine());
        System.out.println();
        System.out.println("Enter the amount of stock: ");
        this.setStockNumber(input.nextInt());
        input.nextLine();
        System.out.println();
        System.out.println("Enter the brand name: ");
        this.setBrandName(input.nextLine());
        System.out.println();
        System.out.println("Enter the memory size: ");
        this.setAmountOfMemory(input.nextInt());
        System.out.println();
        System.out.println("Enter the screen size: ");
        this.setScreenSize(input.nextDouble());
        System.out.println();
        System.out.println("Enter the Ram: ");
        this.setRam(input.nextInt());
        System.out.println();
        this.addNewProduct();
    }
    public void addNewProduct(){
        noteBooks.add(new Notebooks(this.getId(),this.price,this.amountOfDiscount,this.stockNumber,this.productName,this.brandName,this.amountOfMemory,this.screenSize,this.ram));
    }
    public void remove(){
        System.out.println("Enter product ID that you want to remove:");
        int removingid= input.nextInt();
        noteBooks.removeIf(notebook -> notebook.getId() == removingid);

    }

    public void filteredById(int targetId){
        List<Notebooks> filteredListById = noteBooks.stream()
                .filter(notebook -> notebook.getId() == targetId)
                .collect(Collectors.toList());

        // Filtrelenmiş listeyi yazdır
        getListBrands(filteredListById);

    }
    public void filteredByBrand(String targetBrand){
            List<Notebooks> filteredListByBrand = noteBooks.stream()
                .filter(notebooks -> notebooks.getBrandName().equalsIgnoreCase(targetBrand))
                .collect(Collectors.toList());

        // Filtrelenmiş listeyi yazdır
        getListBrands(filteredListByBrand);
    }

}
