import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MobilePhones extends Products{
    static ArrayList<MobilePhones> mobilePhones= new ArrayList<>();
    private int batteryPower;
    private int kamera;
    private String color;
    static{
        mobilePhones.add(new MobilePhones(1,3199.0,0,5,"SAMSUNG GALAXY A51","Samsung",128,6.5,32,4000,"Siyah",32));
        mobilePhones.add(new MobilePhones(2,7379.0,0,5,"iPhone 11 64 GB","Apple",64,6.1,5,3046,"Mavi",5));
        mobilePhones.add(new MobilePhones(3,4012.0,0,5,"Redmi Note 10 Pro 8GB","Xiaomi",128,6.5,35,4000,"Beyaz",35));
    }
    public MobilePhones(int id, double price, int amountOfDiscount, int stockNumber, String productName, String brandName, int amountOfMemory, double screenSize, int ram, int batteryPower, String color,int kamera) {
        super(id, price, amountOfDiscount, stockNumber, productName, brandName, amountOfMemory, screenSize, ram);
        this.batteryPower = batteryPower;
        this.color = color;
        this.kamera=kamera;
    }
    public MobilePhones(){
        super();
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public int getKamera() {
        return kamera;
    }

    public void setKamera(int kamera) {
        this.kamera = kamera;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void getListBrands(){
        System.out.println("Notebook List");

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s |\n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM","Kamera","Pil","Renk");
        System.out.println("----------------------------------------------------------------------------------------------------");
        printProductInfo(mobilePhones);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        return;
    }
    public void getListBrands(List<MobilePhones> mobilePhone){
        System.out.println("Mobile Phones List");

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s |\n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM","Kamera","Pil","Renk");
        System.out.println("----------------------------------------------------------------------------------------------------");
        printProductInfo(mobilePhone);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        return;
    }
    private static void printProductInfo(List<MobilePhones> mobilePhone) {
        for(MobilePhones list : mobilePhone){
            System.out.printf("| %-3d TL | %-30s | %-9.2f | %-9s | %-9d | %-9.1f | %-9d | %-9d | %-9d | %-30s |\n",
                    list.getId(), list.getProductName(), list.getPrice(),
                    list.getBrandName(), list.getAmountOfMemory(), list.getScreenSize(), list.getRam(),list.getKamera(),list.getBatteryPower(),list.getColor());
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

        for (MobilePhones product : mobilePhones) {
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
        System.out.println("Enter the Camera: ");
        this.setKamera(input.nextInt());
        System.out.println();
        System.out.println("Enter the Battery Size: ");
        this.setBatteryPower(input.nextInt());
        input.nextLine();
        System.out.println();
        System.out.println("Enter the Color: ");
        this.setColor(input.nextLine());
        System.out.println();
        this.addNewProduct();
    }
    public void addNewProduct(){
        mobilePhones.add(new MobilePhones(this.getId(),this.price,this.amountOfDiscount,this.stockNumber,this.productName,this.brandName,this.amountOfMemory,this.screenSize,this.ram,this.batteryPower,this.color,this.kamera));
    }
    public void remove(){
        System.out.println("Enter product ID that you want to remove:");
        int removingid= input.nextInt();
        mobilePhones.removeIf(mobilephone -> mobilephone.getId() == removingid);

    }
    public void filteredById(int targetId){
        List<MobilePhones> filteredListById = mobilePhones.stream()
                .filter(notebook -> notebook.getId() == targetId)
                .collect(Collectors.toList());

        // Filtrelenmiş listeyi yazdır
            getListBrands(filteredListById);

    }
    public void filteredByBrand(String targetBrand){
        List<MobilePhones> filteredListByBrand = mobilePhones.stream()
                .filter(mobilePhones1 -> mobilePhones1.getBrandName().equalsIgnoreCase(targetBrand))
                .collect(Collectors.toList());

        // Filtrelenmiş listeyi yazdır
                getListBrands(filteredListByBrand);
    }
}
