import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

abstract public class Products {
    Scanner input= new Scanner(System.in);
    Brands brandP=new Brands();

    protected int id;
    protected double price;
    protected int amountOfDiscount;
    protected int stockNumber;
    protected String productName;
    protected String brandName;
    protected int amountOfMemory;
    protected double screenSize;
    protected int ram;
    public Products(int id, double price, int amountOfDiscount, int stockNumber, String productName, String brandName, int amountOfMemory, double screenSize, int ram) {
        this.id = id;
        this.price = price;
        this.amountOfDiscount = amountOfDiscount;
        this.stockNumber = stockNumber;
        this.productName = productName;
        this.brandName = brandName;
        this.amountOfMemory = amountOfMemory;
        this.screenSize = screenSize;
        this.ram = ram;
    }

    public Products() {

    }

    public int getId() {
        return id;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        this.price = price*(100-this.amountOfDiscount)/100;
    }

    public int getAmountOfDiscount() {
        return amountOfDiscount;
    }

    public void setAmountOfDiscount(int amountOfDiscount) {
        this.amountOfDiscount = amountOfDiscount;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        while(isBrandExist(brandName)) {
            System.out.println("There is no brand like that");
            System.out.print("Enter the another valid brand:");
            brandName=input.nextLine();
            System.out.println();
        }
        System.out.println(brandName);
        this.brandName = brandName;
    }
    private boolean isBrandExist(String brand) {

        for (Brands product : brandP.getBrands()) {
            if (product.getBrandName().contains(brand) ) {
                return false; // Id zaten mevcut, eşsiz değil
            }
        }
        return true; // Id eşsiz
    }

    public int getAmountOfMemory() {
        return amountOfMemory;
    }

    public void setAmountOfMemory(int amountOfMemory) {
        this.amountOfMemory = amountOfMemory;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }



}
