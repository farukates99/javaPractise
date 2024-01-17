import java.util.ArrayList;
import java.util.TreeSet;

public class Brands implements Comparable<Brands>{
    private int id;
    private String brandName;
    static TreeSet<Brands> brands= new TreeSet<>();
    static {
        String[] allBrands={"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};
        for(int i=0; i<allBrands.length;i++){
            brands.add(new Brands(i+1,allBrands[i]));
        }

    }
    public void getListBrands(){
        for(Brands brandNames : brands){
            System.out.print("-");
            System.out.println(brandNames.brandName);
        }
        return;
    }
    public static TreeSet<Brands> getBrands() {
        return brands;
    }

    public static void setBrands(TreeSet<Brands> brands) {
        Brands.brands = brands;
    }

    public Brands(){

    }
    public Brands(int id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public int compareTo(Brands o) {

        return this.getBrandName().compareTo(o.getBrandName());
    };

}
