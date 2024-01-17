import java.util.Scanner;

public class Store {
    String Name;
    Brands brands;
    Notebooks notebooks = new Notebooks();
    MobilePhones mobilephones = new MobilePhones();
    Scanner input= new Scanner(System.in);
    public Store(String name) {
        this.Name = name;
        start();
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }
    void start() {
        while (true) {
            System.out.println("PatikaStore Product Management Panel !");
            System.out.println("1 - Notebook Operations");
            System.out.println("2 - Mobile Phone Operations");
            System.out.println("3 - Show our brands");
            System.out.println("0 - Quit");
            Brands brand = new Brands();
            System.out.print("Your Operations: ");
            switch (input.nextInt()) {
                case 0:
                    quit();
                    break;
                case 1:
                    notebookOperation();
                    break;
                case 2:
                    mobilePhonesOperation();
                    break;
                case 3:
                    getListBrand(brand);
                    break;
                default:
                    System.out.println("Invalid operations");
                    break;
            }

        }
    }
    void getListBrand(Brands brand){
        System.out.println("Our Brands");
        System.out.println("--------------");
        brand.getListBrands();
    }
    void quit(){
        System.exit(0);
    }
    void mobilePhonesOperation(){
        System.out.println("Mobile Phones Operations");
        System.out.println("1 - List All Products");
        System.out.println("2 - Add new phone");
        System.out.println("3 - Remove product");
        System.out.println("4- Filtered By ID");
        System.out.println("5- Filtered By Brand");
        System.out.println("0 - Quit");
        System.out.print("Your Operation: ");
        switch (input.nextInt()){
            case 0: quit(); break;
            case 1:  mobilephones.getListBrands();   break;
            case 2:  mobilephones.setProduct();     break;
            case 3: ;mobilephones.remove();         break;
            case 4:
                System.out.println("Enter the filter Id:");
                int filteredID=input.nextInt();
                mobilephones.filteredById(filteredID); break;
            case 5:
                input.nextLine();
                System.out.println("Enter the filter Brand:");
                String filteredBrand=input.nextLine();
                mobilephones.filteredByBrand(filteredBrand); break;
            default:
                System.out.println("Invalid operations");
                break;
        }
    }
    void notebookOperation(){
        System.out.println("Notebook Operations");
        System.out.println("1 - List All Products");
        System.out.println("2 - Add new notebook");
        System.out.println("3 - Remove product");
        System.out.println("4- Filtre by Id");
        System.out.println("5- Filtre by Brand");
        System.out.println("0 - Quit");
        System.out.print("Your Operation: ");
        switch (input.nextInt()){
            case 0: quit(); break;
            case 1:  notebooks.getListBrands();   break;
            case 2:  notebooks.setProduct();     break;
            case 3: ;notebooks.remove();         break;
            case 4:
                System.out.println("Enter the filter Id:");
                int filteredID=input.nextInt();
                notebooks.filteredById(filteredID); break;
            case 5:
                input.nextLine();
                System.out.println("Enter the filter Brand:");
                String filteredBrand=input.nextLine();
                notebooks.filteredByBrand(filteredBrand); break;
            default:
                System.out.println("Invalid operations");
                break;
        }
    }
}
