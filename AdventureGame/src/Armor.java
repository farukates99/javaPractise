public class Armor {
    private int id;
    private int protect;
    private int price;
    private String name;

    public Armor(int id, int protect, int price, String name) {
        this.id = id;
        this.protect = protect;
        this.price = price;
        this.name = name;
    }

    public static Armor[] armors() {

        Armor[] armors = {new Armor(1, 1, 15, "Light"),
                new Armor(2,3,25,"Medium"),
                new Armor(3,5,40,"Hard")};
        return armors;
    }
    public static Armor getArmorObj(int id) {
        for (Armor a : Armor.armors()) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProtect() {
        return protect;
    }

    public void setProtect(int protect) {
        this.protect = protect;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
